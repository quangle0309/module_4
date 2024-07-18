package com.example.web_blog.services.impl;

import com.example.web_blog.dtos.UserInfoUserDetails;
import com.example.web_blog.model.AppUser;
import com.example.web_blog.model.UserRole;
import com.example.web_blog.repositories.IUserRepository;
import com.example.web_blog.repositories.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
//        Lấy tất cả role của AppUser
        List<UserRole> userRoles = iUserRoleRepository.findAllByAppUser(appUser);
        UserInfoUserDetails infoUserDetails = new UserInfoUserDetails(appUser, userRoles);
        return infoUserDetails;
    }
}
