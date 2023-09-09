package org.example.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="tblRoles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 35, nullable = false)
    private String name;
}
