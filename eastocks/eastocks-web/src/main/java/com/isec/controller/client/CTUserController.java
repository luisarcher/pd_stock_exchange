package com.isec.controller.client;

import com.isec.controller.util.JsfUtil;
import com.isec.manager.UserAccountManager;
import com.isec.stocks.dto.DTOStocksUser;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Named("ctUserController")
@SessionScoped
public class CTUserController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /* ------ Form fields ----- */
    
    // Save login credentials from login dialog
    private String userLogin;
    private String userPasswd;
    
    private DTOStocksUser selected;
    private List<DTOStocksUser> items = null;
    
    // New User
    private DTOStocksUser newUser;
    
    /* ------ Form fields ends ----- */
    
    @EJB
    private UserAccountManager stocksManager;
    
    private DTOStocksUser loggedInUser;
    
    public CTUserController() {
        
        if (this.stocksManager == null){
            this.stocksManager = lookupUserAccountManagerBean();
        }
        prepareCreate();
    }
    
    /* ------ Business Methods ----- */
    public void login(){
        this.loggedInUser = stocksManager.loginv2(userLogin, userPasswd);
        
        System.err.println("Atempting to login with: " + userLogin + " and " + userPasswd);
        
        
        if(loggedInUser != null){
            
            JsfUtil.addSuccessMessage("Login Success!");
            //JsfUtil.redirect("/pages/portofolio.xhtml");
        }
        else {
            JsfUtil.addErrorMessage("Login Failed!"); 
        }
    }
    
    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext()
        .invalidateSession();
        this.loggedInUser = null;
    }
    
    public void register(){
        stocksManager.register(newUser);
        //JsfUtil.redirect("/pages/index.xhtml");
    }
    
    /* ------ Business Methods ends ----- */
    
    private void prepareCreate() {
        newUser = new DTOStocksUser();
    }
    
    public DTOStocksUser getDTOStocksUser(int id){
        return stocksManager.getUserById(id);
    }
    
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
    private UserAccountManager lookupUserAccountManagerBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UserAccountManager) c.lookup("java:global/eastocks-ear-1.0-SNAPSHOT/eastocks-ejb-1.0-SNAPSHOT/UserAccountManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public DTOStocksUser getSelected() {
        return selected;
    }

    public void setSelected(DTOStocksUser selected) {
        this.selected = selected;
    }

    public List<DTOStocksUser> getItems() {
        return items;
    }

    public void setItems(List<DTOStocksUser> items) {
        this.items = items;
    }
    
    @FacesConverter(forClass = DTOStocksUser.class)
    public static class CTUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CTUserController controller = (CTUserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ctUserController");
            return controller.getDTOStocksUser(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DTOStocksUser) {
                DTOStocksUser o = (DTOStocksUser) object;
                return getStringKey(o.getIdUser());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DTOStocksUser.class.getName()});
                return null;
            }
        }

    }
    
    /* ------ Getters and Setters ----- */
    
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public UserAccountManager getStocksManager() {
        return stocksManager;
    }

    public void setStocksManager(UserAccountManager stocksManager) {
        this.stocksManager = stocksManager;
    }

    public DTOStocksUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(DTOStocksUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public DTOStocksUser getNewUser() {
        return newUser;
    }

    public void setNewUser(DTOStocksUser newUser) {
        this.newUser = newUser;
    }
    
    
}
