package eus.ehu.tta.pbahillo002.app.model;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static class Choice{
        private String wording="";
        private boolean correct=false;
        private String advice=null;
        private String mime;
        public String getWording() {
            return wording;
        }

        public void setWording(String wording) {
            this.wording = wording;
        }

        public boolean isCorrect() {
            return correct;
        }

        public void setCorrect(boolean correct) {
            this.correct = correct;
        }

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public String getMime() {
            return mime;
        }

        public void setMime(String mime) {
            this.mime = mime;
        }
    }

    private List<Choice> choices=new ArrayList<>(0);
    private String wording=null;


    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
}
