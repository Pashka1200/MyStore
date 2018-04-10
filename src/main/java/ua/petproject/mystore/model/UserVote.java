package ua.petproject.mystore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_vote")
public class UserVote {
    private int id;
    private User user;
    private Feedback feedback;
    private byte voteScore;

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
    @Column(name = "feedback_id", nullable = false)
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedbackId) {
        this.feedback = feedbackId;
    }

    @Basic
    @Column(name = "vote_score", nullable = false)
    public byte getVoteScore() {
        return voteScore;
    }

    public void setVoteScore(byte voteScore) {
        this.voteScore = voteScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVote userVote = (UserVote) o;

        if (id != userVote.id) return false;
        if (user != userVote.user) return false;
        if (feedback != userVote.feedback) return false;
        if (voteScore != userVote.voteScore) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.getId();
        result = 31 * result + feedback.getId();
        result = 31 * result + (int) voteScore;
        return result;
    }
}
