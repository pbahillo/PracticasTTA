package eus.ehu.tta.pbahillo002.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    public final static String EXTRA_LOGIN ="eus.ehu.tta.pbahillo002.app.login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent=getIntent();
        TextView textView=(TextView)findViewById(R.id.menu_login);
        textView.setText(intent.getStringExtra(EXTRA_LOGIN));
    }

    public void test(View view) {
        Intent intent=new Intent(this,TestActivity.class);
        startActivity(intent);
    }

    public void exercise(View view) {
        Intent intent=new Intent(this,ExerciseActivity.class);
        startActivity(intent);
    }

    public void accountment(View view) {
    }
}
