package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.*;
import MyUtil.Util;

public class CommentDAO {
	
	public void save(Comment c){
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		
		try{
			session.save(c);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void delete(Serializable primarykey){
	
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		
		try{
			Object result=session.get(Comment.class, primarykey);
		
			if(result!=null){
				session.delete(result);
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
		session.close();
		}
	}
	public void update(Comment comment){
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		
		try{
			session.update(comment);
			tx.commit();
			}catch(Exception e){
				e.printStackTrace();
			}
		finally{
			session.close();
		}
	}
	public Query query(String sql){
		
		Query query=null;
		Session session=Util.getSession();
		Transaction tx=session.beginTransaction();
		try{	
			query=session.createSQLQuery(sql).addEntity(Comment.class);	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return query;
	}
}
