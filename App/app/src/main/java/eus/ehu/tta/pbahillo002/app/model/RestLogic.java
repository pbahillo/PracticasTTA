
package eus.ehu.tta.pbahillo002.app.model;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class RestLogic implements RestServer {

    private RestClient client;
    private final static String restUrl="http://u017633.ehu.eus:28080/ServidorTta/rest/tta";


    public RestLogic(String dni, String passwd){

        client=new RestClient(restUrl);
        client.setHttpBasicAuth(dni,passwd);
    }

    @Override
    public User getStatus(String dni) {
        try {
            User user=new User();
            JSONObject jsonObject=client.getJson("getStatus?dni="+dni);
            user.setId(jsonObject.optInt("id",1));
            user.setUser(jsonObject.optString("user","John Doe"));
            user.setLessonNumber(jsonObject.optInt("lessonNumber",1));
            user.setLessonTitle(jsonObject.optString("lessonTitle","Introducción"));
            user.setNextExercise(jsonObject.optInt("nextExercise",1));
            user.setNextTest(jsonObject.optInt("nextTest",1));

            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Test getTest(int id) {
        try {
            Test test=new Test();
            JSONObject jsonObject=client.getJson("getTest?id="+Integer.toString(id));
            test.setWording((jsonObject.getString("wording")));
            JSONArray array=jsonObject.getJSONArray("choices");
            for (int i=0;i<array.length();i++) {
                JSONObject item = array.getJSONObject(i);
                Test.Choice choice = new Test.Choice();
                choice.setId(item.getInt("id"));
                choice.setWording(item.getString("answer"));
                choice.setCorrect(item.getBoolean("correct"));
                choice.setAdvise(item.optString("advise", null));
                if (!item.isNull("resourceType")){
                    choice.setMime(item.getJSONObject("resourceType").optString("mime", null));
                }
                test.getChoices().add(choice);
            }
            return test;
        } catch (JSONException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Exercise getExercise(int id) {
        try {
            Exercise exercise=new Exercise();
            Exercise.LessonBean lessonBean=new Exercise.LessonBean();
            JSONObject jsonObject=client.getJson("getExercise?id="+Integer.toString(id));
            JSONObject item=jsonObject.getJSONObject("lessonBean");
            exercise.setId(jsonObject.getInt("id"));
            exercise.setWording(jsonObject.getString("wording"));
            lessonBean.setId(item.getInt("id"));
            lessonBean.setNumber(item.getInt("number"));
            lessonBean.setTitle(item.getString("title"));
            exercise.setLessonBean(lessonBean);
            return exercise;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int postExercise(int userId, int exerciseId) {
        return 0;
    }

    @Override
    public int postChoice() {
        return 0;
    }
}

