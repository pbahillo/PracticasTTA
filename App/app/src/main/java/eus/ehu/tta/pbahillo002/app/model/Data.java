package eus.ehu.tta.pbahillo002.app.model;

import java.util.ArrayList;
import java.util.List;

public class Data implements Server {
    //HARDCODED METHODS TO EMULATE THE SERVER
    @Override
    public Test getTest() {
        Test test =new Test();
        List<String> strings=new ArrayList<>();
        boolean[] b={false,false,true,false,false};
        strings.add("Versión de la aplicación");
        strings.add("Listado de componentes de la aplicación");
        strings.add("Opciones del menu de ajustes");
        strings.add("Nivel mínimo de la API requerida");
        strings.add("Nombre del paquete java de la aplicación");
        test.setWording("¿Cual de las siguientes opciones no se indica en el fichero de manifiesto de a app?");
        test.setAdvice("FALTA EL CONSEJO");
        for(int i=0;i<5;i++){
            Test.Choice choice=new Test.Choice();
            choice.setWording(strings.get(i));
            choice.setCorrect(b[i]);
            test.getChoices().add(choice);
        }
        return test;
    }

    @Override
    public List<User> getUsers() {
        List<String> names=new ArrayList<>();
        List<String> login=new ArrayList<>();
        List<String> passwd=new ArrayList<>();
        List<User> users=new ArrayList<>();

        names.add("Pablo Bahillo");
        names.add("Gorka Prieto");
        names.add("John Doe");

        login.add("45950466P");
        login.add("45671825N");
        login.add("1234");

        passwd.add("pablo");
        passwd.add("gorka");
        passwd.add("1234");

        for (int i=0;i<names.size();i++){
            User user=new User();
            user.setLogin(login.get(i));
            user.setName(names.get(i));
            user.setPasswd(passwd.get(i));
            users.add(user);
        }
        return users;
    }

}
