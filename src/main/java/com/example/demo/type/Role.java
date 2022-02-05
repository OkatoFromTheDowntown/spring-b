package com.example.demo.type;

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
