package tta.es.adibide3_1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import tta.es.adibide3_1.bean.Choice;
import tta.es.adibide3_1.bean.Data;
import tta.es.adibide3_1.bean.Test;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private int correct;
    private String advise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Data data = new Data();
        Test test = data.getTest();

        TextView textView = (TextView)findViewById(R.id.test_wording);
        textView.setText(test.getQuestion());
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.test_choices);
        for(Choice choice : test.getChoices()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(choice.getAnswer());
            radioButton.setOnClickListener(this);
            radioGroup.addView(radioButton);
            if(choice.getCorrect())
                correct=choice.getIdChoice();
        }
        //correct=2;
        //advise="The manifest describes the components of the application: the activities...";
        //advise="http://www.realsociedad.com";
        //advise="https://youtu.be/IcgeyZGwbGA";
        //advise="https://drive.google.com/file/d/0B_jaKEE9PVDWYlhOdTFvVDVGSXc/view?usp=sharing";
        advise=test.getAdvise().getAdviseURL();
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

    }

    public void help(View view) {

        /*if(advise.contains("://")){
            Uri uri = Uri.parse(advise);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else {
            WebView webView = new WebView(this);
            //webView.loadUrl(advise);
            webView.loadData(advise, "text/html", null);
            webView.setBackgroundColor(Color.TRANSPARENT);
            webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);

            LinearLayout layout = (LinearLayout) findViewById(R.id.test_layout);
            layout.addView(webView);
            layout.removeView(findViewById(R.id.button_help_test));
        }*/
        showVideo(advise);
        LinearLayout layout = (LinearLayout) findViewById(R.id.test_layout);
        layout.removeView(findViewById(R.id.button_help_test));
    }

    private void showVideo(String advise){
        VideoView videoView = new VideoView(this);
        videoView.setVideoURI(Uri.parse(advise));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        videoView.setLayoutParams(params);

        MediaController mediaController = new MediaController(this) {
            @Override
            public void hide(){
            }

            @Override
            public boolean dispatchKeyEvent(KeyEvent keyEvent){
                if(keyEvent.getKeyCode() == keyEvent.KEYCODE_BACK)
                    finish();
                return super.dispatchKeyEvent(keyEvent);
            }
        };
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        LinearLayout layout = (LinearLayout) findViewById(R.id.test_layout);
        layout.addView(videoView);
        videoView.start();
    }
}
