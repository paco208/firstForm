package com.example.registracijskiobrazec;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editUsername, editFullName, editCountry, editEmail, editPhone, editPassword;
    RadioGroup radioGroupGender;
    CheckBox checkTerms;
    Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editUsername = findViewById(R.id.editUsername);
        editFullName = findViewById(R.id.editFullName);
        editCountry = findViewById(R.id.editCountry);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editPassword = findViewById(R.id.editPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkTerms = findViewById(R.id.checkTerms);
        buttonCreate = findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prikaziPodatke();
            }
        });
    }

    private void prikaziPodatke() {
        String username = editUsername.getText().toString();
        String fullName = editFullName.getText().toString();
        String country = editCountry.getText().toString();
        String email = editEmail.getText().toString();
        String phone = editPhone.getText().toString();
        String password = editPassword.getText().toString();

        String gender = "";
        int izbran = radioGroupGender.getCheckedRadioButtonId();
        if (izbran == R.id.radioMale) {
            gender = "Male";
        } else if (izbran == R.id.radioFemale) {
            gender = "Female";
        }

        String terms;
        if (checkTerms.isChecked()) {
            terms = "Yes";
        } else {
            terms = "No";
        }

        String sporocilo = "Username: " + username + "\n"
                + "Name: " + fullName + "\n"
                + "Country: " + country + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n"
                + "Password: " + password + "\n"
                + "Gender: " + gender + "\n"
                + "Terms Accepted: " + terms;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Registration Details");
        builder.setMessage(sporocilo);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}