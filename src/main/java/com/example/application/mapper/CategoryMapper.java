package com.example.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.application.entity.Category;

@Mapper
public interface CategoryMapper {

	// categoryを全件取得
	public List<Category> getCategoryAll();

}
