package eus.ehu.tta.pbahillo002.app.model;

import java.util.ArrayList;
import java.util.List;


public class Test {

    private List<Choice> choices=new ArrayList<>(0);
    private String wording=null;
    private String advice=null;

    public String getAdvice() {
        return advice;
    }

    public class Choice{
        private String wording=null;
        private boolean correct=false;

        public String getWording() {
            return wording;
        }

        public boolean isCorrect(){
            return correct;
        }
    }

    public String getWording() {
        return wording;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
