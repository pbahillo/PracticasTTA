package eus.ehu.tta.pbahillo002.app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

import eus.ehu.tta.pbahillo002.app.model.*;
import eus.ehu.tta.pbahillo002.app.presenter.Data;
import eus.ehu.tta.pbahillo002.app.view.AudioPlayer;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String TEST="eus.ehu.tta.pbahillo002.app.test";
    Data data;

    int correct=0;
    int selected=0;
    ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        data=(Data) getIntent().getSerializableExtra(data.DATA);
        TextView textView=(TextView)findViewById(R.id.test_wording);
        textView.setText(data.getTest().getWording());
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(Test.Choice choice:data.getTest().getChoices()){
            RadioButton radioButton=new RadioButton(this);
            radioButton.setText(choice.getWording());
            radioButton.setOnClickListener(this);
            radioGroup.addView(radioButton);
            if (choice.isCorrect())
                correct=i;
            i++;
        }
    }

    @Override
    public void onClick(View view){
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void send(View view) {
        viewGroup=(ViewGroup)view.getParent();
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.test_choices);
        selected=getSelected(radioGroup);
        int choices=radioGroup.getChildCount();

        for(int i=0;i<choices;i++)
            radioGroup.getChildAt(i).setEnabled(false);
        viewGroup.removeView(findViewById(R.id.button_send_test));
        radioGroup.getChildAt(correct).setBackgroundColor(Color.GREEN);
        if (selected!=correct){
            radioGroup.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(),R.string.bad_answer,Toast.LENGTH_SHORT).show();
            if(data.getTest().getChoices().get(selected).getAdvise()!=null)
                findViewById(R.id.button_advice).setVisibility(View.VISIBLE);
        }else
            Toast.makeText(getApplicationContext(),R.string.good_answer,Toast.LENGTH_SHORT).show();
    }

    public void showAdvice(View view){
        if(data.getTest().getChoices().get(selected).getMime().equals("text/html")){
            showHTML(data.getTest().getChoices().get(selected).getAdvise());
        }else if(data.getTest().getChoices().get(selected).getMime().equals("video/mp4")){
            showVideo(data.getTest().getChoices().get(selected).getAdvise());
        }else if(data.getTest().getChoices().get(selected).getMime().equals("audio/mpeg")) {
            showAudio(view,data.getTest().getChoices().get(selected).getAdvise());
        }
    }

    public void showHTML(String advice){
        if (advice.substring(0,10).contains("://")){
            Uri uri=Uri.parse(advice);
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }else {
            WebView webView = new WebView(this);
            webView.loadData(advice,"text/html", null);
            webView.setBackgroundColor(Color.TRANSPARENT);
            webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
            viewGroup.addView(webView);
        }
    }

    public void showVideo(String advice){
        VideoView videoView=new VideoView(this);
        videoView.setVideoURI(Uri.parse(advice));
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        videoView.setLayoutParams(params);
        MediaController mediaController=new MediaController(this){
            @Override
            public void hide(){

            }
            @Override
            public boolean dispatchKeyEvent(KeyEvent keyEvent){
                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_BACK)
                    finish();
                return super.dispatchKeyEvent(keyEvent);
            }
        };
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        viewGroup.addView(videoView);
        videoView.start();
    }

    public void showAudio(View view,String advice){

        AudioPlayer player = new AudioPlayer(view, new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });
        try {
            player.setUri(Uri.parse(advice));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSelected(RadioGroup radioGroup){
        for (int i=0;i<=radioGroup.getChildCount();i++)
            if(((RadioButton)radioGroup.getChildAt(i)).isChecked())
                return i;
        return -1;
    }
}
