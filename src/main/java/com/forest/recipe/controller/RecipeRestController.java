package com.forest.recipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forest.recipe.model.Recipe;
import com.forest.recipe.repository.RecipeRepository;

@RestController
@RequestMapping("/recipes")
public class RecipeRestController {
	
	@Autowired
	private RecipeRepository repository;
	

	/**
     * 全件表示。
     *
     * @return 検索結果
     */
	@GetMapping
	public List<Recipe> findAll(){
		return repository.findAll();
	}
	
	/**
     * 1件表示。
     *
     * @param id
     * @return 検索結果
     */
	@GetMapping("/{id}")
	public Recipe getCustomer(@PathVariable("id") Long id) {
	    return repository.findById(id).orElse(null);
		
	}

	/**
     * 登録。
     *
     * @param entity リクエスト
     * @return レスポンス 200:OK
     */
    @PostMapping
    public ResponseEntity<Recipe> create(@Valid @RequestBody Recipe entity) {
        entity = repository.save(entity);
        return ResponseEntity.ok(entity);
    }
    
	/**
     * 編集。
     *
     * @param id, entity リクエスト
     * @return レスポンス 200:OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") Long id, @Valid @RequestBody Recipe entity) {
        entity = repository.save(entity);
        return ResponseEntity.ok(entity);
    }
	
    /**
     * 削除。
     * 
     * @param id
     * @return 204:No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> list(@PathVariable Long id) {
    	repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

	
	

}
