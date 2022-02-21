package com.example.demo.presentation.type;

/**
 * @author okato
 */
public enum Role {
    ADMINISTER("ADMIN"), USER("USER");

    public String value;

    Role(String role) {
        this.value = role;
    }
}
