package tta.es.adibide3_1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ExerciseActivity extends AppCompatActivity {

    private static final int PICTURE_REQUEST_CODE = 100;
    private Uri pictureUri;

    private static final int VIDEO_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void takePhoto(View view){
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this, R.string.no_camera, Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager()) != null) {
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try {
                    File file = File.createTempFile("tta", ".jpg", dir);
                    pictureUri = Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                    startActivityForResult(intent, PICTURE_REQUEST_CODE);
                }catch (IOException e){
                }
            }else
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();
        }
    }

    public void recordVideo(View view){
        if( !getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this, R.string.no_camera, Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent, VIDEO_REQUEST_CODE);
            else
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();
        }
    }

}
