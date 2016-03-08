package com.samkhyatech.testapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class HistoryTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.AnysurgeriesconductedYesRadioBtn:
                if (checked)
                    findViewById(R.id.AnysurgeriesconductedEditText).setVisibility(View.VISIBLE);
                    break;
            case R.id.AnysurgeriesconductedNoRadioBtn:
                if (checked)
                    findViewById(R.id.AnysurgeriesconductedEditText).setVisibility(View.GONE);
                    break;
        }
    }

}
