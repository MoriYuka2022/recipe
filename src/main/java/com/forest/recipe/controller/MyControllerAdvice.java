package com.forest.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.forest.recipe.response.ErrorResponse;

/**
 * エラーハンドリングクラス
 */
@RestControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(ObjectOptimisticLockingFailureException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ErrorResponse handleObjectOptimisticLockingFailureException(Exception e) {
		return new ErrorResponse("E001", "他の人が操作をしたため、再度実行してください。");
	}

}
