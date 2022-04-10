package com.forest.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forest.recipe.model.RecipeHistory;

public interface RecipeHistoryRepository extends JpaRepository<RecipeHistory, Long> {

}
