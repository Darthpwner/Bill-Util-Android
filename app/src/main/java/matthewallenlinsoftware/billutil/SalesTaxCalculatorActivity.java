package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.Map;

public class SalesTaxCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Clickable + Editable EditTexts
    EditText billAmountEditText;
    EditText numberOfPeopleEditText;

    // EditTexts
    EditText salesTaxPercentageEditText;
    EditText taxCostEditText;
    EditText totalEditText;
    EditText totalPerPersonEditText;

    // Buttons
    Button calculateButton;

    // Spinner
    Spinner locationSpinner;

    // Object that gets spinner value
    Object spinnerValue;
    Map<String, Double> locationDictionary = new HashMap<String, Double>();
    double salesTaxAmount = 4.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tax_calculator);

        // Load the dictionary
        loadDictionary();

        // Initialize EditTexts
        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        numberOfPeopleEditText = (EditText) findViewById(R.id.numberOfPeopleEditText);

        salesTaxPercentageEditText = (EditText) findViewById(R.id.salesTaxPercentageEditText);
        taxCostEditText = (EditText) findViewById(R.id.taxCostEditText);
        totalEditText = (EditText) findViewById(R.id.totalEditText);
        totalPerPersonEditText = (EditText) findViewById(R.id.totalPerPersonEditText);

        // Initialize Buttons
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // Spinner setup
        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        locationSpinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.salesTaxSpinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        locationSpinner.setAdapter(adapter);
    }

    private void loadDictionary() {
        locationDictionary.put("Alabama", 0.04);
        locationDictionary.put("Alaska", 0.00);
        locationDictionary.put("Arizona", 0.056);
        locationDictionary.put("Arkansas", 0.065);
        locationDictionary.put("California", 0.075);
        locationDictionary.put("Colorado", 0.029);
        locationDictionary.put("Connecticut", 0.0635);
        locationDictionary.put("Delaware", 0.00);
        locationDictionary.put("Florida", 0.06);
        locationDictionary.put("Georgia", 0.04);
        locationDictionary.put("Hawaii", 0.04);
        locationDictionary.put("Idaho", 0.06);
        locationDictionary.put("Illinois", 0.0625);
        locationDictionary.put("Indiana", 0.07);
        locationDictionary.put("Iowa", 0.06);
        locationDictionary.put("Kansas", 0.065);
        locationDictionary.put("Kentucky", 0.06);
        locationDictionary.put("Louisiana", 0.04);
        locationDictionary.put("Maine", 0.055);
        locationDictionary.put("Maryland", 0.06);
        locationDictionary.put("Massachusetts", 0.0625);
        locationDictionary.put("Michigan", 0.06);
        locationDictionary.put("Minnesota", 0.06875);
        locationDictionary.put("Mississippi", 0.07);
        locationDictionary.put("Missouri", 0.04225);
        locationDictionary.put("Montana", 0.00);
        locationDictionary.put("Nebraska", 0.0550);
        locationDictionary.put("Nevada", 0.0685);
        locationDictionary.put("New Hampshire", 0.00);
        locationDictionary.put("New Jersey", 0.07);
        locationDictionary.put("New Mexico", 0.05125);
        locationDictionary.put("New York", 0.04);
        locationDictionary.put("North Carolina", 0.0475);
        locationDictionary.put("North Dakota", 0.05);
        locationDictionary.put("Ohio", 0.0575);
        locationDictionary.put("Oklahoma", 0.045);
        locationDictionary.put("Oregon", 0.00);
        locationDictionary.put("Pennsylvania", 0.06);
        locationDictionary.put("Rhode Island", 0.07);
        locationDictionary.put("South Carolina", 0.06);
        locationDictionary.put("South Dakota", 0.04);
        locationDictionary.put("Tennessee", 0.07);
        locationDictionary.put("Texas", 0.0625);
        locationDictionary.put("Utah", 0.0595);
        locationDictionary.put("Vermont", 0.06);
        locationDictionary.put("Virginia", 0.053);
        locationDictionary.put("Washington", 0.065);
        locationDictionary.put("West Virginia", 0.06);
        locationDictionary.put("Wisconsin", 0.05);
        locationDictionary.put("Wyoming", 0.04);
        locationDictionary.put("D.C.", 0.0575);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerValue = parent.getItemAtPosition(position);

        System.out.println("spinnerValue: " + spinnerValue);
        System.out.println("locationDictionary.get(spinnerValue): " + locationDictionary.get(spinnerValue));
        salesTaxAmount = locationDictionary.get(spinnerValue);
        double salesTaxAmountDisplay = salesTaxAmount * 100;    // For display purposes
        String salesTaxPercentageAsString = String.format("%.2f", salesTaxAmountDisplay);

        salesTaxPercentageEditText.setText(salesTaxPercentageAsString);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Perform calculations
    public void calculateButtonClick(View v) {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        double numberOfPeopleAmount = Double.parseDouble(numberOfPeopleEditText.getText().toString());

        salesTaxAmount = locationDictionary.get(spinnerValue);

        double taxCostAmount = billAmount * salesTaxAmount;
        double totalAmount = billAmount + taxCostAmount;
        double totalAmountPerPerson = totalAmount / numberOfPeopleAmount;

//        double salesTaxAmountDisplay = salesTaxAmount * 100;    //For display purposes
//        String salesTaxPercentageAsString = String.format("%.2f", salesTaxAmountDisplay);
        String billAmountAsString = String.format("%.2f", billAmount);
        String taxCostAmountAsString = String.format("$" + "%.2f", taxCostAmount);
        String totalAmountAsString = String.format("$" + "%.2f", totalAmount);
        String totalAmountPerPersonAsString = String.format("$" + "%.2f", totalAmountPerPerson);

//        salesTaxPercentageEditText.setText(salesTaxPercentageAsString);
        billAmountEditText.setText(billAmountAsString);
        taxCostEditText.setText(taxCostAmountAsString);
        totalEditText.setText(totalAmountAsString);
        totalPerPersonEditText.setText(totalAmountPerPersonAsString);
    }
}
