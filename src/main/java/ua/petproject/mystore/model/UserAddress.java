package ua.petproject.mystore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
public class UserAddress {
    private int id;
    private int user;
    private int address;

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
    public int getUser() {
        return user;
    }

    public void setUser(int userId) {
        this.user = userId;
    }

    @ManyToOne
    @Column(name = "address_id", nullable = false)
    public int getAddress() {
        return address;
    }

    public void setAddress(int addressId) {
        this.address = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAddress that = (UserAddress) o;

        if (id != that.id) return false;
        if (user != that.user) return false;
        if (address != that.address) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user;
        result = 31 * result + address;
        return result;
    }
}
