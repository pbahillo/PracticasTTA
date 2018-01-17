package eus.ehu.tta.pbahillo002.app.model;


import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String user;
    private int lessonNumber;
    private String LessonTitle;
    private int nextTest;
    private int nextExercise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getLessonTitle() {
        return LessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        LessonTitle = lessonTitle;
    }

    public int getNextTest() {
        return nextTest;
    }

    public void setNextTest(int nextTest) {
        this.nextTest = nextTest;
    }

    public int getNextExercise() {
        return nextExercise;
    }

    public void setNextExercise(int nextExercise) {
        this.nextExercise = nextExercise;
    }

}
