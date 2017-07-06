/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vasil
 * @param <T> класс с которым работает интерфейс
 * @param <V> Тип уникального ключа
 */
public interface beanDAO<T, V> {

    public T getItem(V id);

    public List<T> getList();

    public List<T> getList(V startIdx, V stopIdx);

    default public long addItem(T Item) {
        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            long id = (Long) session.save(Item);
            System.out.println("id = " + id);
            tx.commit();
            //session.close();
            return id;
        } catch (Exception e) {
            System.out.println("Ошибка : " + e.getMessage());
            return 0;
        }
    }

    /**
     * 
     * @param Item
     * @return 
     */
    
    default public boolean deleteItem(T Item) {
        try {
            //Session session = HibernateUtil.getSessionFactory().openSession();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            session.delete(Item);
            tx.commit();
            //session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Ошибка : " + e.getMessage());
            return false;
        }
    }

    /**
     * 
     * @param Item
     * @return 
     */
    default public boolean updateItem(T Item) {
        try {
            System.out.println("updateItem Item = " + Item);
            //Session session = HibernateUtil.getSessionFactory().openSession();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            session.saveOrUpdate(Item);
            tx.commit();
            //session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Ошибка : " + e.getMessage());
            return false;
        }
    }
}
