package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class RentCalculatorActivity extends AppCompatActivity {

    // Clickable + Editable EditText
    EditText monthlyBaseRentEditText;
    EditText electricEditText;
    EditText gasEditText;
    EditText waterEditText;
    EditText internetEditText;
    EditText parkingSpotCostEditText;
    EditText numberOfRoommatesEditText;
    EditText subletterEditText;

    // EditText
    EditText totalCostEditText;
    EditText totalCostPerPersonEditText;

    // Switch
    Switch parkingSpotsSubleasedSwitch;

    // Button
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_calculator);

        // Initialize EditTexts
        monthlyBaseRentEditText = (EditText) findViewById(R.id.monthlyBaseRentEditText);
        electricEditText = (EditText) findViewById(R.id.electricEditText);
        gasEditText = (EditText) findViewById(R.id.gasEditText);
        waterEditText = (EditText) findViewById(R.id.waterEditText);
        internetEditText = (EditText) findViewById(R.id.internetEditText);
        parkingSpotCostEditText = (EditText) findViewById(R.id.parkingSpotCostEditText);
        numberOfRoommatesEditText = (EditText) findViewById(R.id.numberOfRoommatesEditText);
        subletterEditText = (EditText) findViewById(R.id.subletterEditText);
        totalCostEditText = (EditText) findViewById(R.id.totalCostEditText);
        totalCostPerPersonEditText = (EditText) findViewById(R.id.totalCostPerPersonEditText);

        // Initialize Switch
        parkingSpotsSubleasedSwitch = (Switch) findViewById((R.id.parkingSpotSubleasedSwitch));

        // Initialize Button
        calculateButton = (Button) findViewById(R.id.calculateButton);
    }

    //Perform calculations
    public void calculateButtonClick(View v) {
        double monthlyBaseRentAmount, electricAmount, gasAmount, waterAmount, internetAmount, parkingSpotCostAmount;
        int numberOfRoommatesAmount, subletterAmount;

        if(monthlyBaseRentEditText.getText().toString().equals("")) {
            monthlyBaseRentAmount = 0;
        } else {
            monthlyBaseRentAmount = Double.parseDouble(monthlyBaseRentEditText.getText().toString());
        }

        if(electricEditText.getText().toString().equals("")) {
            electricAmount = 0;
        } else {
            electricAmount = Double.parseDouble(electricEditText.getText().toString());
        }

        if(gasEditText.getText().toString().equals("")) {
            gasAmount = 0;
        } else {
            gasAmount = Double.parseDouble(gasEditText.getText().toString());
        }

        if(waterEditText.getText().toString().equals("")) {
            waterAmount = 0;
        } else {
            waterAmount = Double.parseDouble(waterEditText.getText().toString());
        }

        if(internetEditText.getText().toString().equals("")) {
            internetAmount = 0;
        } else {
            internetAmount = Double.parseDouble(internetEditText.getText().toString());
        }

        if(parkingSpotCostEditText.getText().toString().equals("")) {
            parkingSpotCostAmount = 0;
        } else {
            parkingSpotCostAmount = Double.parseDouble(parkingSpotCostEditText.getText().toString());
        }

        if(numberOfRoommatesEditText.getText().toString().equals("")) {
            numberOfRoommatesAmount = 0;
        } else {
            numberOfRoommatesAmount = Integer.parseInt(numberOfRoommatesEditText.getText().toString());
        }

        if(subletterEditText.getText().toString().equals("")) {
            subletterAmount = 0;
        } else {
            subletterAmount = Integer.parseInt(subletterEditText.getText().toString());
        }

        double totalCostAmount = monthlyBaseRentAmount + electricAmount + gasAmount + waterAmount + internetAmount - subletterAmount;

        if(parkingSpotsSubleasedSwitch.isChecked()) {
            totalCostAmount -= parkingSpotCostAmount;
        } else {
            totalCostAmount += parkingSpotCostAmount;
        }

        double totalCostPerPersonAmount = totalCostAmount / (numberOfRoommatesAmount + 1);

        // User controlled strings
        String monthlyBaseRentAmountAsString = String.format("%.2f", monthlyBaseRentAmount);
        String electricAmountAsString = String.format("%.2f", electricAmount);
        String gasAmountAsString = String.format("%.2f", gasAmount);
        String waterAmountAsString = String.format("%.2f", waterAmount);
        String internetAmountAsString = String.format("%.2f", internetAmount);
        String subletterAmountAsString = Integer.toString(subletterAmount);
        String parkingSpotCostAmountAsString = String.format("%.2f", parkingSpotCostAmount);
        String numberOfRoommatesAmountAsString = Integer.toString(numberOfRoommatesAmount);

        // Result strings
        String totalCostAmountAsString = String.format("$" + "%.2f", totalCostAmount);
        String totalCostPerPersonAmountAsString = String.format("$" + "%.2f", totalCostPerPersonAmount);

        // User controlled EditTexts
        monthlyBaseRentEditText.setText(monthlyBaseRentAmountAsString);
        electricEditText.setText(electricAmountAsString);
        gasEditText.setText(gasAmountAsString);
        waterEditText.setText(waterAmountAsString);
        internetEditText.setText(internetAmountAsString);
        subletterEditText.setText(subletterAmountAsString);
        parkingSpotCostEditText.setText(parkingSpotCostAmountAsString);
        numberOfRoommatesEditText.setText(numberOfRoommatesAmountAsString);

        // Result EditTexts
        totalCostEditText.setText(totalCostAmountAsString);
        totalCostPerPersonEditText.setText(totalCostPerPersonAmountAsString);
    }
}
