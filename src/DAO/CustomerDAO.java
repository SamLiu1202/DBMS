package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import Entities.*;
import MyUtil.Util;

public class CustomerDAO{
		
		public void save(Customer c){
			/*
			 * Persist an object
			 */
			Session session=Util.getSession();
			Transaction tx=session.beginTransaction();
			try{
				session.save(c);
				tx.commit();
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				session.close();
			}
		}
		
		public void delete(Serializable primarykey){
			
			Session session=Util.getSession();
			Transaction tx=session.beginTransaction();
			
			try{
				Object result=session.get(Customer.class, primarykey);
			
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
		
		public void update(String name,String address,String phone){
			Session session=Util.getSession();
			Transaction tx=session.beginTransaction();
			String sql="update Customer set address =?,phone=? where user=?";
			try{
				Query q=session.createQuery(sql).setParameter(0, address);
				q.setParameter(1, phone);
				q.setParameter(2, name);
				q.executeUpdate();
	
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
			session.beginTransaction();
			try{
			query=session.createSQLQuery(sql).addEntity(Customer.class);
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return query;
		}

}
