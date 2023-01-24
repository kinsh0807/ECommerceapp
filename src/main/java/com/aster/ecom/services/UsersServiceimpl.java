package com.aster.ecom.services;

import com.aster.ecom.domain.Users;
import com.aster.ecom.reposit.UsersRepository;

import javax.naming.AuthenticationException;

public class UsersServiceimpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceimpl(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    @Override
    public Users registerUser(Users users) {
        //validate user fields
        return usersRepository.save(users);
    }

    @Override
    public Users login(String email, String password) throws AuthenticationException {
        //validate email and password
        Users users = usersRepository.findByEmail(email);
        if(users == null || !password.equals(users.getPassword())) {
            throw new AuthenticationException("Incorrect email or password");
        }
        return users;
    }

    @Override
    public Users deactivateUser(String email) {
        //validate email
        Users users = usersRepository.findByEmail(email);
        users.setActive(false);
        return usersRepository.save(users);
    }
}
