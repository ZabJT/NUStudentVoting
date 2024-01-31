package com.example.tumang_nustudentcouncil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText FullName;
    String HelloName;
    String name;
    EditText et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullName = findViewById(R.id.FullName);
        et_age = findViewById(R.id.age);
    }

    public void submit(View view) {
        EditText fullName = findViewById(R.id.FullName);
        HelloName = FullName.getText().toString();
        name = fullName.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please Enter your Full Name.", Toast.LENGTH_SHORT).show();
        } else if (!ValidFullName(fullName)) {
            Toast.makeText(this, "Numbers and Special Characters are not valid.", Toast.LENGTH_SHORT).show();
        } else if (et_age.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter your Age.", Toast.LENGTH_SHORT).show();
        } else {
            int age = Integer.parseInt(et_age.getText().toString());
            if (age <= 17) {
                Toast.makeText(this, "You cannot vote.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You can vote.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, VotingActivity.class);
                i.putExtra("name", name);
                startActivity(i);
                finish();
            }
        }
    }

    private boolean ValidFullName(EditText fullName) {
        return fullName.getText().toString().matches("^[a-zA-Z ]+$");
    }

    public void onBackPressed() {

    }
}
