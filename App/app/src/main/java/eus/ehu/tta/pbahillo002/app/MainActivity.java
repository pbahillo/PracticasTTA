package eus.ehu.tta.pbahillo002.app;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import eus.ehu.tta.pbahillo002.app.model.RestLogic;
import eus.ehu.tta.pbahillo002.app.presenter.Data;
import eus.ehu.tta.pbahillo002.app.presenter.ProgressTask;
import eus.ehu.tta.pbahillo002.app.model.User;

public class MainActivity extends AppCompatActivity {
    protected Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login (View view){
        String login=((EditText)findViewById(R.id.login)).getText().toString();
        String passwd=((EditText)findViewById(R.id.passwd)).getText().toString();
        data=new Data(login,passwd);
        new ProgressTask<User>(this){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected User work() throws Exception {
                User user=data.authenticate(data.getDni(),data.getPasswd());
                return user;
            }
            @Override
            protected void onFinish(User result) {
                if (result!=null){
                    Intent intent=new Intent(this.context,MenuActivity.class);
                    intent.putExtra(data.DATA,data);
                    this.context.startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),R.string.auth_fail,Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
}
