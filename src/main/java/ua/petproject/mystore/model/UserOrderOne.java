package ua.petproject.mystore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_order_one")
public class UserOrderOne {
    private int id;
    private User user;
    private OrderOne orderOne;

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
    @Column(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    @ManyToOne
    @Column(name = "order_one_id", nullable = false)
    public OrderOne getOrderOne() {
        return orderOne;
    }

    public void setOrderOne(OrderOne orderOneId) {
        this.orderOne = orderOneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOrderOne that = (UserOrderOne) o;

        if (id != that.id) return false;
        if (user != that.user) return false;
        if (orderOne != that.orderOne) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.getId();
        result = 31 * result + orderOne.getId();
        return result;
    }
}
