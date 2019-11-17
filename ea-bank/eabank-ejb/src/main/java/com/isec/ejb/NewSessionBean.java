/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public void businessMethod() {
        
        System.out.println("nothing to do here");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
