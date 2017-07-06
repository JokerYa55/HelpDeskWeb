/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.TSprUsers;

import interfaces.beanDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author vasil
 */
public class sprUsersDAO implements beanDAO<TSprUsers, Long> {

    private Connection conn;

    public sprUsersDAO(Connection conn) {
        this.conn = conn;
    }

    //public EntityManager em = Persistence.createEntityManagerFactory("helpdesk-jpa-example").createEntityManager();
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public TSprUsers getItem(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TSprUsers> getList() {
        log.info("getList()");
        List<TSprUsers> res = null;
        try {
            res = new LinkedList<>();
            Statement statement = conn.createStatement();
            String sql = "SELECT id, f_login, f_pass, f_name FROM public.t_spr_users";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                TSprUsers item = new TSprUsers();
                item.setId(rs.getLong("id"));
                item.setFName(rs.getString("f_name"));
                item.setFPass(rs.getString("f_pass"));
                item.setFLogin(rs.getString("f_login"));                
                res.add(item);
                        
            }
        } catch (Exception e) {
        }
        return res;
    }

    @Override
    public List<TSprUsers> getList(Long startIdx, Long stopIdx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long addItem(TSprUsers item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateItem(TSprUsers item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItem(TSprUsers item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
