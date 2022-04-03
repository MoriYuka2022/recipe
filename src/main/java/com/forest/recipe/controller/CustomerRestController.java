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

import com.forest.recipe.model.Customer;
import com.forest.recipe.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository repository;
	
	/**
     * 全件表示。
     *
     * @return 検索結果
     */
	@GetMapping
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
	/**
     * 1件表示。
     *
     * @param id
     * @return 検索結果
     */
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") String id) {
	    return repository.findById(id).get();
		
	}

	/**
     * 登録。
     *
     * @param entity リクエスト
     * @return レスポンス 200:OK
     */
    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer entity) {
        entity = repository.save(entity);
        return ResponseEntity.ok(entity); //ResponseEntity.ok?
    }
    
	/**
     * 編集。
     *
     * @param id, entity リクエスト
     * @return レスポンス 200:OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable("id") String id, @Valid @RequestBody Customer entity) {
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
    public ResponseEntity<Void> list(@PathVariable String id) {
    	repository.deleteById(id);
        return ResponseEntity.noContent().build(); //ResponseEntity.noContent().build();?
    }
	

}