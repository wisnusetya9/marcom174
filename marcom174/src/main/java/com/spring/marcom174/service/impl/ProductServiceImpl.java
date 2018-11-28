package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.ProductDao;
import com.spring.marcom174.model.ProductModel;
import com.spring.marcom174.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public void create(ProductModel productModel) {
		// TODO Auto-generated method stub
		this.productDao.create(productModel);
	}

	@Override
	public List<ProductModel> select() {
		// TODO Auto-generated method stub
		return this.productDao.select();
	}

	@Override
	public ProductModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.productDao.searchById(id);
	}

	///////////////DELETE///////////
	/*@Override
	public void delete(ProductModel productModel) {
		// TODO Auto-generated method stub
		this.productDao.delete(productModel);
	}*/
	///////////////DELETE///////////
	
	
	@Override
	public void update(ProductModel productModel) {
		// TODO Auto-generated method stub
		this.productDao.update(productModel);
	}

	/*@Override
	public List<ProductModel> searchByLikeCode(String code) {
		// TODO Auto-generated method stub
		return this.productDao.searchByLikeCode(code);
	}

	@Override
	public List<ProductModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.productDao.searchByLikeName(name);
	}

	@Override
	public List<ProductModel> searchByLikeDescription(String description) {
		// TODO Auto-generated method stub
		return this.productDao.searchByLikeDescription(description);
	}*/

	/*@Override
	public List<ProductModel> searchByLikeUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<ProductModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.productDao.selectNotDelete();
	}

	/*@Override
	public List<ProductModel> selectName() {
		// TODO Auto-generated method stub
		return this.productDao.selectName();
	}*/

}
