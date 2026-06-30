package com.example.nexdrive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.nexdrive.R

class ReceptionistDashboardActivity : AppCompatActivity() {

    private lateinit var cardCustomer: CardView
    private lateinit var cardVehicle: CardView
    private lateinit var cardAppointment: CardView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receptionist_dashboard)

        initViews()
        clickListeners()
    }

    private fun initViews() {

        cardCustomer = findViewById(R.id.cardCustomer)
        cardVehicle = findViewById(R.id.cardVehicle)
        cardAppointment = findViewById(R.id.cardAppointment)
        btnLogout = findViewById(R.id.btnLogout)

    }

    private fun clickListeners() {

        cardCustomer.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CustomerRegistrationActivity::class.java
                )
            )

        }

        cardVehicle.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    VehicleEntryActivity::class.java
                )
            )

        }

        cardAppointment.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AppointmentBookingActivity::class.java
                )
            )

        }

        btnLogout.setOnClickListener {

            finish()

        }
    }
}