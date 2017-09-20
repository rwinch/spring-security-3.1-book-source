package com.packtpub.springsecurity;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionHandler;

public class JsfDefaultWebSecurityExpressionhandler implements WebSecurityExpressionHandler, SecurityExpressionHandler<FilterInvocation> {
    private DefaultWebSecurityExpressionHandler delegate = new DefaultWebSecurityExpressionHandler();

    @Override
    public ExpressionParser getExpressionParser() {
        return delegate.getExpressionParser();
    }

    @Override
    public EvaluationContext createEvaluationContext(Authentication authentication, FilterInvocation invocation) {
        return delegate.createEvaluationContext(authentication, invocation);
    }
}