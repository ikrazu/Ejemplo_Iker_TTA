package tta.es.adibide3_1.bean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by irazu on 7/01/16.
 */
public class Data {

    public Test getTest(){
        Test test = new Test();

        test.setQuestion("¿Cuál de las siguientes opciones...?");

        Advise advise = new Advise("http://techslides.com/demos/sample-videos/small.mp4", Advise.AdviseType.HTML);
        //The manifest describes the components of the application: the activities...
        //http://www.realsociedad.com
        //https://youtu.be/IcgeyZGwbGA
        //https://drive.google.com/file/d/0B_jaKEE9PVDWYlhOdTFvVDVGSXc/view?usp=sharing
        //http://u017633.ehu.eus:18080/static/AndroidManifest.mp4
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

    public Test getTest2(){
        Test test = new Test();
        JSONObject json = new JSONObject();
        return null;
    }
}
