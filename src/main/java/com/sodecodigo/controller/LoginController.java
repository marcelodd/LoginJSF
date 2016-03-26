/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodecodigo.controller;

import com.sodecodigo.controller.UsuarioController;
import com.sodecodigo.controller.AbstractController;
import com.sodecodigo.dao.UsuarioDao;
import com.sodecodigo.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@ManagedBean
public class LoginController extends AbstractController {

    @ManagedProperty(value = UsuarioController.INJECTION_NAME)
    private UsuarioController usuarioController;

    private String loginOrEmail;
    private String password;

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public String getLogin() {
        return loginOrEmail;
    }

    public void setLogin(String login) {
        this.loginOrEmail = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Usuario isValidLogin(String loginOrEmail, String password) {
         Usuario user;
         
        if(isEmail(loginOrEmail)){
            user = new UsuarioDao().findByEmail(loginOrEmail);
        }else{
            user = new UsuarioDao().findByLogin(loginOrEmail);
        }
        
        if (user == null || !password.equals(user.getSenha())) {
            return null;
        }
        return user;
    }
    
    private boolean isEmail(String value){
        return value.contains("@");
    }

    public String entrar() {
        Usuario user = isValidLogin(loginOrEmail, password);

        if (user != null) {
            usuarioController.setUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("user", user);
            return "index.xhtml";
        }
        displayErrorMessage("Check your login/password");
        return null;
    }

}
