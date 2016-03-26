/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodecodigo.dao;

import com.sodecodigo.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario>{

    public UsuarioDao() {
        super(Usuario.class);
    }
    
    public Usuario findByLogin(String login){
        return createNamedQuery("Usuario.findByLogin").setParameter("login", login).getSingleResult();
    }
    
    public Usuario findByEmail(String email){
        return createNamedQuery("Usuario.findByEmail").setParameter("email", email).getSingleResult();
    }
}
