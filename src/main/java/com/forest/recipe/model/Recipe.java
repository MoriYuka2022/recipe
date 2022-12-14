package com.forest.recipe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank
	private String name;
	
	private String nameImageUrl;
	
	//何人分か
	private int numberOfPeople;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Process> processes;
	
	@ManyToOne
	private Customer customer;
	
	public boolean isInsertHistory(Recipe entity) {
		
		if (!entity.getName().equals(getName())) {
			return true;
		}
		
		return false;
	}

}
