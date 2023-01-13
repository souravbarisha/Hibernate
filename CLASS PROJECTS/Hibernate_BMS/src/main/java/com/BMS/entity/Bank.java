package com.BMS.entity;

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
@Table(name="Bank_Details")
public class Bank {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
private int acc_no;
@Column(length =20, nullable = false, unique = true)
private String acc_holder;
@Column(length =11, nullable = false)
private String ifsc;
@Column(length =11, nullable = false)
private String branch;
@Column(length =20, nullable = false)
private String acc_type;
@Column(length =20, nullable = false)
private double acc_bal;
@Column(length =20, nullable = false)
private int pin;
}
