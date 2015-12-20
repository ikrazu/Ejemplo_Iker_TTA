package tta.es.adibide3_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private int correct=0;

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
        correct=2;

    }

    @Override
    public void onClick(View v) {
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void send(View view) {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.test_choices);
        for (int i=0;i<radioGroup.getChildCount();i++)
            radioGroup.getChildAt(i).setEnabled(false);

        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);
        layout.removeView(findViewById(R.id.button_send_test));

        radioGroup.getChildAt(correct).setBackgroundColor(Color.GREEN);
        int selectedId=radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(selectedId);
        int selected = radioGroup.indexOfChild(radioButton);
        if (selected != correct){
            radioGroup.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "¡Has fallado!", Toast.LENGTH_SHORT).show();

            findViewById(R.id.button_help_test).setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(getApplicationContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
        }


        //RadioGroup radioGroup = (RadioGroup)findViewById(R.id.test_choices);
        //int choices = radioGroup.getChildCount();
    }

    public void help(View view) {

    }
}
