/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.TIncident;
import interfaces.beanDAO;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vasil
 */
public class tIncidentDAO implements beanDAO<TIncident, Long> {

    private final Logger log = Logger.getLogger(getClass().getName());
    private Session session1;

    public tIncidentDAO(Session sess) {
        this.session1 = sess;
    }

    
    
    @Override
    public TIncident getItem(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TIncident> getList() {
        try {
            log.info("getItemList");
            org.hibernate.Transaction tx = this.session1.beginTransaction();
            List<TIncident> itemList = this.session1.createCriteria(TIncident.class).list();
            tx.commit();
            return itemList;
        } catch (HibernateException e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TIncident> getList(Long startIdx, Long stopIdx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
