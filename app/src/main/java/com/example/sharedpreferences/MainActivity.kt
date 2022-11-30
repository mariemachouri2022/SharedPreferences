package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var editTextTextEmailAddress: EditText
    lateinit var editTextTextPassword: EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        button = findViewById(R.id.button)
        readInfo()
        button.setOnClickListener {

           saveInfo()
        }
    }
    // bch nsavi data
    fun saveInfo(){
        if (editTextTextEmailAddress.text.isEmpty()) {
            editTextTextEmailAddress.error = "Please enter your email !!"
        }
        if (editTextTextPassword.text.isEmpty()) {
            editTextTextPassword.error = "Please enter your password !!"
        }
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val editSp = sp.edit()
        editSp.putString("Email", editTextTextEmailAddress.text.toString())
        editSp.putString("Password", editTextTextPassword.text.toString())
        editSp.apply()
        Toast.makeText(this, "Saved !!", Toast.LENGTH_LONG).show()
    }
    //tawa bch nakra data
    fun readInfo(){
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val Email = sp.getString("Email","Not found")
        val Password = sp.getString("Password", "Not found")

        editTextTextEmailAddress.setText(Email)
        editTextTextPassword.setText(Password)
    }
}