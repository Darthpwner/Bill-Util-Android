package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SalesTaxCalculatorActivity extends AppCompatActivity {

    // Clickable + Editable EditTexts
    EditText billAmountEditText;
    EditText numberOfPeopleEditText;

    // EditTexts
    EditText locationEditText;
    EditText salesTaxPercentageEditText;
    EditText taxCostEditText;
    EditText totalEditText;
    EditText totalPerPersonEditText;

    // Buttons
    Button calculateButton;

    // Spinner
    Spinner locationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tax_calculator);

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

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.salesTaxSpinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        locationSpinner.setAdapter(adapter);
    }

    //Perform calculations
    public void calculateButtonClick(View v) {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        double numberOfPeopleAmount = Double.parseDouble(numberOfPeopleEditText.getText().toString());

        // Temp
        double salesTaxAmount = 0.075;

        double taxCostAmount = billAmount * salesTaxAmount;
        double totalAmount = billAmount + taxCostAmount;
        double totalAmountPerPerson = totalAmount / numberOfPeopleAmount;

        String billAmountAsString = String.format("%.2f", billAmount);
        String taxCostAmountAsString = String.format("%.2f", taxCostAmount);
        String totalAmountAsString = String.format("%.2f", totalAmount);
        String totalAmountPerPersonAsString = String.format("%.2f", totalAmountPerPerson);

        billAmountEditText.setText(billAmountAsString);
        taxCostEditText.setText(taxCostAmountAsString);
        totalEditText.setText(totalAmountAsString);
        totalPerPersonEditText.setText(totalAmountPerPersonAsString);
    }
}
