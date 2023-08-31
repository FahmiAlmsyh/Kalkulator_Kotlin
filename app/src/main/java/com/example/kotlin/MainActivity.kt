package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  edtLength     : TextInputLayout
    private lateinit var  edtWidth      : TextInputLayout
    private lateinit var  edtHeight     : TextInputLayout
    private lateinit var  btnSend       : Button
    private lateinit var  tvResult      : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.edit_length)
        edtWidth = findViewById(R.id.edit_width)
        edtHeight = findViewById(R.id.edit_height)
        btnSend = findViewById(R.id.btn_send)
        tvResult = findViewById(R.id.tv_result)

        btnSend.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_send) {
            val getLength = edtLength.editText?.text.toString().trim()
            val getWidth = edtWidth.editText?.text.toString().trim()
            val getHeight = edtHeight.editText?.text.toString().trim()
            val msg = "Harus Diisi"

            if (getLength.isEmpty()) {
                edtLength.error = msg
                return
            }

            if (getWidth.isEmpty()) {
                edtWidth.error = msg
                return
            }

            if (getHeight.isEmpty()) {
                edtHeight.error = msg
                return
            }

            val result = getLength.toDouble() * getWidth.toDouble() * getHeight.toDouble()
            tvResult.text = result.toString()
        }
    }
}