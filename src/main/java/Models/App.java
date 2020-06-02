package Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class App {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int AppID;
    private String AppName;
    @ManyToOne
    @Autowired
    private User user;
    //@ManyToMany(mappedBy = "app")
    //private List<User> user = new ArrayList<User>();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAppID() {
        return AppID;
    }

    public App() {
    }

    public void setAppID(int appID) {
        AppID = appID;
    }

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }
}
