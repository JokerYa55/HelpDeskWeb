/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vasil
 */
//@Entity
//@Table(name = "t_spr_users", catalog = "helpdesk", schema = "public")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TSprUsers.findAll", query = "SELECT t FROM TSprUsers t")
//    , @NamedQuery(name = "TSprUsers.findById", query = "SELECT t FROM TSprUsers t WHERE t.id = :id")
//    , @NamedQuery(name = "TSprUsers.findByFLogin", query = "SELECT t FROM TSprUsers t WHERE t.fLogin = :fLogin")
//    , @NamedQuery(name = "TSprUsers.findByFPass", query = "SELECT t FROM TSprUsers t WHERE t.fPass = :fPass")
//    , @NamedQuery(name = "TSprUsers.findByFName", query = "SELECT t FROM TSprUsers t WHERE t.fName = :fName")})
public class TSprUsers implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;
//    @NotNull
//    @Size(min = 1, max = 500)
//    @Column(name = "f_login")
    private String fLogin;
//    @NotNull
//    @Size(min = 1, max = 20)
//    @Column(name = "f_pass")
    private String fPass;
//    @NotNull
//    @Size(min = 1, max = 500)
//    @Column(name = "f_name")
    private String fName;

    public TSprUsers() {
    }

    public TSprUsers(Long id) {
        this.id = id;
    }

    public TSprUsers(Long id, String fLogin, String fPass, String fName) {
        this.id = id;
        this.fLogin = fLogin;
        this.fPass = fPass;
        this.fName = fName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFLogin() {
        return fLogin;
    }

    public void setFLogin(String fLogin) {
        this.fLogin = fLogin;
    }

    public String getFPass() {
        return fPass;
    }

    public void setFPass(String fPass) {
        this.fPass = fPass;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSprUsers)) {
            return false;
        }
        TSprUsers other = (TSprUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TSprUsers[ id=" + id + " ]";
    }

}
