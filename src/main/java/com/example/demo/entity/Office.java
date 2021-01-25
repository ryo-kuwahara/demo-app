package com.example.demo.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "offices")
@Data
public class Office {
    public Office() {}

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NonNull
    @Column(name="name")
    private String name;



}
