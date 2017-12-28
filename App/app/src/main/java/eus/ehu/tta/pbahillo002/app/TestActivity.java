package eus.ehu.tta.pbahillo002.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import eus.ehu.tta.pbahillo002.app.model.*;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    int correct;
    String advice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Test test=null;
        TextView textView=(TextView)findViewById(R.id.test_wording);
        textView.setText(test.getWording());
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(Test.Choice choice:test.getChoices()){
            RadioButton radioButton=new RadioButton(this);
            radioButton.setText(choice.getWording());
            radioButton.setOnClickListener(this);
            radioGroup.addView(radioButton);
            if (choice.isCorrect())
                correct=i;
            i++;
        }
        advice=test.getAdvice();
    }

    @Override
    public void onClick(View view){
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);

    }

    public void send(View view) {
        ViewGroup viewGroup=(ViewGroup)view.getParent();
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.test_choices);
        int selected=radioGroup.getCheckedRadioButtonId()-1;
        int choices=radioGroup.getChildCount();

        for(int i=0;i<choices;i++)
            radioGroup.getChildAt(i).setEnabled(false);
        viewGroup.removeView(findViewById(R.id.button_send_test));
        radioGroup.getChildAt(correct).setBackgroundColor(Color.GREEN);
        if (selected!=correct){
            radioGroup.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(),R.string.bad_answer,Toast.LENGTH_SHORT).show();
            if(advice!=null&& !advice.isEmpty())
                findViewById(R.id.button_advice).setVisibility(View.VISIBLE);
        }else
            Toast.makeText(getApplicationContext(),R.string.good_answer,Toast.LENGTH_SHORT).show();
    }
}
