package com.example.tumang_nustudentcouncil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class VotingActivity extends AppCompatActivity {

    TextView HelloName1;
    String HelloName;
    RadioGroup radioGroupPresident;
    RadioGroup radioGroupVicePresident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        HelloName1 = findViewById(R.id.HelloName1);
        Intent i = getIntent();
        HelloName = i.getStringExtra("HelloName");
        HelloName1.setText("Hello, " + HelloName);

        radioGroupPresident = findViewById(R.id.radioGroupPresident);
        radioGroupVicePresident = findViewById(R.id.radioGroupVicePresident);
    }

    public void submitvote(View view) {
        int selectedPresidentId = radioGroupPresident.getCheckedRadioButtonId();
        int selectedVicePresidentId = radioGroupVicePresident.getCheckedRadioButtonId();

        if (selectedPresidentId == -1 || selectedVicePresidentId == -1) {
            Toast.makeText(this, "Please vote for President and Vice President.", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButtonPresident = findViewById(selectedPresidentId);
        RadioButton radioButtonVicePresident = findViewById(selectedVicePresidentId);

        String president1 = radioButtonPresident.getText().toString();
        String vicepresident1 = radioButtonVicePresident.getText().toString();

        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("president", president1);
        i.putExtra("vicepresident", vicepresident1);
        startActivity(i);
    }

    public void onBackPressed() {


    }
}
