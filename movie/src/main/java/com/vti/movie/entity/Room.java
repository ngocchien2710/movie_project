package com.vti.movie.entity;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name ="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "name", length = 100, nullable = false, unique = true )
    private String name;

    @Column(name= "capacity", unique = true)
    private int capacity;

    @Column(name ="total_area_vip", unique = true)
    private double totalAreaVip;

    @Column(name = "total_area_normal", unique = true)
    private double totalAreaNormal;
//    @Column(length = 1000)
//    private String imgURL;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Seat> seats;

    @ManyToOne
    @JoinColumn(nullable = false,name = "cinema_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cinema cinema;
}
