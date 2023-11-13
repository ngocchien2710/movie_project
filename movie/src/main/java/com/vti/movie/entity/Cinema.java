package com.vti.movie.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name ="cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @Column(length = 500, nullable = false)
    private String imgURL;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "diachi",length = 200, nullable = false)
    private String diaChi;
//    private String phoneNo;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Room> rooms;
}
