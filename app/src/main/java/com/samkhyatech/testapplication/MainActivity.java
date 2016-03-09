package com.samkhyatech.testapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onButtonClicked(View view){

        int id = view.getId();

        switch (id){
            case R.id.generalDetails:
                startActivity(new Intent(MainActivity.this, GeneralDetails.class));
                break;
            case R.id.History:
                startActivity(new Intent(MainActivity.this, HistoryTab.class));
                break;
            case R.id.Investigation:
                startActivity(new Intent(MainActivity.this, Investigations.class));
                break;
            case R.id.Medication:
                startActivity(new Intent(MainActivity.this, Medication.class));
                break;
            case R.id.Reports:
                startActivity(new Intent(MainActivity.this, Reports.class));
                break;
            case R.id.ImageUploadTest:
                startActivity(new Intent(MainActivity.this, MyImagePicker.class));
        }
    }
}
