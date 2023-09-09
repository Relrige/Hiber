package org.example.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="tblUserRoles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;
}
