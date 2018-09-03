package com.spring.webapp.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private Integer zipCode;
	
	public Publisher(String name, String addressOne, String addressTwo, String city, String state, Integer zipCode) {
		this.name = name;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Publisher publisher = (Publisher) o;
		return id == publisher.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
