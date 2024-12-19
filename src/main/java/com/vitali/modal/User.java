package com.vitali.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vitali.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id // it's a unique identifier for this class
    @GeneratedValue(strategy = GenerationType.AUTO) //when a new user created id will create automatically
    private Long id;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //password will be only writable
    private String password;

    public TwoFactorAuth getTwoFactorAuth() {
        return twoFactorAuth;
    }


    public void setTwoFactorAuth(TwoFactorAuth twoFactorAuth) {
        this.twoFactorAuth = twoFactorAuth;
    }

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;


}
