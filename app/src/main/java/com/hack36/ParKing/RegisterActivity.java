package com.hack36.ParKing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hack36.ParKing.Model.DAOEUser;
import com.hack36.ParKing.Model.user;

public class RegisterActivity extends AppCompatActivity {

    //variables
    private EditText userName;
    private EditText email;
    private EditText password;
    private EditText conPassword;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView textViewLogin= findViewById(R.id.textViewLogin);
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conPassword = findViewById(R.id.confirmPassword);
        Register = findViewById(R.id.Register);

        DAOEUser daoeUser = new DAOEUser();

        Register.setOnClickListener(view -> {
            user user= new user(userName.getText().toString(),email.getText().toString(),password.getText().toString(),conPassword.getText().toString());
            daoeUser.add(user).addOnSuccessListener(unused -> Toast.makeText(RegisterActivity.this, "user successfully registered", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(RegisterActivity.this, "error: "+e.getMessage(), Toast.LENGTH_SHORT).show());
        });
        textViewLogin.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));
    }
}