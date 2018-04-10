package ua.petproject.mystore.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;

@Entity
@Table(name = "item")
public class Item {
    private int id;
    private String title;
    private BigDecimal price;
    private int qty;
    private byte[] description;
    private Category category;
    private byte[] pic;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "qty", nullable = false)
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    @ManyToOne
    @Column(name = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = categoryId;
    }

    @Basic
    @Column(name = "pic", nullable = true)
    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (qty != item.qty) return false;
        if (category != item.category) return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (!Arrays.equals(description, item.description)) return false;
        if (!Arrays.equals(pic, item.pic)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + qty;
        result = 31 * result + Arrays.hashCode(description);
        result = 31 * result + category.getId();
        result = 31 * result + Arrays.hashCode(pic);
        return result;
    }
}
