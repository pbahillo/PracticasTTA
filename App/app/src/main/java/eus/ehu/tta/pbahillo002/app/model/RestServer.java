package eus.ehu.tta.pbahillo002.app.model;


import java.io.InputStream;
import java.util.List;

interface RestServer {
    User getStatus(String dni);
    Test getTest(int id);
    Exercise getExercise(int id);
    Boolean postExercise(int userId, int exerciseId, InputStream inputStream, String filename);
    Boolean postChoice(int userId, int choiceId);
}
