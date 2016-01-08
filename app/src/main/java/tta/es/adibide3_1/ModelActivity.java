package tta.es.adibide3_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.prefs.Preferences;

import tta.es.adibide3_1.bean.Data;

/**
 * Created by irazu on 8/01/16.
 */
public class ModelActivity extends AppCompatActivity {

    public static final String URL = "http://server:8080/...";
    protected RestClient rest;
    protected Business server;
    protected Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Data data = new Data(getIntent().getExtras());
        rest = new RestClient(URL);
        String auth = data.getAuthToken();
    }
}
