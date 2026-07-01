package com.example.nexdrive.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nexdrive.R

class VehicleEntryActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView

    private lateinit var etVehicleId: EditText
    private lateinit var etVehicleNumber: EditText
    private lateinit var etBrand: EditText
    private lateinit var etModel: EditText
    private lateinit var etCustomerId: EditText

    // Vehicle Type Buttons
    private lateinit var btnTwoWheeler: Button
    private lateinit var btnFourWheeler: Button
    private lateinit var btnLuv: Button

    // Fuel Type Buttons
    private lateinit var btnPetrol: Button
    private lateinit var btnDiesel: Button
    private lateinit var btnElectric: Button
    private lateinit var btnCng: Button

    // Bottom Buttons
    private lateinit var btnCancel: Button
    private lateinit var btnRegisterVehicle: Button

    private var selectedVehicleType = ""
    private var selectedFuelType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_entry)

        btnBack = findViewById(R.id.btnBack)

        etVehicleId = findViewById(R.id.etVehicleId)
        etVehicleNumber = findViewById(R.id.etVehicleNumber)
        etBrand = findViewById(R.id.etBrand)
        etModel = findViewById(R.id.etModel)
        etCustomerId = findViewById(R.id.etCustomerId)

        btnTwoWheeler = findViewById(R.id.btnTwoWheeler)
        btnFourWheeler = findViewById(R.id.btnFourWheeler)
        btnLuv = findViewById(R.id.btnLuv)

        btnPetrol = findViewById(R.id.btnPetrol)
        btnDiesel = findViewById(R.id.btnDiesel)
        btnElectric = findViewById(R.id.btnElectric)
        btnCng = findViewById(R.id.btnCng)

        btnCancel = findViewById(R.id.btnCancel)
        btnRegisterVehicle = findViewById(R.id.btnRegisterVehicle)

        btnBack.setOnClickListener {
            finish()
        }

        // Vehicle Type
        btnTwoWheeler.setOnClickListener {
            selectedVehicleType = "Two Wheeler"
            updateVehicleButtons()
        }

        btnFourWheeler.setOnClickListener {
            selectedVehicleType = "Four Wheeler"
            updateVehicleButtons()
        }

        btnLuv.setOnClickListener {
            selectedVehicleType = "LUV"
            updateVehicleButtons()
        }

        // Fuel Type
        btnPetrol.setOnClickListener {
            selectedFuelType = "Petrol"
            updateFuelButtons()
        }

        btnDiesel.setOnClickListener {
            selectedFuelType = "Diesel"
            updateFuelButtons()
        }

        btnElectric.setOnClickListener {
            selectedFuelType = "Electric"
            updateFuelButtons()
        }

        btnCng.setOnClickListener {
            selectedFuelType = "CNG"
            updateFuelButtons()
        }

        btnCancel.setOnClickListener {
            finish()
        }

        btnRegisterVehicle.setOnClickListener {

            if (etVehicleId.text.isEmpty() ||
                etVehicleNumber.text.isEmpty() ||
                etBrand.text.isEmpty() ||
                etModel.text.isEmpty() ||
                etCustomerId.text.isEmpty() ||
                selectedVehicleType.isEmpty() ||
                selectedFuelType.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Vehicle Registered Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun updateVehicleButtons() {

        resetVehicleButtons()

        when (selectedVehicleType) {

            "Two Wheeler" -> {
                btnTwoWheeler.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnTwoWheeler.setTextColor(Color.WHITE)
            }

            "Four Wheeler" -> {
                btnFourWheeler.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnFourWheeler.setTextColor(Color.WHITE)
            }

            "LUV" -> {
                btnLuv.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnLuv.setTextColor(Color.WHITE)
            }
        }
    }

    private fun updateFuelButtons() {

        resetFuelButtons()

        when (selectedFuelType) {

            "Petrol" -> {
                btnPetrol.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnPetrol.setTextColor(Color.WHITE)
            }

            "Diesel" -> {
                btnDiesel.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnDiesel.setTextColor(Color.WHITE)
            }

            "Electric" -> {
                btnElectric.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnElectric.setTextColor(Color.WHITE)
            }

            "CNG" -> {
                btnCng.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.BLACK))
                btnCng.setTextColor(Color.WHITE)
            }
        }
    }

    private fun resetVehicleButtons() {

        btnTwoWheeler.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))
        btnFourWheeler.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))
        btnLuv.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))

        btnTwoWheeler.setTextColor(Color.BLACK)
        btnFourWheeler.setTextColor(Color.BLACK)
        btnLuv.setTextColor(Color.BLACK)
    }

    private fun resetFuelButtons() {

        btnPetrol.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))
        btnDiesel.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))
        btnElectric.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))
        btnCng.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#EEEEEE")))

        btnPetrol.setTextColor(Color.BLACK)
        btnDiesel.setTextColor(Color.BLACK)
        btnElectric.setTextColor(Color.BLACK)
        btnCng.setTextColor(Color.BLACK)
    }
}