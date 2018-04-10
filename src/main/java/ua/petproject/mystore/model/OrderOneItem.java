package ua.petproject.mystore.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_one_item")
public class OrderOneItem {
    private int id;
    private Item item;
    private OrderOne orderOne;
    private BigDecimal buyingPrice;
    private int qty;

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
    @Column(name = "item_id", nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item itemId) {
        this.item = itemId;
    }

    @ManyToOne
    @Column(name = "order_one_id", nullable = false)
    public OrderOne getOrderOne() {
        return orderOne;
    }

    public void setOrderOne(OrderOne orderOneId) {
        this.orderOne = orderOneId;
    }

    @Basic
    @Column(name = "buying_price", nullable = false, precision = 2)
    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Basic
    @Column(name = "qty", nullable = false)
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderOneItem that = (OrderOneItem) o;

        if (id != that.id) return false;
        if (item != that.item) return false;
        if (orderOne != that.orderOne) return false;
        if (qty != that.qty) return false;
        if (buyingPrice != null ? !buyingPrice.equals(that.buyingPrice) : that.buyingPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + item.getId();
        result = 31 * result + orderOne.getId();
        result = 31 * result + (buyingPrice != null ? buyingPrice.hashCode() : 0);
        result = 31 * result + qty;
        return result;
    }
}
