package com.cts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * public record Product(Integer id, String name, String category, String color,
 * Double price) {
 * 
 * }
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer id;
	private String name;
	private String category, color;
	private Double price;
}