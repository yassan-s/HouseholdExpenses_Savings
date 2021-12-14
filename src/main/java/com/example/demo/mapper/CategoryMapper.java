package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Category;

@Mapper
public interface CategoryMapper {

	// categoryを全件取得
	public List<Category> getCategoryAll();

}
