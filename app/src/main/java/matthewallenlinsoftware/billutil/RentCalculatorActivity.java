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
        double monthlyBaseRentAmount = Double.parseDouble(monthlyBaseRentEditText.getText().toString());
        double electricAmount = Double.parseDouble(electricEditText.getText().toString());
        double gasAmount = Double.parseDouble(gasEditText.getText().toString());
        double waterAmount = Double.parseDouble(waterEditText.getText().toString());
        double internetAmount = Double.parseDouble(internetEditText.getText().toString());
        double parkingSpotCostAmount = Double.parseDouble(parkingSpotCostEditText.getText().toString());
        int numberOfRoommatesAmount = Integer.parseInt(numberOfRoommatesEditText.getText().toString());
        int subletterAmount = Integer.parseInt(subletterEditText.getText().toString());

        double totalCostAmount = monthlyBaseRentAmount + electricAmount + gasAmount + waterAmount + internetAmount - subletterAmount;

        if(parkingSpotsSubleasedSwitch.isChecked()) {
            totalCostAmount -= parkingSpotCostAmount;
        } else {
            totalCostAmount += parkingSpotCostAmount;
        }

        double totalCostPerPersonAmount = totalCostAmount / (numberOfRoommatesAmount + 1);

        String totalCostAmountAsString = String.format("$" + "%.2f", totalCostAmount);
        String totalCostPerPersonAmountAsString = String.format("$" + "%.2f", totalCostPerPersonAmount);

        totalCostEditText.setText(totalCostAmountAsString);
        totalCostPerPersonEditText.setText(totalCostPerPersonAmountAsString);
    }
}
