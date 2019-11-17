/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabank.jsf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import com.isec.eabank.jsf.util.JsfUtil;
import com.isec.eabank.jsf.util.PagingInfo;
import com.isec.eabank.facade.TMovementFacade;
import com.isec.jpa.TMovement;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author ljordao
 */
public class TMovementController {

    public TMovementController() {
        pagingInfo = new PagingInfo();
        converter = new TMovementConverter();
    }
    private TMovement TMovement = null;
    private List<TMovement> TMovementItems = null;
    private TMovementFacade jpaController = null;
    private TMovementConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "webPU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public TMovementFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TMovementFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tMovementJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTMovementItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTMovementItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TMovement getTMovement() {
        if (TMovement == null) {
            TMovement = (TMovement) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTMovement", converter, null);
        }
        if (TMovement == null) {
            TMovement = new TMovement();
        }
        return TMovement;
    }

    public String listSetup() {
        reset(true);
        return "TMovement_list";
    }

    public String createSetup() {
        reset(false);
        TMovement = new TMovement();
        return "TMovement_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TMovement);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TMovement was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("TMovement_detail");
    }

    public String editSetup() {
        return scalarSetup("TMovement_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TMovement = (TMovement) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTMovement", converter, null);
        if (TMovement == null) {
            String requestTMovementString = JsfUtil.getRequestParameter("jsfcrud.currentTMovement");
            JsfUtil.addErrorMessage("The TMovement with id " + requestTMovementString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TMovementString = converter.getAsString(FacesContext.getCurrentInstance(), null, TMovement);
        String currentTMovementString = JsfUtil.getRequestParameter("jsfcrud.currentTMovement");
        if (TMovementString == null || TMovementString.length() == 0 || !TMovementString.equals(currentTMovementString)) {
            String outcome = editSetup();
            if ("TMovement_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TMovement. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TMovement);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TMovement was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTMovement");
        Integer id = new Integer(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TMovement was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();

        return listSetup();
    }

    public List<TMovement> getTMovementItems() {
        if (TMovementItems == null) {
            getPagingInfo();
            TMovementItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TMovementItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TMovement_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TMovement_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        TMovement = null;
        TMovementItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TMovement newTMovement = new TMovement();
        String newTMovementString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTMovement);
        String TMovementString = converter.getAsString(FacesContext.getCurrentInstance(), null, TMovement);
        if (!newTMovementString.equals(TMovementString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
