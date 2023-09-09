package org.example.entities;

import lombok.Data;
import org.example.entities.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tblProductImages")
public class ProductImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 35, nullable = false)
    private String name;
    @Column(length = 200)
    private String priority;
    @Column(name = "isDeleted",nullable = false)
    private boolean isDeleted;
    @Column(name = "dateCreated",nullable = false)
    private Date dateCreated;



    @ManyToOne()
    @JoinColumn(name = "productId", nullable = false)
    private Product product;
}