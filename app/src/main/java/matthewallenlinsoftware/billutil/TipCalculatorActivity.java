package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TipCalculatorActivity extends AppCompatActivity {

    // Clickable + Editable EditTexts
    EditText billAmountEditText;
    EditText numberOfPeopleEditText;

    // EditTexts
    EditText tipAmountEditText;
    EditText totalEditText;
    EditText tipAmountPerPersonEditText;
    EditText totalPerPersonEditText;

    // Buttons
    Button calculateButton;
    Button setButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        // Initialize EditTexts
        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        numberOfPeopleEditText = (EditText) findViewById(R.id.numberOfPeopleEditText);

        tipAmountEditText = (EditText) findViewById(R.id.tipAmountEditText);
        totalEditText = (EditText) findViewById(R.id.totalEditText);
        tipAmountPerPersonEditText = (EditText) findViewById(R.id.tipAmountPerPersonEditText);
        totalPerPersonEditText = (EditText) findViewById(R.id.totalCostPerPersonEditText);

        // Initialize Buttons
        calculateButton = (Button) findViewById(R.id.calculateButton);
        setButton = (Button) findViewById(R.id.setButton);
    }

    //Perform calculations
    public void calculateButtonClick(View v) {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        double numberOfPeopleAmount = Double.parseDouble(numberOfPeopleEditText.getText().toString());

        // Temp
        double tipPercentage = 0.15;

        double roundedBillAmount = Math.round(100 * billAmount / 100);
        double tipAmount = roundedBillAmount * tipPercentage;
        double roundedTipAmount = Math.round(100 * tipAmount) / 100;
        double totalAmount = roundedBillAmount + roundedTipAmount;
        double roundedTipAmountPerPerson = roundedTipAmount / numberOfPeopleAmount;
        double totalAmountPerPerson = totalAmount / numberOfPeopleAmount;

        String roundedBillAmountAsString = String.format("%.2f", roundedBillAmount);
        String roundedTipAmountAsString = String.format("%.2f", roundedTipAmount);
        String totalAmountAsString = String.format("%.2f", totalAmount);
        String roundedTipAmountPerPersonAsString = String.format("%.2f", roundedTipAmountPerPerson);
        String totalAmountPerPersonAsString = String.format("%.2f", totalAmountPerPerson);

        billAmountEditText.setText(roundedBillAmountAsString);
        tipAmountEditText.setText(roundedTipAmountAsString);
        totalEditText.setText(totalAmountAsString);
        tipAmountPerPersonEditText.setText(roundedTipAmountPerPersonAsString);
        //totalPerPersonEditText.setText(totalAmountPerPersonAsString);
    }
}
