package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val edtSignUpName: EditText = findViewById(R.id.edtSignUpName)
        val edtSignUpId: EditText = findViewById(R.id.edtSignUpId)
        val edtSignUppassword: EditText = findViewById(R.id.edtSignUpPassword)
        val edtSignUpPasswordCheck: EditText = findViewById(R.id.edtSignUpPasswordCheck)

        val btnSignupSignup: TextView = findViewById(R.id.btnSignupSignup)




        btnSignupSignup?.setOnClickListener {
            val edtSignUpName = edtSignUpName?.text.toString()
            val edtSignUpId = edtSignUpId?.text.toString()
            val edtSignUppassword = edtSignUppassword?.text.toString()
            val edtSignUpPasswordCheck = edtSignUpPasswordCheck?.text.toString()

            if (edtSignUpName.isEmpty() || edtSignUpId.isEmpty() || edtSignUppassword.isEmpty() || edtSignUpPasswordCheck.isEmpty()){
                Toast.makeText(this, "모든 빈칸을 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(edtSignUppassword != edtSignUpPasswordCheck){
                Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this@SignUpActivity, MainActivity::class.java)

            intent.putExtra("edtSignUpId", edtSignUpId)
            intent.putExtra("edtSignUppassword", edtSignUppassword)

            startActivity(intent)

        }
    }
}
