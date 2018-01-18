package eus.ehu.tta.pbahillo002.app;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import eus.ehu.tta.pbahillo002.app.model.Exercise;
import eus.ehu.tta.pbahillo002.app.model.RestLogic;
import eus.ehu.tta.pbahillo002.app.presenter.Data;
import eus.ehu.tta.pbahillo002.app.presenter.ProgressTask;
import eus.ehu.tta.pbahillo002.app.model.Test;
import eus.ehu.tta.pbahillo002.app.model.User;

public class MenuActivity extends AppCompatActivity {
    public final static String EXTRA_LOGIN ="eus.ehu.tta.pbahillo002.app.login";
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent=getIntent();
        TextView textView=(TextView)findViewById(R.id.menu_login);
        data=(Data) intent.getSerializableExtra(data.DATA);
        textView.setText(getString(R.string.welcome_msg).concat(data.getUser().getUser()));
    }

    public void test(View view) {
        new ProgressTask<Test>(this) {
            @Override
            protected Test work() throws Exception {
                RestLogic restLogic=new RestLogic(data.getDni(),data.getPasswd());
                data.setTest(restLogic.getTest(data.getUser().getNextTest()));
                return data.getTest();
            }

            @Override
            protected void onFinish(Test result) {
                if(result!=null){
                    Intent intent=new Intent(this.context,TestActivity.class);
                    intent.putExtra(data.DATA,data);
                    this.context.startActivity(intent);
                }

            }
        }.execute();

    }

    public void exercise(View view) {
        new ProgressTask<Exercise>(this){
            @Override
            protected Exercise work() throws Exception {
                RestLogic restLogic=new RestLogic(data.getDni(),data.getPasswd());
                data.setExercise(restLogic.getExercise(data.getUser().getNextExercise()));
                return data.getExercise();
            }

            @Override
            protected void onFinish(Exercise result) {
                if (result!=null){
                    Intent intent=new Intent(this.context,ExerciseActivity.class);
                    intent.putExtra(data.DATA,data);
                    startActivity(intent);
                }
            }
        }.execute();

    }

    public void accountment(View view) {

    }
}
