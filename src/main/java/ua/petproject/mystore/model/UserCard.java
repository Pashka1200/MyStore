package ua.petproject.mystore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_card")
public class UserCard {
    private int id;
    private User user;
    private Card card;

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
    @Column(name = "card_id", nullable = false)
    public Card getCard() {
        return card;
    }

    public void setCard(Card cardId) {
        this.card = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCard userCard = (UserCard) o;

        if (id != userCard.id) return false;
        if (user != userCard.user) return false;
        if (card != userCard.card) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.getId();
        result = 31 * result + card.getId();
        return result;
    }
}
