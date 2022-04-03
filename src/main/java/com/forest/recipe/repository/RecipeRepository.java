package com.forest.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forest.recipe.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
