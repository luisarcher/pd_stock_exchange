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
import com.isec.eabank.facade.TUserFacade;
import com.isec.jpa.TUser;
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
public class TUserController {

    public TUserController() {
        pagingInfo = new PagingInfo();
        converter = new TUserConverter();
    }
    private TUser TUser = null;
    private List<TUser> TUserItems = null;
    private TUserFacade jpaController = null;
    private TUserConverter converter = null;
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

    public TUserFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TUserFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tUserJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTUserItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTUserItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TUser getTUser() {
        if (TUser == null) {
            TUser = (TUser) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTUser", converter, null);
        }
        if (TUser == null) {
            TUser = new TUser();
        }
        return TUser;
    }

    public String listSetup() {
        reset(true);
        return "TUser_list";
    }

    public String createSetup() {
        reset(false);
        TUser = new TUser();
        return "TUser_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TUser);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TUser was successfully created.");
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
        return scalarSetup("TUser_detail");
    }

    public String editSetup() {
        return scalarSetup("TUser_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TUser = (TUser) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTUser", converter, null);
        if (TUser == null) {
            String requestTUserString = JsfUtil.getRequestParameter("jsfcrud.currentTUser");
            JsfUtil.addErrorMessage("The TUser with id " + requestTUserString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TUserString = converter.getAsString(FacesContext.getCurrentInstance(), null, TUser);
        String currentTUserString = JsfUtil.getRequestParameter("jsfcrud.currentTUser");
        if (TUserString == null || TUserString.length() == 0 || !TUserString.equals(currentTUserString)) {
            String outcome = editSetup();
            if ("TUser_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TUser. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TUser);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TUser was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTUser");
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
                JsfUtil.addSuccessMessage("TUser was successfully deleted.");
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

    public List<TUser> getTUserItems() {
        if (TUserItems == null) {
            getPagingInfo();
            TUserItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TUserItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TUser_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TUser_list";
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
        TUser = null;
        TUserItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TUser newTUser = new TUser();
        String newTUserString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTUser);
        String TUserString = converter.getAsString(FacesContext.getCurrentInstance(), null, TUser);
        if (!newTUserString.equals(TUserString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
