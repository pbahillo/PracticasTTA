package eus.ehu.tta.pbahillo002.app;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import eus.ehu.tta.pbahillo002.app.model.RestLogic;
import eus.ehu.tta.pbahillo002.app.presenter.Data;
import eus.ehu.tta.pbahillo002.app.presenter.ProgressTask;
import eus.ehu.tta.pbahillo002.app.model.Test;
import eus.ehu.tta.pbahillo002.app.model.User;

public class MenuActivity extends AppCompatActivity {
    public final static String EXTRA_LOGIN ="eus.ehu.tta.pbahillo002.app.login";
    Data data;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Test work() throws Exception {
                Test test=data.downloadTest();
                return test;
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
        Intent intent=new Intent(this,ExerciseActivity.class);
        startActivity(intent);
    }

    public void accountment(View view) {

    }
}
