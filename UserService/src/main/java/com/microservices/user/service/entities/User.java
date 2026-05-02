package com.microservices.user.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users_service")
@Data
@NoArgsConstructor        // ✅ REQUIRED
@AllArgsConstructor
@Builder // When you use @Builder, Lombok does NOT generate a default constructor.
public class User {

    @Id
    private String userId;
    @Column(name="user_name",length = 20)
    private String name;
    private String email;
    private String about;


    //“@Transient is used to exclude a field from database mapping so that it is not persisted by JPA.”✔ It will not be stored in DB
    @Transient                                                                                                               //It will not be mapped to any column
    private List<Rating> ratings = new ArrayList<>();

}
