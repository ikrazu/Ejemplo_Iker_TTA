package tta.es.adibide3_1;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

import tta.es.adibide3_1.bean.Test;

/**
 * Created by irazu on 8/01/16.
 */
public class Business {
    private final RestClient rest;

    public Business(RestClient rest){
        this.rest = rest;
    }

    /*public Status getStatus(String dni) throws IOException, JSONException{
        //TODO
        return null;
    }*/

    public Test getTest(int id) throws IOException, JSONException{
        //TODO
        return null;
    }

    public Exercise getExercise(int id) throws IOException, JSONException{
        //TODO
        return null;
    }

    public void uploadSolution(int userId, int exerciseId, InputStream inputStream, String fileName) throws IOException{
        //TODO
    }

    public void uploadChoice(int userId, int choiceId) throws JSONException, IOException{
        //TODO
    }

    public class Exercise{
        private int id;
        private String wording;

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getWording(){
            return wording;
        }

        public void setWording(String wording){
            this.wording = wording;
        }
    }
}
