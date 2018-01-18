package eus.ehu.tta.pbahillo002.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import eus.ehu.tta.pbahillo002.app.presenter.Data;

public class ExerciseActivity extends AppCompatActivity {

    public static final int PHOTO_REQUEST_CODE=0;
    public static final int VIDEO_REQUEST_CODE=1;
    public static final int AUDIO_REQUEST_CODE=2;
    public static final int READ_REQUEST_CODE=3;
    private Data data;
    Uri pictureUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        data=(Data) getIntent().getSerializableExtra(data.DATA);
        TextView textView=(TextView) findViewById(R.id.exercise_wording);
        textView.setText(data.getExercise().getWording());
    }

    public void takePhoto(View view) {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this,R.string.no_camara,Toast.LENGTH_SHORT).show();
        else{
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager())!=null){
                File dir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try {
                    File file= File.createTempFile("tta",".jpg",dir);
                    pictureUri=Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                    startActivityForResult(intent,PHOTO_REQUEST_CODE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                Toast.makeText(this,R.string.no_app,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void recordAudio(View view) {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            Toast.makeText(this,R.string.no_micro,Toast.LENGTH_SHORT).show();
        else{
            Intent intent=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if(intent.resolveActivity(getPackageManager())!=null)
                startActivityForResult(intent,AUDIO_REQUEST_CODE);
            else
                Toast.makeText(this,R.string.no_app,Toast.LENGTH_SHORT).show();
        }
    }

    public void recordVideo(View view) {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this,R.string.no_camara,Toast.LENGTH_SHORT).show();
        else{
            Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null)
                startActivityForResult(intent,VIDEO_REQUEST_CODE);
            else
                Toast.makeText(this,R.string.no_app,Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode!= Activity.RESULT_OK)
            return;
        switch(requestCode){
            case PHOTO_REQUEST_CODE:
                //sendFile(pictureUri);
                break;
            case AUDIO_REQUEST_CODE:
                //sendFile(data.getData());
                break;
            case READ_REQUEST_CODE:
                break;
        }
    }
    public void dumpImageMetaData (Uri uri){
        Cursor cursor=this.getContentResolver().query(uri,null,null,null,null,null);
        try{
            if(cursor!=null&&cursor.moveToFirst()){
                String displayName=cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                Toast.makeText(this,getString(R.string.display_name)+displayName,Toast.LENGTH_SHORT).show();
                int sizeIndex=cursor.getColumnIndex(OpenableColumns.SIZE);
                String size;
                if(!cursor.isNull(sizeIndex))
                    size=cursor.getString(sizeIndex);
                else
                    size="Unknown";
                Toast.makeText(this,getString(R.string.size)+size,Toast.LENGTH_SHORT).show();
            }
        }finally {
            cursor.close();
        }
    }

    @NonNull
    private String readTextFromUri(Uri uri) throws IOException {
        InputStream inputStream=getContentResolver().openInputStream(uri);
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder=new StringBuilder();
        String line;
        while((line=reader.readLine())!=null)
            stringBuilder.append(line);
        reader.close();
        inputStream.close();
        return stringBuilder.toString();
    }

    public void sendFile(View view){
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent,READ_REQUEST_CODE);
    }


}
