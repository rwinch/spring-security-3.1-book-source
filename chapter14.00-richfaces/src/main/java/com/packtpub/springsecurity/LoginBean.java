package com.packtpub.springsecurity;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class LoginBean {
    private AuthenticationManager authenticationManager;

    private String username;
    private String password;

    @Autowired
    public LoginBean(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String login() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContext sContext = SecurityContextHolder.getContext();
            sContext.setAuthentication(authentication);
            return "success";
        } catch (AuthenticationException loginError) {
            FacesContext fContext = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Invalid username/password. Reason " + loginError.getMessage());
            fContext.addMessage("login",  message);
            return "fail";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
