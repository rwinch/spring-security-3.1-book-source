package com.packtpub.springsecurity.events.server.domain;

import org.springframework.security.access.prepost.PreAuthorize;

public aspect EventSecurity {
    declare @method: public long Event.countEvents(): @PreAuthorize("hasRole('ROLE_ADMIN')");
}
