package ua.petproject.mystore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_email")
public class UserEmail {
    private int id;
    private User user;
    private String email;

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
    @Column(name = "email", nullable = true, length = 70)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEmail userEmail = (UserEmail) o;

        if (id != userEmail.id) return false;
        if (user != userEmail.user) return false;
        if (email != null ? !email.equals(userEmail.email) : userEmail.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.getId();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
