package com.packtpub.springsecurity.web.controllers;

import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * Demonstrates how to conditionally automatically request log in from an OpenID Provider. This same strategy could be
 * used to display a different login page to users. While we use a Spring MVC controller, there is nothing that would
 * prevent us from using any other controller (i.e. Struts, a standard Servlet, etc).
 * </p>
 * <h2>Configuration</h2>
 * <p>
 * To use this simply point Spring Security's login-page element to the URL processed by this Controller. As shown
 * below:
 *
 * <pre>
 * &lt;http auto-config="true"&gt;
 *   ...
 *   &lt;openid-login login-page="/login/check"/&gt;
 * &lt;/http&gt;
 * </pre>
 *
 * To use it with standard form login you can use the login-page element on the form-login element:
 *
 * <pre>
 * &lt;http auto-config="true"&gt;
 *   ...
 *   &lt;form-login login-page="/login/check"/&gt;
 * &lt;/http&gt;
 * </pre>
 *
 * <h2>Alternative Methods</h2>
 * <p>
 * This could be implemented by plugging in a {@link DelegatingAuthenticationEntryPoint} and writing a custom
 * {@link RequestMatcher}. However, this approach is quite a bit more verbose and requires implementing Spring Security
 * APIs. The advantage to the approach we use here is that the implementation is in no way coupled to Spring Security.
 * This is quite similar to how we created a custom DefaultController in Chapter 2.
 * </p>
 *
 * @author Rob Winch
 *
 */
@Controller
public class ConditionalLoginPageController {

    /**
     * If the cookie by the name of openid_provider contains a value of "google" then request authentication from
     * google. Otherwise, display the login form. This example could easily be extended to work with other providers,
     * but is meant to be a simple example.
     *
     * @param openidProvider
     * @return
     */
    @RequestMapping("/login/check")
    public String check(@CookieValue(required = false) String openid_provider) {
        if ("google".equals(openid_provider)) {
            return "redirect:/login?openid_identifier=https://www.google.com/accounts/o8/id";
        }
        return "redirect:/login/form";
    }
}
