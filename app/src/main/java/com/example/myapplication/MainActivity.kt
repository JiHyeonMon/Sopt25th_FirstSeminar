package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id: EditText = findViewById(R.id.edtid)
        val password: EditText = findViewById(R.id.edtpassword)
        val login: TextView = findViewById(R.id.btnsigninsignin)
        val signup: TextView = findViewById(R.id.btnsigninsignup)

        id.setText(intent.getStringExtra("edtSignUpId"))
        password.setText(intent.getStringExtra("edtSignUppassword"))

        login?.setOnClickListener{
            val id = id?.text.toString()
            val password = password?.text.toString()

            if (id.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "아이디나 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val response = requestLogin(id, password)

            if(response){
                val intent = Intent(this@MainActivity, SignUpActivity::class.java)

            }else{
                Toast.makeText(this, "로그인에 실패", Toast.LENGTH_LONG).show()
            }

        }

        signup?.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)

            startActivity(intent)

        }
    }
    private fun requestLogin(id: String, password: String):Boolean{
        return true
    }
}
