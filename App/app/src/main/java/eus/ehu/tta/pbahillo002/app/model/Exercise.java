package eus.ehu.tta.pbahillo002.app.model;


import java.io.Serializable;

public class Exercise implements Serializable{
    private int id;
    private String wording;
    private LessonBean lessonBean;
    public static class LessonBean implements Serializable{
        private int id;
        private int number;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

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

    public LessonBean getLessonBean() {
        return lessonBean;
    }

    public void setLessonBean(LessonBean lessonBean) {
        this.lessonBean = lessonBean;
    }
}
