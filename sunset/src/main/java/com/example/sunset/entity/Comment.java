package com.example.sunset.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    private String createdDate;

    @ManyToOne
    private Posting posting;

    @ManyToOne
    @JoinColumn(name = "siteUser_id")
    private SiteUser siteUser;

}
