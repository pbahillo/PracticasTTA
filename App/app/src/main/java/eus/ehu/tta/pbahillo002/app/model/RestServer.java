package eus.ehu.tta.pbahillo002.app.model;


import java.util.List;

interface RestServer {
    User getStatus(String dni);
    Test getTest(int id);
    Exercise getExercise(int id);
    int postExercise(int userId,int exerciseId);
    int postChoice();
}
