package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.UserDao;
import com.spring.marcom174.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(UserModel userModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(userModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select u from UserModel u";
		List<UserModel> userModelList = new ArrayList<UserModel>();
		
		userModelList = session.createQuery(query).list();
		return userModelList;
	}

	@Override
	public UserModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select u from UserModel u where id="+id+" ";
		UserModel userModel = new UserModel();
		userModel = (UserModel) session.createQuery(query).getSingleResult();
		return userModel;
	}

	@Override
	public void delete(UserModel userModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(userModel);
	}

	@Override
	public void update(UserModel userModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userModel);
	}

	@Override
	public UserModel searchByUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		UserModel userModel = new UserModel();
		String query = " from UserModel "
					+ " where username = '"+username+"' "
					+ " and password = '"+password+"' ";
		try {
			userModel = (UserModel) session.createQuery(query).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return userModel;
	}

	
	/*//TESS
	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> searchNameRole(Integer idRole) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		String query = "select r from UserModel u "
						+" join RoleModel r on r.id = u.idRole "
						+" where u.idRole = "+idRole+" ";
		try {
			userModelList = session.createQuery(query).list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return userModelList;
	}*/

}
