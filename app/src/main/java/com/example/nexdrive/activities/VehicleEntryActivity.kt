package com.example.nexdrive.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nexdrive.R

class VehicleEntryActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnCancel: Button
    private lateinit var btnSaveVehicle: Button

    private lateinit var etVehicleId: EditText
    private lateinit var etVehicleNumber: EditText
    private lateinit var etBrand: EditText
    private lateinit var etModel: EditText
    private lateinit var etCustomerId: EditText

    private lateinit var rgVehicleType: RadioGroup
    private lateinit var rgFuelType: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_entry)

        initViews()
        clickListeners()
    }

    private fun initViews() {

        btnBack = findViewById(R.id.btnBack)
        btnCancel = findViewById(R.id.btnCancel)
        btnSaveVehicle = findViewById(R.id.btnSaveVehicle)

        etVehicleId = findViewById(R.id.etVehicleId)
        etVehicleNumber = findViewById(R.id.etVehicleNumber)
        etBrand = findViewById(R.id.etBrand)
        etModel = findViewById(R.id.etModel)
        etCustomerId = findViewById(R.id.etCustomerId)

        rgVehicleType = findViewById(R.id.rgVehicleType)
        rgFuelType = findViewById(R.id.rgFuelType)
    }

    private fun clickListeners() {

        btnBack.setOnClickListener {
            finish()
        }

        btnCancel.setOnClickListener {
            clearFields()
        }

        btnSaveVehicle.setOnClickListener {

            val vehicleId = etVehicleId.text.toString().trim()
            val vehicleNumber = etVehicleNumber.text.toString().trim()
            val brand = etBrand.text.toString().trim()
            val model = etModel.text.toString().trim()
            val customerId = etCustomerId.text.toString().trim()

            if (vehicleId.isEmpty() ||
                vehicleNumber.isEmpty() ||
                brand.isEmpty() ||
                model.isEmpty() ||
                customerId.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (rgVehicleType.checkedRadioButtonId == -1) {
                Toast.makeText(
                    this,
                    "Please select Vehicle Type",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (rgFuelType.checkedRadioButtonId == -1) {
                Toast.makeText(
                    this,
                    "Please select Fuel Type",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val vehicleType = findViewById<RadioButton>(
                rgVehicleType.checkedRadioButtonId
            ).text.toString()

            val fuelType = findViewById<RadioButton>(
                rgFuelType.checkedRadioButtonId
            ).text.toString()

            Toast.makeText(
                this,
                "Vehicle Saved Successfully",
                Toast.LENGTH_SHORT
            ).show()

            clearFields()
        }
    }

    private fun clearFields() {

        etVehicleId.text.clear()
        etVehicleNumber.text.clear()
        etBrand.text.clear()
        etModel.text.clear()
        etCustomerId.text.clear()

        rgVehicleType.clearCheck()
        rgFuelType.clearCheck()
    }
}