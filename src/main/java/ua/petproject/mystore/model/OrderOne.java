package ua.petproject.mystore.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "order_one")
public class OrderOne {
    private int id;
    private Transaction transaction;
    private BigDecimal totalPayment;
    private Delivery delivery;
    private Timestamp createDate;
    private Timestamp updateDate;

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
    @Column(name = "transaction_id", nullable = false)
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transactionId) {
        this.transaction = transactionId;
    }

    @Basic
    @Column(name = "total_payment", nullable = false, precision = 2)
    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    @ManyToOne
    @Column(name = "delivery_id", nullable = false)
    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery deliveryId) {
        this.delivery = deliveryId;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date", nullable = false)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderOne orderOne = (OrderOne) o;

        if (id != orderOne.id) return false;
        if (transaction != orderOne.transaction) return false;
        if (delivery != orderOne.delivery) return false;
        if (totalPayment != null ? !totalPayment.equals(orderOne.totalPayment) : orderOne.totalPayment != null)
            return false;
        if (createDate != null ? !createDate.equals(orderOne.createDate) : orderOne.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(orderOne.updateDate) : orderOne.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + transaction.getId();
        result = 31 * result + (totalPayment != null ? totalPayment.hashCode() : 0);
        result = 31 * result + delivery.getId();
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
