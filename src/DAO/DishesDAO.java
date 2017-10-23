package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.*;
import MyUtil.Util;

public class DishesDAO {
	
	public void save(Dishes dish){
		
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(dish);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void delete(Serializable primarykey){
	
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
		Object result=session.get(Dishes.class, primarykey);
		
		if(result!=null){
			session.delete(result);
		}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void update(Dishes dish){
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(dish);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	public Query query(String sql){
		
		Query query=null;
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			query=session.createSQLQuery(sql).addEntity(Dishes.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return query;
	}
}
