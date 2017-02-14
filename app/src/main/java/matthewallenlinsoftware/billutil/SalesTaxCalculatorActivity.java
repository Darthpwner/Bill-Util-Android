package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    Button setButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tax_calculator);

        // Initialize EditTexts
        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        numberOfPeopleEditText = (EditText) findViewById(R.id.numberOfPeopleEditText);

        locationEditText = (EditText) findViewById(R.id.locationEditText);
        salesTaxPercentageEditText = (EditText) findViewById(R.id.salesTaxPercentageEditText);
        taxCostEditText = (EditText) findViewById(R.id.taxCostEditText);
        totalEditText = (EditText) findViewById(R.id.totalEditText);
        totalPerPersonEditText = (EditText) findViewById(R.id.totalPerPersonEditText);

        // Initialize Buttons
        calculateButton = (Button) findViewById(R.id.calculateButton);
        setButton = (Button) findViewById(R.id.setButton);
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
