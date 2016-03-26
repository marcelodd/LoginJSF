/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodecodigo.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARCELO-PC
 */
public class JSFMessageUtil {
     public void sendInfoMessage(String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
        addMessageToJsfContext(facesMessage);
    }
 
    public void sendErrorMessage(String message) {
        FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
        addMessageToJsfContext(facesMessage);
    }
 
    private FacesMessage createMessage(FacesMessage.Severity severity, String mensagemErro) {
        return new FacesMessage(severity, mensagemErro, mensagemErro);
    }
 
    private void addMessageToJsfContext(FacesMessage facesMessage) {
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
