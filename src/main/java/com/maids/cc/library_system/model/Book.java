package com.maids.cc.library_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@ApiModel( value = "this is the api for book ")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "this is the id for book")
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "this field cannot be null")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "this field cannot be null")
    @Column(name = "author")
    private String author;

    @NotEmpty(message = "this field cannot be null")
    @NotNull
    @Column(name = "publication_Year")
    private int publicationYear;


    @NotEmpty(message = "this field cannot be null")
    @Column(name = "isbn")
    private String isbn;



    @JsonIgnore
     @OneToMany(mappedBy = "book")
     private List<BorrowingRecord> borrowingRecords;
}
