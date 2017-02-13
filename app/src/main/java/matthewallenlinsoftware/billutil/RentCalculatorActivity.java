package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class RentCalculatorActivity extends AppCompatActivity {

    // EditText
    EditText monthlyBaseRentEditText;
    EditText electricEditText;
    EditText gasEditText;
    EditText waterEditText;
    EditText internetEditText;
    EditText parkingSpotCostEditText;
    EditText numberOfRoommatesEditText;
    EditText subletterEditText;
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
        totalCostEditText.setText("50");
        totalCostPerPersonEditText.setText("12.5");
    }
}
