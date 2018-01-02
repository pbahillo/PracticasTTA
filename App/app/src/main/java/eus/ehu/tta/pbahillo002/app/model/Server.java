package eus.ehu.tta.pbahillo002.app.model;


import java.util.List;

interface Server {
    Test getTest();

    List<User> getUsers();
}
