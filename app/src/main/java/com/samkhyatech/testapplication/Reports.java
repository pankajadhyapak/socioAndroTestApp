package com.samkhyatech.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.gun0912.tedpicker.ImagePickerActivity;

public class Reports extends AppCompatActivity {

    private static final int BLOOD_REPORTS = 1;
    private static final int URINE_REPORTS = 2;
    private static final int XRAY_REPORTS = 3;
    private static final int ECG_REPORTS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void newIntentForPics(int requestCode){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Prescription Images"), requestCode);
    }

    public void onReportsClick(View v){
        int id = v.getId();

        switch (v.getId()){
            case R.id.bloodReports:

                Intent intent  = new Intent(this, ImagePickerActivity.class);
                startActivityForResult(intent,BLOOD_REPORTS);

                break;
            case R.id.urineReports:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, URINE_REPORTS);
                }
                break;
            case R.id.xRayReports:
                newIntentForPics(XRAY_REPORTS);
                break;
            case R.id.ecgReports:
                newIntentForPics(ECG_REPORTS);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
                Toast.makeText(Reports.this, requestCode+"  "+data.getDataString(), Toast.LENGTH_LONG).show();
        }
    }

}
