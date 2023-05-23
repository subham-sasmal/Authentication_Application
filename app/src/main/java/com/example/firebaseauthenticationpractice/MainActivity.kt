package com.example.firebaseauthenticationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.FragmentHolder, RegistrationScreen()).commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.FragmentHolder, MainScreen()).commit()
            }
        }

//        supportFragmentManager.beginTransaction().apply {
//            add(R.id.FragmentHolder, RegistrationScreen()).commit()
//        }
    }
}