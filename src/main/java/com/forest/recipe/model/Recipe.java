package com.forest.recipe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String nameImageUrl;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Process> processes;
	
	@ManyToOne
	private Customer customer;

}
