package eus.ehu.tta.pbahillo002.app.model;


import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private int lesson;
    private String name;
    private String passwd;
    private String login;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
