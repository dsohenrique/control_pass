package br.com.controlpass.dao;  

import org.hibernate.SessionFactory;  

public class HibernateUtilTest {  

public static void main(String args[]) {  
HibernateUtil.getFactory().openSession();  
}  

}