package DAO;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.*;
import MyUtil.Util;

public class RestaurantDAO {
	
	
	public void save(Restaurant restaurant){
		
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(restaurant);
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
			Object result=session.get(Restaurant.class, primarykey);
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
	
	public void update(String name,String style,String address){
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		
		String sql="update Restaurant set address=?,style=? where R_NAME=?";
		try{
			Query q=session.createQuery(sql).setParameter(0, address);
			q.setParameter(1,style);
			q.setParameter(2,name);
			q.executeUpdate();
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	public Query query(String sql){
		Query q=null;
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			q=session.createSQLQuery(sql).addEntity(Restaurant.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return q;
	}
}
