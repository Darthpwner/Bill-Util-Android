package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class IncomeCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    final double HOURS_PER_YEAR = 2080.0;
    final double MONTHS_PER_YEAR = 12.0;

    // Button
    Button calculateButton;

    // Left side

    // Clickable + Editable EditTexts
    EditText leftIncomeEditText;
    EditText leftBonusesEditText;
    EditText leftRSUsEditText;

    // Spinner
    Spinner leftTimeIntervalSpinner;

    // Left Object that gets spinner value
    Object leftSpinnerValue;

    // EditTexts
    EditText leftOneYearEditText;
    EditText leftTwoYearsEditText;
    EditText leftFiveYearsEditText;
    EditText leftTenYearsEditText;
    EditText leftTwentyYearsEditText;

    // Right side

    // Clickable + Editable EditTexts
    EditText rightIncomeEditText;
    EditText rightBonusesEditText;
    EditText rightRSUsEditText;

    // Spinner
    Spinner rightTimeIntervalSpinner;

    // EditTexts
    EditText rightOneYearEditText;
    EditText rightTwoYearsEditText;
    EditText rightFiveYearsEditText;
    EditText rightTenYearsEditText;
    EditText rightTwentyYearsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_calculator);

        //  Initialize Button
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // Initialize left EditTexts
        leftIncomeEditText = (EditText) findViewById(R.id.leftIncomeEditText);
        leftBonusesEditText = (EditText) findViewById(R.id.leftBonusesEditText);
        leftRSUsEditText = (EditText) findViewById(R.id.leftRSUsEditText);

        leftOneYearEditText = (EditText) findViewById(R.id.leftOneYearEditText);
        leftTwoYearsEditText = (EditText) findViewById(R.id.leftTwoYearsEditText);
        leftFiveYearsEditText = (EditText) findViewById(R.id.leftFiveYearsEditText);
        leftTenYearsEditText = (EditText) findViewById(R.id.leftTenYearsEditText);
        leftTwentyYearsEditText = (EditText) findViewById(R.id.leftTwentyYearsEditText);

        // Initialize right EditTexts
        rightIncomeEditText = (EditText) findViewById(R.id.rightIncomeEditText);
        rightBonusesEditText = (EditText) findViewById(R.id.rightBonusesEditText);
        rightRSUsEditText = (EditText) findViewById(R.id.rightRSUsEditText);

        rightOneYearEditText = (EditText) findViewById(R.id.rightOneYearEditText);
        rightTwoYearsEditText = (EditText) findViewById(R.id.rightTwoYearsEditText);
        rightFiveYearsEditText = (EditText) findViewById(R.id.rightFiveYearsEditText);
        rightTenYearsEditText = (EditText) findViewById(R.id.rightTenYearsEditText);
        rightTwentyYearsEditText = (EditText) findViewById(R.id.rightTwentyYearsEditText);

        // Left spinner setup
        leftSpinnerValue = new Object();

        leftTimeIntervalSpinner = (Spinner) findViewById(R.id.leftSpinner);
        leftTimeIntervalSpinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.leftTimeIntervalSpinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        leftTimeIntervalSpinner.setAdapter(adapter);

        // Right spinner setup

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        leftSpinnerValue = parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculateButtonClick(View v) {
        double leftIncomeAmount = Double.parseDouble(leftIncomeEditText.getText().toString());
        double leftBonusesAmount = Double.parseDouble(leftBonusesEditText.getText().toString());
        double leftRSUsAmount = Double.parseDouble(leftRSUsEditText.getText().toString());

        double leftAnnualSalary = 0;

        System.out.println("leftSpinnerValue: " + leftSpinnerValue);

        if(leftSpinnerValue.equals("Hourly")) {
            leftAnnualSalary = leftIncomeAmount * HOURS_PER_YEAR + leftRSUsAmount;
            System.out.println("HOURS: " + HOURS_PER_YEAR);
        } else if(leftSpinnerValue.equals("Monthly")) {
            leftAnnualSalary = leftIncomeAmount * MONTHS_PER_YEAR + leftRSUsAmount;
        } else {
            leftAnnualSalary = leftIncomeAmount * 1 + leftRSUsAmount;
        }

        System.out.println("leftAnnualSalary: " + leftAnnualSalary);

        double leftOneYearAmount = leftAnnualSalary + leftBonusesAmount;
        double leftTwoYearsAmount = 2 * leftAnnualSalary + leftBonusesAmount;
        double leftFiveYearsAmount = 5 * leftAnnualSalary + leftBonusesAmount;
        double leftTenYearsAmount = 10 * leftAnnualSalary + leftBonusesAmount;
        double leftTwentyYearsAmount = 20 * leftAnnualSalary + leftBonusesAmount;

        String leftOneYearAmountAsString = String.format("%.2f", leftOneYearAmount);
        String leftTwoYearsAmountAsString = String.format("%.2f", leftTwoYearsAmount);
        String leftFiveYearsAmountAsString = String.format("%.2f", leftFiveYearsAmount);
        String leftTenYearsAmountAsString = String.format("%.2f", leftTenYearsAmount);
        String leftTwentyYearsAmountAsString = String.format("%.2f", leftTwentyYearsAmount);

        leftOneYearEditText.setText(leftOneYearAmountAsString);
        leftTwoYearsEditText.setText(leftTwoYearsAmountAsString);
        leftFiveYearsEditText.setText(leftFiveYearsAmountAsString);
        leftTenYearsEditText.setText(leftTenYearsAmountAsString);
        leftTwentyYearsEditText.setText(leftTwentyYearsAmountAsString);



    }
}
