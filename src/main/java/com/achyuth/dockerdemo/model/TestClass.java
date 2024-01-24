package com.achyuth.dockerdemo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "test")
@Data
public class TestClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String name;
}
