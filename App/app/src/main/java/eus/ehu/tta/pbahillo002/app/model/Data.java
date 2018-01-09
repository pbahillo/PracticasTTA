package eus.ehu.tta.pbahillo002.app.model;

import java.util.ArrayList;
import java.util.List;

public class Data implements Server {
    //HARDCODED METHODS TO EMULATE THE SERVER
    @Override
    public Test getTest() {
        Test test =new Test();
        List<String> strings=new ArrayList<>();
        List<String> advices=new ArrayList<>();
        List<String> mimes=new ArrayList<>();
        boolean[] b={false,false,true,false,false};

        test.setWording("¿Cual de las siguientes opciones no se indica en el fichero de manifiesto de a app?");

        strings.add("Versión de la aplicación");
        strings.add("Listado de componentes de la aplicación");
        strings.add("Opciones del menu de ajustes");
        strings.add("Nivel mínimo de la API requerida");
        strings.add("Nombre del paquete java de la aplicación");

        advices.add("http://www.ehu.eus");
        advices.add(
                "<html>" +
                        "<body>" +
                            "<p>The manifest describes the <b>components of the aplication: </b>the activities, services,broadcast,... </p>" +
                        "</body>"+
                "</html>");
        advices.add("CONSEJO TRAMPA");
        advices.add("http://u017633.ehu.eus:28080/static/ServidorTta/AndroidManifest.mp4");
        advices.add("http://u017633.ehu.eus:28080/static/ServidorTta/AndroidManifest.mp4");

        mimes.add("text/html");
        mimes.add("text/html");
        mimes.add("MIME TRAMPA");
        mimes.add("video");
        mimes.add("audio");


        for(int i=0;i<5;i++){
            Test.Choice choice=new Test.Choice();
            choice.setWording(strings.get(i));
            choice.setCorrect(b[i]);
            if(!advices.get(1).equals("CONSEJO TRAMPA")) {
                choice.setAdvice(advices.get(i));
                choice.setMime(mimes.get(i));
            }
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
