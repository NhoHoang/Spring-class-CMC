package com.bdb.spring.demo.entity;

import com.bdb.spring.demo.constant.Gender;
import com.bdb.spring.demo.constant.Permission;
import com.bdb.spring.demo.converter.GenderEnumConverter;
import com.bdb.spring.demo.converter.PermissionEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Transient
    private String transientField = "transient";

    @Convert(converter = GenderEnumConverter.class)
    private Gender gender;

    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_permission", joinColumns = {@JoinColumn(name = "user_id")})
    @Column(name = "permission")
    @Convert(converter = PermissionEnumConverter.class)
    private List<Permission> permissions;

    @OneToOne(mappedBy = "user")
    private Identity identity;

    public User(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}
