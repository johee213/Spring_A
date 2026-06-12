package com.example.sunset.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String subject;

    @Column(nullable = false, length = 500)
    private String content;

    private String createdDate;


    @ManyToOne
    private SiteUser siteUser;

    @OneToMany(mappedBy = "posting", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comment> commentList;
}
