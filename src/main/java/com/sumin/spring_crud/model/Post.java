package com.sumin.spring_crud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    //게시판 타이틀,내용,컨텐츠
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private  String title;

    @Column(name = "description", nullable = false)
    private  String description;

    @Column(name = "content",nullable = false)
    private  String content;
}
