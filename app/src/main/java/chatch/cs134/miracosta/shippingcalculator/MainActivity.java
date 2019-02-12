package chatch.cs134.miracosta.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private EditText weightEditText;
    private TextView baseCost;
    private TextView addedCost;
    private TextView totalShippingCost;

    private NumberFormat currency;

    private ShipItem items;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        baseCost = findViewById(R.id.baseCost);
        addedCost = findViewById(R.id.addedCost);
        totalShippingCost = findViewById(R.id.totalShippingCost);
        items = new ShipItem();

        currency = NumberFormat.getCurrencyInstance( new Locale( "ko", "KR"));

        weightEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // Does nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // Take in value from EditText
                // Set value from EditText into ShipItem
                items.setWeight( Double.parseDouble(weightEditText.getText().toString()));

                // Update TextView of baseCost
                baseCost.setText(currency.format(items.getBaseCost()));

                // Update TextView of Added Cost
                addedCost.setText( currency.format(items.calcAddedCost()));

                // Update TextView of TotalCost
                totalShippingCost.setText(currency.format(items.calcCost()));
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // Does nothing
            }
        });
    }

}


