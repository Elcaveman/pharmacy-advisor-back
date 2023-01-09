package com.example.pharmacieapi.entity;

import com.example.pharmacieapi.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Date created_at;
    @Transient
    private Date updated_at;

    private String userRole = "ADMIN";
    @OneToOne(mappedBy = "user",fetch=FetchType.EAGER)
    private Pharmacie pharmacie;

    public String getRoles() {
        return "ADMIN";
    }
}
