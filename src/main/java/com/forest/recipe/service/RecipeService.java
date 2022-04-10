package com.forest.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.recipe.model.Recipe;
import com.forest.recipe.model.RecipeHistory;
import com.forest.recipe.repository.RecipeHistoryRepository;
import com.forest.recipe.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
    private RecipeRepository repository;
	
	@Autowired
    private RecipeHistoryRepository historyRepository;

	public Recipe saveHistory(Recipe entity) {
		
		Recipe currentEntity = repository.findById(entity.getId()).orElse(null);
		
		// historyテーブルを更新するかの判定
		if (entity.isInsertHistory(currentEntity)) {
			System.out.println("historyテーブルにcurrentレコードを追加");
			
			// historyテーブルにcurrentレコードを追加
			historyRepository.save(new RecipeHistory(currentEntity));
		}
		
		return repository.save(entity);
		
	}
}
