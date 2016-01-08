package tta.es.adibide3_1.bean;

/**
 * Created by irazu on 7/01/16.
 */
public class Choice {

    private String answer;
    private boolean correct;
    private int idChoice;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getIdChoice(){
        return idChoice;
    }

    public void setIdChoice(int idChoice){
        this.idChoice = idChoice;
    }
}
