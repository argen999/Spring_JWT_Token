package com.peaksoft.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CUSTOMER, // satyp aluuchu
    VENDOR // satuuchy
    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
