package ua.petproject.mystore.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "user_info")
public class UserInfo {
    private int id;
    private String fname;
    private String lname;
    private String sex;
    private byte[] photo;
    private Integer phone;
    private User user;

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
    @Column(name = "fname", nullable = false, length = 50)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "lname", nullable = false, length = 50)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "phone", nullable = true)
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @OneToOne
    @Column(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (user != userInfo.user) return false;
        if (fname != null ? !fname.equals(userInfo.fname) : userInfo.fname != null) return false;
        if (lname != null ? !lname.equals(userInfo.lname) : userInfo.lname != null) return false;
        if (sex != null ? !sex.equals(userInfo.sex) : userInfo.sex != null) return false;
        if (!Arrays.equals(photo, userInfo.photo)) return false;
        if (phone != null ? !phone.equals(userInfo.phone) : userInfo.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + user.getId();
        return result;
    }
}
