/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author agris.nerets
 */
@Entity
@Table(name = "PAMATS", catalog = "", schema = "DFADMIN")
@NamedQueries({
    @NamedQuery(name = "Pamats.findAll", query = "SELECT p FROM Pamats p"),
    @NamedQuery(name = "Pamats.findById", query = "SELECT p FROM Pamats p WHERE p.id = :id"),
    @NamedQuery(name = "Pamats.findByItem", query = "SELECT p FROM Pamats p WHERE p.item = :item"),
    @NamedQuery(name = "Pamats.findByPrice", query = "SELECT p FROM Pamats p WHERE p.price = :price"),
    @NamedQuery(name = "Pamats.findByQuantity", query = "SELECT p FROM Pamats p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Pamats.findByDatums", query = "SELECT p FROM Pamats p WHERE p.datums = :datums")})
public class Pamats implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ITEM")
    private String item;
    @Column(name = "PRICE")
    private String price;
    @Column(name = "QUANTITY")
    private String quantity;
    @Column(name = "DATUMS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datums;

    public Pamats() {
    }

    public Pamats(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        String oldItem = this.item;
        this.item = item;
        changeSupport.firePropertyChange("item", oldItem, item);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        String oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Date getDatums() {
        return datums;
    }

    public void setDatums(Date datums) {
        Date oldDatums = this.datums;
        this.datums = datums;
        changeSupport.firePropertyChange("datums", oldDatums, datums);
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
        if (!(object instanceof Pamats)) {
            return false;
        }
        Pamats other = (Pamats) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_console.Pamats[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
