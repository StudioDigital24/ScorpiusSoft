package com.studiodigital24.scorpiusSoft.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movements")
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private float amount;
    @Column
    private String concept;
    @Column
    private String employee;
    @Column
    private LocalDate created_at;

    public Movements() {

    }


}