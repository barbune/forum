package domain;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by slzZp on 2018/1/29.
 */
public class User implements Serializable {
    private  int userId;
    private String user_Name;
    private String user_password;
    private String credits;
    private String lastIp;
    private Date lastVisit;

    public Date getLastVisit() {
        return lastVisit;
    }

    public int getUserId() {
        return userId;
    }

    public String getCredits() {
        return credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", user_Name='" + user_Name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", credits='" + credits + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastVisit=" + lastVisit +
                '}';
    }
}

