package com.example.demo.entity;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
public class Position {

    public Position() {}

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NonNull
    @Column(name="name")
    private String name;


}
