package tta.es.adibide3_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_LOGIN = "es.tta.ejemplo31.login";
    public final static String EXTRA_PASSWD = "es.tta.ejemplo31.passwd";

    public void login(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        EditText editLogin = (EditText)findViewById(R.id.login);
        EditText editPasswd = (EditText)findViewById(R.id.passwd);
        intent.putExtra(EXTRA_LOGIN, editLogin.getText().toString());
        intent.putExtra(EXTRA_PASSWD, editLogin.getText().toString());
        startActivity(intent);
    }

    public void recordAudio(View view){
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            Toast.makeText(this, R.string.no_micro, Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
                //hemen zerbait falta da???
            else
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK)
            return;
        switch( requestCode) {
            case READ_REQUEST_CODE:
            case VIDEO_REQUEST_CODE:
            case AUDIO_REQUEST_CODE:
                sendFile(data.getData());
                break;
            case PICTURE_REQUEST_CODE:
                sendFile(pictureUri);
                break;
        }
    }
}
