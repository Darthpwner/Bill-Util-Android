package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
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

    // Button
    Button calculateButton;

    // SeekBar
    SeekBar tipPercentageSeekBar;

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

        // Initialize Button
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // Initialize SeekBar
        tipPercentageSeekBar = (SeekBar) findViewById(R.id.tipPercentageSeekBar);

        tipPercentageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentageValueTextView.setText(Integer.toString(tipPercentageSeekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    //Perform calculations
    public void calculateButtonClick(View v) {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        double numberOfPeopleAmount = Double.parseDouble(numberOfPeopleEditText.getText().toString());

        double tipPercentage = tipPercentageSeekBar.getProgress() * .01;

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
}
