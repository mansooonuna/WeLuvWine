package com.example.weluvwine.wine.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wine_id")
    private Long id;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contry;
    @Column(nullable = false)
    private String grape;
    @Column(nullable = false)
    private Long vintage;
    @Column(nullable = false)
    private Long winary;
    @Column(nullable = false)
    private Long type;
    @Column(nullable = false)
    private Long information;
    @Column(nullable = false)
    private long likeCount;

}