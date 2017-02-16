package matthewallenlinsoftware.billutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class IncomeCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Spinners
    Spinner leftTimeIntervalSpinner;
    Spinner rightTimeIntervalSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_calculator);

        // Left spinner setup
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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
