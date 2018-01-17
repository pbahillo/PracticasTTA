package eus.ehu.tta.pbahillo002.app.presenter;


import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.Serializable;

import eus.ehu.tta.pbahillo002.app.model.Exercise;
import eus.ehu.tta.pbahillo002.app.model.RestLogic;
import eus.ehu.tta.pbahillo002.app.model.Test;
import eus.ehu.tta.pbahillo002.app.model.User;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class Data implements Serializable {
    public final static String DATA="eus.ehu.tta.pbahillo002.app.data";
    private String dni;
    private String passwd;
    private User user;
    private Test test;
    private Exercise exercise;

    public Data (String dni,String passwd){
        this.dni=dni;
        this.passwd=passwd;
    }

    public User authenticate(String dni,String passwd){
        this.dni=dni;
        this.passwd=passwd;
        RestLogic server=new RestLogic(this.dni,this.passwd);
        user=server.getStatus(this.dni);
        return user;
    }

    public Test downloadTest(){
        RestLogic restLogic=new RestLogic(dni,passwd);
        test=restLogic.getTest(user.getNextTest());
        return test;
    }

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

    public Test getTest() {
        return test;
    }

    public Exercise getExercise() {
        return exercise;
    }
}
