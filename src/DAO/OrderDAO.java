package DAO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.*;
import MyUtil.Util;

public class OrderDAO {
	public void save(Order o){
		
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(o);
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
			Object result=session.get(Order.class, primarykey);
		
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
	
	public void update(Order o){
		
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(o);
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	public Query query(String sql){
		
		Query q=null;
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{	
			q=session.createSQLQuery(sql).addEntity(Order.class);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return q;
	}
}
