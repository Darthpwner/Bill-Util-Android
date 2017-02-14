package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TipCalculatorActivity extends AppCompatActivity {

    // TextView
    TextView tipPercentageValueTextView;

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

    // ProgressBar
    ProgressBar tipPercentageProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        // Initalize TextView
        tipPercentageValueTextView = (TextView) findViewById(R.id.tipPercentageValueTextView);

        // Initialize EditTexts
        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        numberOfPeopleEditText = (EditText) findViewById(R.id.numberOfPeopleEditText);

        tipAmountEditText = (EditText) findViewById(R.id.tipAmountEditText);
        totalEditText = (EditText) findViewById(R.id.totalEditText);
        tipAmountPerPersonEditText = (EditText) findViewById(R.id.tipAmountPerPersonEditText);
        totalPerPersonEditText = (EditText) findViewById(R.id.totalPerPersonEditText);

        // Initialize Buttons
        calculateButton = (Button) findViewById(R.id.calculateButton);
        setButton = (Button) findViewById(R.id.setButton);

        // Initialize ProgressBar
        tipPercentageProgressBar = (ProgressBar) findViewById(R.id.tipPercentageProgressBar);
    }

    //Perform calculations
    public void calculateButtonClick(View v) {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        double numberOfPeopleAmount = Double.parseDouble(numberOfPeopleEditText.getText().toString());

        // Temp
        double tipPercentage = tipPercentageProgressBar.getProgress() * .01;
        //Temp

        double tipAmount = billAmount * tipPercentage;
        double tipAmountPerPerson = tipAmount / numberOfPeopleAmount;
        double totalAmount = billAmount + tipAmount;
        double totalAmountPerPerson = totalAmount / numberOfPeopleAmount;

        String billAmountAsString = String.format("%.2f", billAmount);
        String tipAmountAsString = String.format("%.2f", tipAmount);
        String totalAmountAsString = String.format("%.2f", totalAmount);
        String tipAmountPerPersonAsString = String.format("%.2f", tipAmountPerPerson);
        String totalPerPersonAsString = String.format("%.2f", totalAmountPerPerson);

        billAmountEditText.setText(billAmountAsString);
        tipAmountEditText.setText(tipAmountAsString);
        totalEditText.setText(totalAmountAsString);
        tipAmountPerPersonEditText.setText(tipAmountPerPersonAsString);
        totalPerPersonEditText.setText(totalPerPersonAsString);
    }

    public void setButton(View v) {
        int temp = (int) (Math.random() % 100);

        tipPercentageProgressBar.setProgress(temp);
        tipPercentageValueTextView.setText(tipPercentageProgressBar.getProgress());
    }
}
