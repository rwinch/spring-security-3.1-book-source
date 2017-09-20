package com.packtpub.springsecurity;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.RequestMatcher;

public class RichfacesRequestMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        System.out.println(Collections.list(request.getHeaderNames()));
        return request.getHeader("faces-request") != null;
    }
}
