package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class LoginUserDetails implements UserDetails {

    private final Member member;
    private Collection<GrantedAuthority> authorities;

    public LoginUserDetails(Member member, Collection<GrantedAuthority> authorities) {
        this.member = member;
        this.authorities = authorities;
    }

    public Member getUser() {
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
      return this.member.getName();
    }

    @Override
    public String getPassword() {
        return this.member.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
