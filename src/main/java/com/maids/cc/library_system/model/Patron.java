package com.maids.cc.library_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "patron")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@ApiModel( value = "this is the api for patron ")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "this is the id for product")
    private int id;

    @NotEmpty(message = "this field cannot be null")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "this field cannot be null")
    @Column(name = "contact_information")
    private String contactInformation;

    @JsonIgnore
    @OneToMany(mappedBy = "patron")
    private List<BorrowingRecord> borrowingRecords;
}
