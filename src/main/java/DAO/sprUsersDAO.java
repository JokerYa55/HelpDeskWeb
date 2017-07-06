/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.TSprUsers;
import interfaces.HibernateUtil;

import interfaces.beanDAO;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vasil
 */
public class sprUsersDAO implements beanDAO<TSprUsers, Long> {

    private Session session1;

    public sprUsersDAO(Session sess) {
        this.session1 = sess;
    }

    //public EntityManager em = Persistence.createEntityManagerFactory("helpdesk-jpa-example").createEntityManager();
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public TSprUsers getItem(Long id) {
        TSprUsers res;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            res = (TSprUsers) session.get(TSprUsers.class, id);
            tx.commit();
            //session.close();
            return res;
        } catch (HibernateException e) {
            System.out.println("Ошибка <getItem>: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<TSprUsers> getList() {
        log.info("getList()");
        try {
            log.info("getItemList");
            org.hibernate.Transaction tx = this.session1.beginTransaction();
            List<TSprUsers> itemList = this.session1.createCriteria(TSprUsers.class).list();
            tx.commit();
            return itemList;
        } catch (HibernateException e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TSprUsers> getList(Long startIdx, Long stopIdx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
