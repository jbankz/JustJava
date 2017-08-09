package justjava.com;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by King - JayCee on 6/12/2017.
 */

public class JustJava extends AppCompatActivity {

    EditText etCustomerName;
    Button btnDecrement, btnIncrement, btnOrder;
    TextView txtQtyDisplay, txtCustomerName;
    CheckBox chkCream, chkChoko, chkMilk;

    int numOfCoffee;

    boolean addCreamToppings, addChokoToppings, addMilkToppings;

    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_just_java);

        etCustomerName = (EditText) findViewById(R.id.customerName);

        btnDecrement = (Button) findViewById(R.id.btnDecrement);
        btnIncrement = (Button) findViewById(R.id.btnIncrement);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        chkCream = (CheckBox) findViewById(R.id.chkCream);


        chkChoko = (CheckBox) findViewById(R.id.chkChoco);


        chkMilk = (CheckBox) findViewById(R.id.chkMilk);

        txtQtyDisplay = (TextView) findViewById(R.id.txtQtyView);
        txtCustomerName = (TextView) findViewById(R.id.txtCustomeName);

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printOrder();
            }
        });
    }

    /**
     * reduces the number of coffee ordered
     **/
    private void decrement() {
        numOfCoffee--;
        txtQtyDisplay.setText("" + numOfCoffee);
    }

    /**
     * increases the number of coffee ordered
     **/
    private void increment() {
        numOfCoffee++;
        txtQtyDisplay.setText("" + numOfCoffee);
    }

    /**
     * calculates the number of coffee ordered
     **/
    public void price(int i) {
        int priceOfCoffee = 5;

        price = i * priceOfCoffee;

        addCreamToppings = chkCream.isChecked();
        addChokoToppings = chkChoko.isChecked();
        addMilkToppings = chkMilk.isChecked();

        String customerName = etCustomerName.getText().toString();

        int newPrice = calculateNewPrice(addCreamToppings, addChokoToppings, addMilkToppings);

        priceMessage(customerName, newPrice, addCreamToppings, addChokoToppings, addMilkToppings);
    }

    private void priceMessage(String name, int price, boolean addCream, boolean addChoko, boolean addMilk) {

        String message = "Name: " + name + "\n";
        message += "addCream: " + addCream + "\n";
        message += "addChoko: " + addChoko + "\n";
        message += "addMilk: " + addMilk + "\n";
        message += "Quantity: " + numOfCoffee + "\n";
        message += "Price: N" + price + "\n";
        message += "Thank You" + "\n";
        txtCustomerName.setText("" + message);
    }

    private int calculateNewPrice(boolean addCream, boolean addChoko, boolean addMilk) {
        int base = 5;
        if (addCream) {
            base = base + 1;
        }
        if (addChoko) {
            base = base + 5;
        }
        if (addMilk) {
            base = base + 3;
        }
        return numOfCoffee * base;
    }

    /**
     * prints out the number of coffee ordered
     **/
    public void printOrder() {
        price(numOfCoffee);
    }
}
