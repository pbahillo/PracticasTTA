package eus.ehu.tta.pbahillo002.app.presenter;


import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.Serializable;

import eus.ehu.tta.pbahillo002.app.model.Exercise;
import eus.ehu.tta.pbahillo002.app.model.RestLogic;
import eus.ehu.tta.pbahillo002.app.model.Test;
import eus.ehu.tta.pbahillo002.app.model.User;

public class Data implements Serializable {
    public final static String DATA="eus.ehu.tta.pbahillo002.app.data";
    private String dni;
    private String passwd;
    private User user;
    private Test test;
    private Exercise exercise;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
