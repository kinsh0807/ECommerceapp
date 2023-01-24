package com.aster.ecom.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class Users {

    @Id
    private long u_id;
    @Pattern(regexp = "^[a-zA-Z]{6,12}$",
            message = "Cannot be empty and max 15 character allowed")
    private String firstname;
    private String lastname;
    private String Email;
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$", message ="Minimum 8 characters, 1 upper case, 1 lower case and 1 special character(from @#$&)." )
    private String password;
    @Pattern(regexp = "((?=.*[0-9]))",message = "10 digits allowed")
    private String mobilenumber;
    private boolean Active;

    @OneToOne(mappedBy = "cart_id", cascade = CascadeType.ALL)
    private Cart cart;

}
