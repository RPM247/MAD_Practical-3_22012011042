package com.rpm24.mad_practical_3_22012011042

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val urlbtn = findViewById<Button>(R.id.urlbtn)
        val urlinput = findViewById<EditText>(R.id.urlinput)
        urlbtn.setOnClickListener{
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.setData(android.net.Uri.parse(urlinput.text.toString()))
            startActivity(urlIntent)
        }

        val phonebtn = findViewById<Button>(R.id.phonebtn)
        val phoneinput = findViewById<EditText>(R.id.phoneinput)
        phonebtn.setOnClickListener {
            val phoneNumber = phoneinput.text.toString()
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(phoneIntent)
        }

        val clbtn = findViewById<Button>(R.id.clbtn)
        clbtn.setOnClickListener{
            val clIntent = Intent(Intent.ACTION_VIEW)
            clIntent.setData(android.net.Uri.parse("content://call_log/calls"))
            startActivity(clIntent)
        }

        val glbtn = findViewById<Button>(R.id.glbtn)
        glbtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW).apply {
                type = "image/*"
            }
            startActivity(intent)
        }

        val cmbtn = findViewById<Button>(R.id.cmbtn)
        cmbtn.setOnClickListener{
            val cmIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cmIntent)
        }

        val albtn = findViewById<Button>(R.id.albtn)
        albtn.setOnClickListener{
            val alIntent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(alIntent)
        }
        val login_button=findViewById<Button>(R.id.lgbtn)
        login_button.setOnClickListener{
            Intent(this, LoginActivity::class.java)
                .putExtra("email", "ramipm0724@gmail.com")
                .putExtra("password", "12345678")
                .also{
                    startActivity(it)
                }
            /*val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", "efefwefwefefew")
            intent.putExtra("password", "ygygyg")
            startActivity(intent)*/
        }
    }
}