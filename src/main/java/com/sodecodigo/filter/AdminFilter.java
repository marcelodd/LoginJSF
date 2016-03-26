/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodecodigo.filter;

import com.sodecodigo.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/pages/protected/admin/*" ,servletNames = "{Faces Servlet}")
public class AdminFilter extends AbstractFilter implements Filter{

    public void init(FilterConfig fc) throws ServletException {
        
    }

    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        
        Usuario user = (Usuario) request.getSession(true).getAttribute("user");
        
        if(!user.isAdmin()){
            accessDenied(sr, sr1, request);
            return;
        }
        fc.doFilter(sr, sr1);
    }

    public void destroy() {
        
    }
    
}
