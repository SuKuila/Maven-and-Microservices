package com.cg.dto;

import com.cg.entity.Genre;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class BookDto {
private int bookId;
private String bookName;
@Enumerated(EnumType.STRING)
private Genre genre;
private float cost;
private int stock;
private int authourId;
public BookDto() {
	
}
}
