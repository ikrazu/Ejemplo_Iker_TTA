package tta.es.adibide3_1.bean;

import java.util.ArrayList;

import tta.es.adibide3_1.bean.Advise;

/**
 * Created by irazu on 7/01/16.
 */
public class Test {

    private String question;
    private Advise advise;
    private ArrayList<Choice> choices = new ArrayList<Choice>();

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public Advise getAdvise(){
        return advise;
    }

    public void setAdvise(Advise advise){
        this.advise = advise;
    }

    public ArrayList<Choice> getChoices(){
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices){
        this.choices = choices;
    }
}
