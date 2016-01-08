package tta.es.adibide3_1.bean;

/**
 * Created by irazu on 7/01/16.
 */
public class Advise {
    private String adviseURL;
    private AdviseType adviseType;

    public Advise(String adviseURL, AdviseType adviseType){
        this.adviseURL = adviseURL;
        this.adviseType = adviseType;
    }

    public String getAdviseURL(){
        return adviseURL;
    }

    public void setAdviseURL(String adviseURL){
        this.adviseURL = adviseURL;
    }

    public AdviseType getAdviseType(){
        return adviseType;
    }

    public void setAdviseType(AdviseType adviseType){
        this.adviseType = adviseType;
    }

    public enum AdviseType{
        HTML, VIDEO, AUDIO;
    }
}
