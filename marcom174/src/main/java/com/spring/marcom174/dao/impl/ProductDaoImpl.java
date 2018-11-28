package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.ProductDao;
import com.spring.marcom174.model.ProductModel;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(ProductModel productModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(productModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p from ProductModel p";
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = session.createQuery(query).list();
		return productModelList;
	}

	@Override
	public ProductModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p from ProductModel p where id="+id+" ";
		ProductModel productModel = new ProductModel();
		productModel = (ProductModel) session.createQuery(query).getSingleResult();
		return productModel;
	}

	
	@Override
	public void update(ProductModel productModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(productModel);
	}

	//Utk menampilkan List yg belum di delete
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p from ProductModel p "
						+"where p.isDelete = 0 ";
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = session.createQuery(query).list();
		return productModelList;
	}
	
	/////////DELETE////////-------------------
	/*@Override
	public void delete(ProductModel productModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(productModel);
	}*/
	/////////DELETE////////----------------

	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> searchByLikeCode(String code) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p from ProductModel p "
						+"where p.code like '%"+code+"%' ";
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = session.createQuery(query).list();
		return productModelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p from ProductModel p "
						+"where p.name like '%"+name+"%' ";
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = session.createQuery(query).list();
		return productModelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> searchByLikeDescription(String description) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p from ProductModel p "
						+"where p.description like '%"+description+"%' ";
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = session.createQuery(query).list();
		return productModelList;
	}

	@Override
	public List<ProductModel> searchByLikeUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	

	/*//UTK mengecek nama yag diinput
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> selectName() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select p.name from ProductModel p ";
						
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		productModelList = session.createQuery(query).list();
		return productModelList;
		
	}*/

}
