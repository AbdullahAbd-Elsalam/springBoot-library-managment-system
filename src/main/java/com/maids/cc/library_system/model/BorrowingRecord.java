package com.maids.cc.library_system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@ApiModel( value = "this is the api for book ")
public class BorrowingRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "this is the id for book")
    @Column(name = "id")
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "this field cannot be null")
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "this field cannot be null")
    private LocalDate returnDate;


}
