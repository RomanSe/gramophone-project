package com.geekbrains.gramophone.entities;

import lombok.Data;

import javax.persistence.*;


//TODO на текущий момент это класс-заглушка

@Entity
@Table(name = "tracks")
@Data
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author_name")
    private String authorName;  //TODO сделать ссылку на другой класс

    @Column(name = "album")
    private String album;  //TODO сделать ссылку на другой класс

}
