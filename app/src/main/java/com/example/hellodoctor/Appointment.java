package com.example.hellodoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class Appointment extends AppCompatActivity {

        EditText Name;
        EditText phone;
        EditText drname;
        EditText visit;
        Button confirm;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_appointment);

            Name = findViewById(R.id.editTextTextPersonName);
            phone = findViewById(R.id.editTextPhone);
            drname = findViewById(R.id.editTextTextPersonName2);
            visit = findViewById(R.id.editTextTextMultiLine);
            confirm = findViewById(R.id.btn);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkDataEntered();
                }
            });
        }

        boolean isEmail(EditText text) {
            CharSequence email = text.getText().toString();
            return (!TextUtils.isEmpty(email) && Patterns.PHONE.matcher(email).matches());
        }

        boolean isEmpty(EditText text) {
            CharSequence str = text.getText().toString();
            return TextUtils.isEmpty(str);
        }

        void checkDataEntered() {
            if (isEmpty(Name)) {
                Toast t = Toast.makeText(this, "You must enter name to register!", Toast.LENGTH_SHORT);
                t.show();
            }

            if (isEmpty(drname)) {
                drname.setError("doctor name is required!");
            }

            if (isEmail(phone) == false) {
                phone.setError("Enter valid phone no!");
            } }}
