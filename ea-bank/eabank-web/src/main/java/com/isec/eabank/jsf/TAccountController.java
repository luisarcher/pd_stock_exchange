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
import com.isec.eabank.facade.TAccountFacade;
import com.isec.jpa.TAccount;
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
public class TAccountController {

    public TAccountController() {
        pagingInfo = new PagingInfo();
        converter = new TAccountConverter();
    }
    private TAccount TAccount = null;
    private List<TAccount> TAccountItems = null;
    private TAccountFacade jpaController = null;
    private TAccountConverter converter = null;
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

    public TAccountFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TAccountFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tAccountJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTAccountItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTAccountItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TAccount getTAccount() {
        if (TAccount == null) {
            TAccount = (TAccount) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTAccount", converter, null);
        }
        if (TAccount == null) {
            TAccount = new TAccount();
        }
        return TAccount;
    }

    public String listSetup() {
        reset(true);
        return "TAccount_list";
    }

    public String createSetup() {
        reset(false);
        TAccount = new TAccount();
        return "TAccount_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TAccount);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TAccount was successfully created.");
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
        return scalarSetup("TAccount_detail");
    }

    public String editSetup() {
        return scalarSetup("TAccount_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TAccount = (TAccount) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTAccount", converter, null);
        if (TAccount == null) {
            String requestTAccountString = JsfUtil.getRequestParameter("jsfcrud.currentTAccount");
            JsfUtil.addErrorMessage("The TAccount with id " + requestTAccountString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, TAccount);
        String currentTAccountString = JsfUtil.getRequestParameter("jsfcrud.currentTAccount");
        if (TAccountString == null || TAccountString.length() == 0 || !TAccountString.equals(currentTAccountString)) {
            String outcome = editSetup();
            if ("TAccount_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TAccount. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TAccount);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TAccount was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTAccount");
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
                JsfUtil.addSuccessMessage("TAccount was successfully deleted.");
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

    public List<TAccount> getTAccountItems() {
        if (TAccountItems == null) {
            getPagingInfo();
            TAccountItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TAccountItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TAccount_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TAccount_list";
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
        TAccount = null;
        TAccountItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TAccount newTAccount = new TAccount();
        String newTAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTAccount);
        String TAccountString = converter.getAsString(FacesContext.getCurrentInstance(), null, TAccount);
        if (!newTAccountString.equals(TAccountString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
