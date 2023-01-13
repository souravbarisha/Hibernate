package com.HibernateCrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Student_Information")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(length =20, nullable = false)
private String name;
@Column(length =11, nullable = false)
private long phone;
@Column(length =20, nullable = false, unique = true)
private String dept;
@Column(length =20, nullable = false)
private String email;
}
