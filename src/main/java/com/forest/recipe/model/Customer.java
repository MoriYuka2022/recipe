package com.forest.recipe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private String id; //firebaseのID
	
	private String name;
	
	private String role;
	
	@Version
	private Long version;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Recipe> recipes;
	
}
