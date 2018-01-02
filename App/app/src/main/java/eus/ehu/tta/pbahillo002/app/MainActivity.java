package eus.ehu.tta.pbahillo002.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import eus.ehu.tta.pbahillo002.app.model.Data;
import eus.ehu.tta.pbahillo002.app.model.User;

public class MainActivity extends AppCompatActivity {
    String login;
    String passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login (View view){
        Intent intent=new Intent(this,MenuActivity.class);
        login=((EditText)findViewById(R.id.login)).getText().toString();
        passwd=((EditText)findViewById(R.id.passwd)).getText().toString();

        if (authenticate(login,passwd)){
            intent.putExtra(MenuActivity.EXTRA_LOGIN,login);
            startActivity(intent);
        }
    }

    private boolean authenticate(String login, String passwd) {
        boolean b=false;
        Data data=new Data();
        List<User> users=data.getUsers();
        for (int i=0;i<users.size();i++){
            if (users.get(i).getLogin().equals(login)&&users.get(i).getPasswd().equals(passwd)){
                this.login=users.get(i).getName();
                b=true;
            }
        }
        return b;
    }
}
