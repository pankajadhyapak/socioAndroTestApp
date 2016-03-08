package com.samkhyatech.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Medication extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void selectPrescriptionImages(View view){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Prescription Images"), PICK_IMAGE);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.PrescriptionTextRadioBtn:
                if (checked)
                    findViewById(R.id.PrescriptionEditText).setVisibility(View.VISIBLE);
                findViewById(R.id.PrescriptionPicBtn).setVisibility(View.GONE);
                break;
            case R.id.PrescriptionImageRadioBtn:
                if (checked)
                    findViewById(R.id.PrescriptionEditText).setVisibility(View.GONE);
                    findViewById(R.id.PrescriptionPicBtn).setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == PICK_IMAGE){
                Toast.makeText(Medication.this, data.getDataString(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onCompleteBtn(View view){
        Toast.makeText(this, "Saving Data", Toast.LENGTH_SHORT).show();
        finish();
    }
}
