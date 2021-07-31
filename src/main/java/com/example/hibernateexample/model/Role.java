package com.example.hibernateexample.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Data
public class Role extends BasicEntity{
    @Column(name = "name")
    private String name;
}
