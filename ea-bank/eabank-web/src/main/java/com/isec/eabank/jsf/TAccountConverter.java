/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabank.jsf;

import com.isec.jpa.TAccount;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author ljordao
 */
public class TAccountConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Integer id = new Integer(string);
        TAccountController controller = (TAccountController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tAccount");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TAccount) {
            TAccount o = (TAccount) object;
            return o.getIdAccount() == null ? "" : o.getIdAccount().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.isec.jpa.TAccount");
        }
    }
    
}
