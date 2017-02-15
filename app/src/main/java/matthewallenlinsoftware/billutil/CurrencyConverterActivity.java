package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CurrencyConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // EditTexts
    EditText usDollarEditText;
    EditText euroEditText;
    EditText yenEditText;
    EditText poundEditText;
    EditText francEditText;
    EditText canadianDollarEditText;

    // Clickable + Editable EditTexts
    EditText currentCurrencyEditText;

    // Button
    Button convertButton;

    // Spinner
    Spinner currencySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        // Initialize EditTexts
        usDollarEditText = (EditText) findViewById(R.id.usDollarEditText);
        euroEditText = (EditText) findViewById(R.id.euroEditText);
        yenEditText = (EditText) findViewById(R.id.yenEditText);
        poundEditText = (EditText) findViewById(R.id.poundEditText);
        francEditText = (EditText) findViewById(R.id.francEditText);
        canadianDollarEditText = (EditText) findViewById(R.id.canadianDollarEditText);

        currentCurrencyEditText = (EditText) findViewById(R.id.currentCurrencyEditText);

        // Initialize Button
        convertButton = (Button) findViewById(R.id.convertButton);

        // Spinner setup
        currencySpinner = (Spinner) findViewById(R.id.currencySpinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencyConverterSpinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        currencySpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Perform conversions
    public void convertButtonClick(View v) {

        String temp = "";
        switch (temp) {
            case "US $":
                break;
        }

        //
//        switch pickerValue {
//            case "US $":
//                usDollarAmount = queryAmount
//                euroAmount = queryAmount * 0.93
//                yenAmount = queryAmount * 114.62
//                poundAmount = queryAmount * 0.81
//                francAmount = queryAmount
//                canadianDollarAmount = queryAmount * 1.33
//            case "Euro":
//                usDollarAmount = queryAmount * 1.07
//                euroAmount = queryAmount
//                yenAmount = queryAmount * 122.67
//                poundAmount = queryAmount * 0.86
//                francAmount = queryAmount * 1.07
//                canadianDollarAmount = queryAmount * 1.43
//            case "Yen":
//                usDollarAmount = queryAmount * 0.0087
//                euroAmount = queryAmount * 0.0082
//                yenAmount = queryAmount
//                poundAmount = queryAmount * 0.007
//                francAmount = queryAmount * 0.0087
//                canadianDollarAmount = queryAmount * 0.012
//            case "Pound":
//                usDollarAmount = queryAmount * 1.24
//                euroAmount = queryAmount * 1.16
//                yenAmount = queryAmount * 141.91
//                poundAmount = queryAmount * 1.00
//                francAmount = queryAmount * 1.24
//                canadianDollarAmount = queryAmount * 1.65
//            case "Franc":
//                usDollarAmount = queryAmount
//                euroAmount = queryAmount * 0.93
//                yenAmount = queryAmount * 114.42
//                poundAmount = queryAmount * 0.81
//                francAmount = queryAmount
//                canadianDollarAmount = queryAmount * 1.33
//            case "CA $":
//                usDollarAmount = queryAmount * 0.75
//                euroAmount = queryAmount * 0.7
//                yenAmount = queryAmount * 86.06
//                poundAmount = queryAmount * 0.61
//                francAmount = queryAmount * 0.75
//                canadianDollarAmount = queryAmount
//            default:
//                usDollarAmount = 0
//                euroAmount = 0
//                yenAmount = 0
//                poundAmount = 0
//                francAmount = 0
//                canadianDollarAmount = 0
//        }


    }
}
