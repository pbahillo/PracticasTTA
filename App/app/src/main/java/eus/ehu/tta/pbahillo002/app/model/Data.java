package eus.ehu.tta.pbahillo002.app.model;

import java.util.ArrayList;
import java.util.List;

public class Data implements Server {
    //HARDCODED METHOD TO GET TEST
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
}
