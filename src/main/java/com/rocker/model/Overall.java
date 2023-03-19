package com.rocker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Overall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer overAllId;

    private String type;

    private Integer planterId;

    private Integer plantId;

    private Integer seedId;
}
