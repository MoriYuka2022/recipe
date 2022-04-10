package com.forest.recipe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long recipeId;
	
	@NotBlank
	private String name;
	
	private String nameImageUrl;
	
	// 何人分か
	private int numberOfPeople;
	
	@ManyToOne
	private Customer customer;

	public RecipeHistory(Recipe entity) {
		super();
		this.recipeId = entity.getId();
		this.name = entity.getName();
		this.nameImageUrl = entity.getNameImageUrl();
		this.numberOfPeople = entity.getNumberOfPeople();
		this.customer = entity.getCustomer();
	}
	
	

}
