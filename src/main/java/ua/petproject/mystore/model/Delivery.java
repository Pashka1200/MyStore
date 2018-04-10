package ua.petproject.mystore.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
public class Delivery {
    private int id;
    private UserAddress userAddress;
    private byte type;
    private byte status;
    private Timestamp dateDesired;
    private Timestamp dateDelivery;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @Column(name = "user_address_id", nullable = false)
    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddressId) {
        this.userAddress = userAddressId;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date_desired", nullable = false)
    public Timestamp getDateDesired() {
        return dateDesired;
    }

    public void setDateDesired(Timestamp dateDesired) {
        this.dateDesired = dateDesired;
    }

    @Basic
    @Column(name = "date_delivery", nullable = false)
    public Timestamp getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Timestamp dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (id != delivery.id) return false;
        if (userAddress != delivery.userAddress) return false;
        if (type != delivery.type) return false;
        if (status != delivery.status) return false;
        if (dateDesired != null ? !dateDesired.equals(delivery.dateDesired) : delivery.dateDesired != null)
            return false;
        if (dateDelivery != null ? !dateDelivery.equals(delivery.dateDelivery) : delivery.dateDelivery != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userAddress.getId();
        result = 31 * result + (int) type;
        result = 31 * result + (int) status;
        result = 31 * result + (dateDesired != null ? dateDesired.hashCode() : 0);
        result = 31 * result + (dateDelivery != null ? dateDelivery.hashCode() : 0);
        return result;
    }
}
