package tta.es.adibide3_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        TextView textLogin = (TextView)findViewById(R.id.menu_login);
        textLogin.setText("Bienvenido "+intent.getStringExtra(MainActivity.EXTRA_LOGIN));

    }

    public void test(View view){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void newExercise(View view){
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }

    public void seguimiento(View view){
        Toast.makeText(this, "\"Seguimiento\" sin implementar", Toast.LENGTH_SHORT).show();
    }
}