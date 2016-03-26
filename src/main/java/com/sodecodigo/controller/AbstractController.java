/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodecodigo.controller;

import com.sodecodigo.util.JSFMessageUtil;
import com.sodecodigo.util.JSFMessageUtil;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MARCELO-PC
 */
public class AbstractController {
     private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
 
    public AbstractController() {
        super();
    }
    
    protected void displayErrorMessage(String message){
        JSFMessageUtil jsfmu = new JSFMessageUtil();
        jsfmu.sendErrorMessage(message);
    }
    
    protected void displayInfoMessage(String message){
        JSFMessageUtil jsfmu = new JSFMessageUtil();
        jsfmu.sendInfoMessage(message);
    }
    
    protected void closeDialog(){
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
    }
    
    protected void keepDialogOpen(){
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
    }
 
    protected RequestContext getRequestContext(){
        return RequestContext.getCurrentInstance();
    }  
    
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
