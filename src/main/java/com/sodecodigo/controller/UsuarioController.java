/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodecodigo.controller;

import com.sodecodigo.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "usuarioController")
public class UsuarioController extends AbstractController{
    public static final String INJECTION_NAME = "#{usuarioController}";
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public String logOut(){
        getRequest().getSession().invalidate();
        return "login.xhtml";
    } 
    
    public String admin(){
        return "/pages/protected/admin/admin.xhtml?faces-redirect=true";
    } 
}
