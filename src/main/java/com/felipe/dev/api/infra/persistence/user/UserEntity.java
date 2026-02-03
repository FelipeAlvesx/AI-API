package com.felipe.dev.api.infra.persistence.user;

import com.felipe.dev.api.domain.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public  UserEntity() {
    }
    public UserEntity(String name, String email, UserType userType, String phone) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.phone = phone;
    }

}
