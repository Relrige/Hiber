package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="tblCategories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name", nullable = false, length = 100)
    private String name;
    @Column(length = 5000, nullable = false)
    private String image;
    @Column(name = "isDeleted",nullable = false)
    private boolean isDeleted;
    @Column(name = "dateCreated",nullable = false)
    private Date dateCreated;

}
