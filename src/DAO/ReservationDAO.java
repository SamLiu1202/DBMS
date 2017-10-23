package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.*;
import MyUtil.Util;

public class ReservationDAO {
	
	public void save(Reservation r){
		
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(r);
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
			Object result=session.get(Reservation.class, primarykey);
		
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
	
	public void update(Reservation r){
		
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{
		session.update(r);
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
			q=session.createSQLQuery(sql).addEntity(Reservation.class);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return q;
	}

}
