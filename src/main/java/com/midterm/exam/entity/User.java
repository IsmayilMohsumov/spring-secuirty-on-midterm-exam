package com.midterm.exam.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password can't be blank")
    @Length(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @Column(columnDefinition = "varchar(10) default 'USER'")
    private String role;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private File file;

    @Column(columnDefinition = "boolean default true")
    private Boolean enabled = true;


}
