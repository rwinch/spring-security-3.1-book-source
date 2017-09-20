package com.packtpub.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.packtpub.springsecurity.domain.CalendarUser;

/**
 * An implementation of {@link UserContext} that looks up the {@link CalendarUser} using the Spring Security's
 * {@link Authentication} by principal name.
 *
 * @author Rob Winch
 *
 */
public class SpringSecurityUserContext implements UserContext {
    private final CalendarService calendarService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SpringSecurityUserContext(CalendarService calendarService,UserDetailsService userDetailsService) {
        if (calendarService == null) {
            throw new IllegalArgumentException("calendarService cannot be null");
        }
        if (userDetailsService == null) {
            throw new IllegalArgumentException("userDetailsService cannot be null");
        }
        this.calendarService = calendarService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Get the {@link CalendarUser} by obtaining the currently logged in Spring Security user's
     * {@link Authentication#getName()} and using that to find the {@link CalendarUser} by email address (since for our
     * application Spring Security usernames are email addresses).
     */
    @Override
    public CalendarUser getCurrentUser() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCurrentUser(CalendarUser user) {
        throw new UnsupportedOperationException();
    }
}
