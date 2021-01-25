package com.example.demo.service;

import com.example.demo.dao.MemberDao;
import com.example.demo.entity.LoginUserDetails;
import com.example.demo.entity.Member;
import com.example.demo.dao.MemberDao;
import com.example.demo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LoginMemberDetailsService implements UserDetailsService {


    @Autowired
    MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String memberName)
            throws UsernameNotFoundException {
        Member member = memberDao.selectByName(memberName);


        if (member == null) {
            throw new UsernameNotFoundException(memberName + "is not found.");
        }
        return new LoginUserDetails(member,getAuthorities(member.getRoleName()));

    }

    private Collection<GrantedAuthority> getAuthorities(String roleName){
        return AuthorityUtils.createAuthorityList("ROLE_" + roleName);
    }
}
