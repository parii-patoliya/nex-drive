package com.example.nexdrive.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.nexdrive.R
import java.util.Calendar

class AppointmentBookingActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView

    private lateinit var etAppointmentId: EditText
    private lateinit var etCustomerId: EditText
    private lateinit var etVehicleId: EditText
    private lateinit var etDate: EditText
    private lateinit var etTime: EditText
    private lateinit var etProblem: EditText

    private lateinit var spServiceType: Spinner

    private lateinit var btnBookAppointment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_booking)

        btnBack = findViewById(R.id.btnBack)

        etAppointmentId = findViewById(R.id.etAppointmentId)
        etCustomerId = findViewById(R.id.etCustomerId)
        etVehicleId = findViewById(R.id.etVehicleId)
        etDate = findViewById(R.id.etDate)
        etTime = findViewById(R.id.etTime)
        etProblem = findViewById(R.id.etProblem)

        spServiceType = findViewById(R.id.spServiceType)

        btnBookAppointment = findViewById(R.id.btnBookAppointment)

        val services = arrayOf(
            "Select Service",
            "General Service",
            "Oil Change",
            "Car Wash",
            "Engine Repair",
            "Brake Service",
            "Battery Check",
            "AC Service"
        )

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            services
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spServiceType.adapter = adapter

        etDate.setOnClickListener {
            showDatePicker()
        }

        etTime.setOnClickListener {
            showTimePicker()
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnBookAppointment.setOnClickListener {

            val appointmentId = etAppointmentId.text.toString().trim()
            val customerId = etCustomerId.text.toString().trim()
            val vehicleId = etVehicleId.text.toString().trim()
            val date = etDate.text.toString().trim()
            val time = etTime.text.toString().trim()
            val problem = etProblem.text.toString().trim()

            if (
                appointmentId.isEmpty() ||
                customerId.isEmpty() ||
                vehicleId.isEmpty() ||
                date.isEmpty() ||
                time.isEmpty() ||
                problem.isEmpty() ||
                spServiceType.selectedItemPosition == 0
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Appointment Booked Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                clearFields()
            }
        }
    }

    private fun showDatePicker() {

        val calendar = Calendar.getInstance()

        DatePickerDialog(
            this,
            { _, year, month, day ->
                etDate.setText("$day/${month + 1}/$year")
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showTimePicker() {

        val calendar = Calendar.getInstance()

        TimePickerDialog(
            this,
            { _, hour, minute ->
                etTime.setText(String.format("%02d:%02d", hour, minute))
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()
    }

    private fun clearFields() {

        etAppointmentId.text.clear()
        etCustomerId.text.clear()
        etVehicleId.text.clear()
        etDate.text.clear()
        etTime.text.clear()
        etProblem.text.clear()

        spServiceType.setSelection(0)
    }
}