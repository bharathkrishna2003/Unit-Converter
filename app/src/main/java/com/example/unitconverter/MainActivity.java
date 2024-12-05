package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner unitSpinner;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputValue = findViewById(R.id.inputValue);
        unitSpinner = findViewById(R.id.unitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        // Set up the Spinner with unit options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unit_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        // Set up the convert button click listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOption = unitSpinner.getSelectedItem().toString();
                String inputText = inputValue.getText().toString();

                if (inputText.isEmpty()) {
                    resultText.setText("Please enter a value to convert.");
                    return;
                }

                double inputValue = Double.parseDouble(inputText);
                double result = 0;

                switch (selectedOption) {
                    case "Length: Meters to Kilometers":
                        result = inputValue / 1000;
                        resultText.setText(inputValue + " Meters = " + result + " Kilometers");
                        break;
                    case "Length: Kilometers to Meters":
                        result = inputValue * 1000;
                        resultText.setText(inputValue + " Kilometers = " + result + " Meters");
                        break;
                    case "Length: Feet to Meters":
                        result = inputValue * 0.3048;
                        resultText.setText(inputValue + " Feet = " + result + " Meters");
                        break;
                    case "Length: Meters to Feet":
                        result = inputValue / 0.3048;
                        resultText.setText(inputValue + " Meters = " + result + " Feet");
                        break;
                    case "Weight: Grams to Kilograms":
                        result = inputValue / 1000;
                        resultText.setText(inputValue + " Grams = " + result + " Kilograms");
                        break;
                    case "Weight: Kilograms to Grams":
                        result = inputValue * 1000;
                        resultText.setText(inputValue + " Kilograms = " + result + " Grams");
                        break;
                    case "Weight: Pounds to Kilograms":
                        result = inputValue * 0.453592;
                        resultText.setText(inputValue + " Pounds = " + result + " Kilograms");
                        break;
                    case "Weight: Kilograms to Pounds":
                        result = inputValue / 0.453592;
                        resultText.setText(inputValue + " Kilograms = " + result + " Pounds");
                        break;
                    default:
                        resultText.setText("Please select a valid conversion option.");
                        break;
                }
            }
        });
    }
}
