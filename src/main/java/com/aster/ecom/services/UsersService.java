package com.aster.ecom.services;

import com.aster.ecom.domain.Users;

import javax.naming.AuthenticationException;
import java.util.List;


public interface UsersService {
    Users registerUser(Users users);

    Users login(String email, String password) throws AuthenticationException;

    Users deactivateUser(String email);

}

