package com.forest.recipe.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * エラーレスポンスクラス
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private String code;
	
	private String message;
	

}
