package com.zybooks.pizzaparty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public final static int SLICES_PER_PIZZA = 8;

    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mHowHungryRadioGroup;
    private RadioGroup mPizzaSizeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the widgets to fields
        mNumAttendEditText = findViewById(R.id.num_attend_edit_text);
        mNumPizzasTextView = findViewById(R.id.num_pizzas_text_view);
        mHowHungryRadioGroup = findViewById(R.id.hungry_radio_group);
        mPizzaSizeGroup = findViewById(R.id.pizzasize_radio_group);
    }

    public void calculateClick(View view) {

        // Get how many are attending the party
        int numAttend;
        try {
            String numAttendStr = mNumAttendEditText.getText().toString();
            numAttend = Integer.parseInt(numAttendStr);
        }
        catch (NumberFormatException ex) {
            numAttend = 0;
        }

        // Get hunger level selection
        int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
        PizzaCalculator.HungerLevel hungerLevel = PizzaCalculator.HungerLevel.RAVENOUS;
        if (checkedId == R.id.light_radio_button) {
            hungerLevel = PizzaCalculator.HungerLevel.LIGHT;
        }
        else if (checkedId == R.id.medium_radio_button) {
            hungerLevel = PizzaCalculator.HungerLevel.MEDIUM;
        }
        //Get Pizza Size
        int checkedSizeId = mPizzaSizeGroup.getCheckedRadioButtonId();
        PizzaCalculator.PizzaSize size = PizzaCalculator.PizzaSize.LARGE;
        if (checkedSizeId == R.id.smallsize_radio_button)
            size = PizzaCalculator.PizzaSize.SMALL;
        else if (checkedSizeId == R.id.mediumsize_radio_button)
            size = PizzaCalculator.PizzaSize.MEDIUM;

        // Get the number of pizzas needed
        PizzaCalculator calc = new PizzaCalculator(numAttend, hungerLevel, size);
        int totalPizzas = calc.getTotalPizzas();

        // Place totalPizzas into the string resource and display
        String totalText = getString(R.string.total_pizzas, totalPizzas);
        mNumPizzasTextView.setText(totalText);
    }
}