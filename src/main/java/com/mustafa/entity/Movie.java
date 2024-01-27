package com.mustafa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languange;
    private String imamge;
    private String name;
    private String country;
    private Double rating;
    @Column(length = 2048)
    private String summary;
    LocalDate premiered;
    private String url;

    @ElementCollection
    private List<Long> genres;

    @ElementCollection
    private List<Long> comments;

}
