package tta.es.adibide3_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView)findViewById(R.id.test_wording);
        textView.setText("Galdera?");
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.test_choices);
        for(int i=0;i<5;i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText("erantzuna" + i);
            radioButton.setOnClickListener(this);
            radioGroup.addView(radioButton);
        }

    }

    @Override
    public void onClick(View v) {
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void send(View view) {
        
    }
}
