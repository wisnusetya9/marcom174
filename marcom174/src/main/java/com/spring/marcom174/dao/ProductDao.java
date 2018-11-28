package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.ProductModel;

public interface ProductDao {
	
	public void create(ProductModel productModel);
	public List<ProductModel> select();
	public ProductModel searchById(Integer id);
	//---public void delete(ProductModel productModel);//tdk terpakai
	public void update(ProductModel productModel);
	
	/*//Search
	public List<ProductModel> searchByLikeCode(String code);
	public List<ProductModel> searchByLikeName(String name);
	public List<ProductModel> searchByLikeDescription(String description);
	public List<ProductModel> searchByLikeUser(String user);*/
	
	//Auditrail
	public List<ProductModel> selectNotDelete();
	
	/*//Name tidak boleh Sama
	public List<ProductModel> selectName();*/
	
	
}
