package com.eds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "SALARY", nullable = false)
    private Long salary;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;
}