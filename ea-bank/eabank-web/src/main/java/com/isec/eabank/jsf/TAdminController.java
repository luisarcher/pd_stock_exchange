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
import com.isec.eabank.facade.TAdminFacade;
import com.isec.jpa.TAdmin;
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
public class TAdminController {

    public TAdminController() {
        pagingInfo = new PagingInfo();
        converter = new TAdminConverter();
    }
    private TAdmin TAdmin = null;
    private List<TAdmin> TAdminItems = null;
    private TAdminFacade jpaController = null;
    private TAdminConverter converter = null;
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

    public TAdminFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TAdminFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tAdminJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTAdminItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTAdminItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TAdmin getTAdmin() {
        if (TAdmin == null) {
            TAdmin = (TAdmin) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTAdmin", converter, null);
        }
        if (TAdmin == null) {
            TAdmin = new TAdmin();
        }
        return TAdmin;
    }

    public String listSetup() {
        reset(true);
        return "TAdmin_list";
    }

    public String createSetup() {
        reset(false);
        TAdmin = new TAdmin();
        return "TAdmin_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TAdmin);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TAdmin was successfully created.");
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
        return scalarSetup("TAdmin_detail");
    }

    public String editSetup() {
        return scalarSetup("TAdmin_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TAdmin = (TAdmin) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTAdmin", converter, null);
        if (TAdmin == null) {
            String requestTAdminString = JsfUtil.getRequestParameter("jsfcrud.currentTAdmin");
            JsfUtil.addErrorMessage("The TAdmin with id " + requestTAdminString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TAdminString = converter.getAsString(FacesContext.getCurrentInstance(), null, TAdmin);
        String currentTAdminString = JsfUtil.getRequestParameter("jsfcrud.currentTAdmin");
        if (TAdminString == null || TAdminString.length() == 0 || !TAdminString.equals(currentTAdminString)) {
            String outcome = editSetup();
            if ("TAdmin_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TAdmin. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TAdmin);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TAdmin was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTAdmin");
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
                JsfUtil.addSuccessMessage("TAdmin was successfully deleted.");
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

    public List<TAdmin> getTAdminItems() {
        if (TAdminItems == null) {
            getPagingInfo();
            TAdminItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TAdminItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TAdmin_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TAdmin_list";
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
        TAdmin = null;
        TAdminItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TAdmin newTAdmin = new TAdmin();
        String newTAdminString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTAdmin);
        String TAdminString = converter.getAsString(FacesContext.getCurrentInstance(), null, TAdmin);
        if (!newTAdminString.equals(TAdminString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
