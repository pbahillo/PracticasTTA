package eus.ehu.tta.pbahillo002.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Test implements Serializable {
    public static class Choice{
        private int id;
        private String wording="";
        private boolean correct=false;
        private String advise=null;
        private String mime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getAdvise() {
            return advise;
        }

        public void setAdvise(String advise) {
            this.advise = advise;
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
