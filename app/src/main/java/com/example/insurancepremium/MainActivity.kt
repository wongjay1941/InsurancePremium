package com.example.insurancepremium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurancepremium.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            //Determine the age group
            val age = binding.spinnerAge.selectedItemPosition

            val basicPremium = when(age) {
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4 -> 150
                else ->
                    150
            }

            //Determine the gender
            val gender = binding.radioGroupGender.checkedRadioButtonId
            var malePremium = 0
            if(gender == binding.radioButtonMale.id){
                //Male extra premium
                malePremium = when(age){
                    0 -> 0
                    1 -> 50
                    2 -> 100
                    3 -> 150
                    4 -> 200
                    else ->
                        200
                }
            }

            //Determine the smoker
            var smokerPremium = 0
            if(binding.checkBoxSmoker.isChecked){
                //Smoker
                smokerPremium = when(age){
                    0 -> 0
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    else ->
                        300
                }
            }

            val total = basicPremium + malePremium + smokerPremium

            //Display Results
            binding.textViewSmokerPremium.text = smokerPremium.toString()
            binding.textViewTotal.text = total.toString()
        }

        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false

            binding.textViewSmokerPremium.text = ""
            binding.textViewTotal.text = ""
        }
    }
}