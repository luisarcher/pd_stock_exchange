package com.isec.controller.client;

import com.isec.jpa.TCompany;
import com.isec.manager.StocksDataManager;
import com.isec.stocks.dto.DTOStocksCompany;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Named("ctStocksController")
@SessionScoped
public class CTStocksController implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @EJB
    private StocksDataManager stocksManager;
    
    private List<TCompany> itemsCompany = null;
    private TCompany selectedCompany;

    public CTStocksController() {
        if (this.stocksManager == null){
            this.stocksManager = lookupStocksDataManagerBean();
        }
    }
    
    public List<DTOStocksCompany> getAllCompanies(){
        return stocksManager.getAllCompanies();
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
    private StocksDataManager lookupStocksDataManagerBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (StocksDataManager) c.lookup("java:global/eastocks-ear-1.0-SNAPSHOT/eastocks-ejb-1.0-SNAPSHOT/StocksDataManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public StocksDataManager getStocksManager() {
        return stocksManager;
    }

    public void setStocksManager(StocksDataManager stocksManager) {
        this.stocksManager = stocksManager;
    }

    public List<TCompany> getItemsCompany() {
        return itemsCompany;
    }

    public void setItemsCompany(List<TCompany> itemsCompany) {
        this.itemsCompany = itemsCompany;
    }

    public TCompany getSelectedCompany() {
        return selectedCompany;
    }

    public void setSelectedCompany(TCompany selectedCompany) {
        this.selectedCompany = selectedCompany;
    }
 

}
