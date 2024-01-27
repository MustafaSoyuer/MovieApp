package com.mustafa.entity;

import com.mustafa.utility.enums.EStatus;
import com.mustafa.utility.enums.EUserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Email
    private String email;
    @Column(length = 15)
    private String phone;
    @Size(max = 32)
    private String password;
    @Size(max = 32)
    private String rePassword;

    @ElementCollection
    private List<Long> favMovies;

    @ElementCollection
    private List<Long> favGenres;

    @ElementCollection
    private List<Long> comments;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EUserType userType =EUserType.USER;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;


}
