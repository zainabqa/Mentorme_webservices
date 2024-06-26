package com.zainab.i200631

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Activity6 : AppCompatActivity() {
    var mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_6)


        var back = findViewById<ImageView>(R.id.arrow)
        back.setOnClickListener {
            startActivity(
                Intent(this, Activity5::class.java)
            );
        }

        var login = findViewById<View>(R.id.login)
        login.setOnClickListener {
            startActivity(
                Intent(this, Activity2::class.java)
            );
        }

        var resetPass = findViewById<View>(R.id.submit)
        /*resetPass.setOnClickListener {
            startActivity(
                Intent(this, Activity7::class.java)
            );
        }*/
        resetPass.setOnClickListener {
            val newPassword = findViewById<EditText>(R.id.newPassword).text.toString()
            val reEnterPassword = findViewById<EditText>(R.id.reEnterPassword).text.toString()

            if (newPassword == reEnterPassword) {
                // call a function to update the password in database
                mAuth.currentUser?.updatePassword(newPassword)
                Toast.makeText(this, "Password updated successfully", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(this, Activity7::class.java)
                );
                finish();
            } else {
                // Show an error message to the user
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }

}