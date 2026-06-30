package com.example.nexdrive.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nexdrive.R

class CustomerRegistrationActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView

    private lateinit var etCustomerId: EditText
    private lateinit var etCustomerName: EditText
    private lateinit var etMobile: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAddress: EditText

    private lateinit var btnRegisterCustomer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_registration)

        initViews()
        clickListeners()
    }

    private fun initViews() {

        btnBack = findViewById(R.id.btnBack)

        etCustomerId = findViewById(R.id.etCustomerId)
        etCustomerName = findViewById(R.id.etCustomerName)
        etMobile = findViewById(R.id.etMobile)
        etEmail = findViewById(R.id.etEmail)
        etAddress = findViewById(R.id.etAddress)

        btnRegisterCustomer = findViewById(R.id.btnRegisterCustomer)
    }

    private fun clickListeners() {

        btnBack.setOnClickListener {
            finish()
        }

        btnRegisterCustomer.setOnClickListener {

            val customerId = etCustomerId.text.toString().trim()
            val customerName = etCustomerName.text.toString().trim()
            val mobile = etMobile.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val address = etAddress.text.toString().trim()

            if (customerId.isEmpty() ||
                customerName.isEmpty() ||
                mobile.isEmpty() ||
                email.isEmpty() ||
                address.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Customer Registered Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                clearFields()
            }
        }
    }

    private fun clearFields() {

        etCustomerId.text.clear()
        etCustomerName.text.clear()
        etMobile.text.clear()
        etEmail.text.clear()
        etAddress.text.clear()

    }
}