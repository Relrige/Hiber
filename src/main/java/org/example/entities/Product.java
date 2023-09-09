package org.example.entities;

import lombok.Data;
import org.example.entities.Category;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tblProducts")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 35, nullable = false)
    private String name;
    @Column(length = 200)
    private String description;
    @Column(name = "isDeleted",nullable = false)
    private boolean isDeleted;
    @Column(name = "dateCreated",nullable = false)
    private Date dateCreated;



    @ManyToOne()
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}