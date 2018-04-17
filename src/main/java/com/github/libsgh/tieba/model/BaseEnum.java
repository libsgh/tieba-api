package com.github.libsgh.tieba.model;

public interface BaseEnum<T> {
	
	public T getCode();

	public String name();

	public String getDescription();
}
