package com.rms.rms.dao;

	import java.util.List;
	import javax.persistence.NoResultException;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;
	import com.rms.rms.model.User;
	@SuppressWarnings("deprecation")
	@Repository
	@Transactional
	public class UserDaoImpl implements UserDao{
	 @Autowired
	 private SessionFactory factory;
	 @Override
	 public void registerUser(User user) {
	  // TODO Auto-generated method stub
	  Session session = factory.getCurrentSession();
	  session.save(user);
	 }
	 @Override
	 public User loginUser(User user) {
	  // TODO Login
	  Session session = factory.getCurrentSession();
	  try {
	  Query<User> query = session.createQuery("from Student where userName =:userName and password =:password",User.class);
	  query.setParameter("userName", user.getUser_name());
	  query.setParameter("password", user.getPassword());
	  user = query.getSingleResult();
	  return user;
	  }catch (NoResultException e) {
	   // TODO: handle exception
	   return null;
	  }
	 }

}
