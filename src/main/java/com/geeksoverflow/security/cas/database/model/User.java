package com.geeksoverflow.security.cas.database.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author <a href="mailto:psunil1278@gmail.com">Sunil Kumar</a>
 * @since 25/12/15
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @Column(name = "USERID", nullable = false, length = 32)
    private String userId;

    @Column(name = "USERNAME", nullable = true, length = 32)
    private String username;

    @Column(name = "PASSWORD", nullable = true, length = 32)
    private String password;

    @Column(name = "PHONE_NO", nullable = true, length = 20)
    private String phoneno;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private Integer active;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(final String userId, final String username,final String password, final String phoneno, final Integer active, final Set<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.active = active;
        this.phoneno = phoneno;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(final String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
