package com.example.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Button was clicked.")

            //Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        btnSendMessageToNextActivity.setOnClickListener {
            val message: String= etUserMessage.text.toString()
            showToast(message)
            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            /* next two lines-- Explicit intent declaration: we know what activity to use for the
            intent (intention or process) */
            val intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message: String= etUserMessage.text.toString()

            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type= "text/plain"
            startActivity(Intent.createChooser(intent, "Share to:"))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent= Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }

}
