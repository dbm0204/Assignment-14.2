package com.example.dbm0204.assignment142;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;

/**
 * The mainactivity extends AppCompactActivity and implements onClickListener
 *
 */
public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btnWrite;
    Button btnShow;
    ImageView image;
    Bitmap bitmap;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWrite = (Button) findViewById(R.id.write);
        btnShow = (Button) findViewById(R.id.show);
        image =(ImageView)  findViewById(R.id.image);
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        btnWrite.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    private void storeImage(Bitmap image){
        String path =Environment.getExternalStorageState().toString();
        file=new File(path,"FileName"+"jpg");
        try{
            OutputStream stream =null;
            stream= new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            stream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.write:
                Toast.makeText(getApplicationContext(),"Writing to File",Toast.LENGTH_LONG).show();
                storeImage(bitmap);
                Toast.makeText(getApplicationContext(),"Sucess!",Toast.LENGTH_LONG).show();
                image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_launcher));
                Toast.makeText(getApplicationContext(),"Image shown on Screen",Toast.LENGTH_LONG).show();
            break;
            case R.id.show:
                image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_launcher));
                Toast.makeText(getApplicationContext(),"Image shown on Screen",Toast.LENGTH_LONG).show();
                break;



        }

    }
}
