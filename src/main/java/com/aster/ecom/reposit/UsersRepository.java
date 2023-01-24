package com.aster.ecom.reposit;

import com.aster.ecom.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);

    Users findByEmail(String email);
}
