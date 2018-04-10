package ua.petproject.mystore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_feedback")
public class UserFeedback {
    private int id;
    private User user;
    private Feedback feedback;
    private Item item;

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
    @Column(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    @Basic
    @Column(name = "feedback_id", nullable = false)
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedbackId) {
        this.feedback = feedbackId;
    }

    @Basic
    @Column(name = "item_id", nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item itemId) {
        this.item = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFeedback that = (UserFeedback) o;

        if (id != that.id) return false;
        if (user != that.user) return false;
        if (feedback != that.feedback) return false;
        if (item != that.item) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.getId();
        result = 31 * result + feedback.getId();
        result = 31 * result + item.getId();
        return result;
    }
}
