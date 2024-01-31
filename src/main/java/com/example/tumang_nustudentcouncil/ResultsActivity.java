package com.example.tumang_nustudentcouncil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    TextView PresidentN;
    TextView VicePresidentN;

    String president1;
    String vicepresident1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        PresidentN = findViewById(R.id.PresidentName);
        VicePresidentN = findViewById(R.id.VicePresidentName);



        Intent i = getIntent();
        president1 = i.getStringExtra("president");
        vicepresident1 = i.getStringExtra("vicepresident");


        PresidentN.setText("President: " + president1);
        VicePresidentN.setText("Vice President: " + vicepresident1);
    }

    public void onBackPressed() {


    }
}

