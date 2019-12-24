package com.isec.controller.client;

import com.isec.controller.util.JsfUtil;
import com.isec.manager.UserAccountManager;
import com.isec.stocks.dto.DTOStocksUser;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Named("ctUserController")
@SessionScoped
public class CTUserController implements Serializable {
    
    /* ------ Form fields ----- */
    
    // Save login credentials from login dialog
    private String userLogin;
    private String userPasswd;
    
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
        
        loggedInUser = stocksManager.loginv2(userLogin, userPasswd);
        if(loggedInUser != null){
            
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("loginSuccess"));
        }
        else {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("loginFailed")); 
        }
    }
    
    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext()
        .invalidateSession();
        this.loggedInUser = null;
    }
    
    public void register(){
        
    }
    
    /* ------ Business Methods ends ----- */
    
    private void prepareCreate() {
        newUser = new DTOStocksUser();
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
