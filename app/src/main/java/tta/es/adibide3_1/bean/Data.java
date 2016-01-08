package tta.es.adibide3_1.bean;

import java.util.ArrayList;

/**
 * Created by irazu on 7/01/16.
 */
public class Data {

    public Test getTest(){
        Test test = new Test();

        test.setQuestion("¿Cuál de las siguientes opciones...?");

        Advise advise = new Advise("https://youtu.be/IcgeyZGwbGA", Advise.AdviseType.HTML);
        //The manifest describes the components of the application: the activities...
        //http://www.realsociedad.com
        //https://youtu.be/IcgeyZGwbGA
        //https://drive.google.com/file/d/0B_jaKEE9PVDWYlhOdTFvVDVGSXc/view?usp=sharing
        test.setAdvise(advise);

        ArrayList<Choice> choices = new ArrayList<Choice>();
        for (int i=0;i<5;i++){
            Choice choice = new Choice();
            choice.setAnswer("erantuna " + i);
            choice.setIdChoice(i);
            if (i==2)
                choice.setCorrect(true);
            else
                choice.setCorrect(false);

            choices.add(choice);
        }
        test.setChoices(choices);

        return test;
    }
}
