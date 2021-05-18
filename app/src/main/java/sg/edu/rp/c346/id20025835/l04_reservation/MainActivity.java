package sg.edu.rp.c346.id20025835.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    EditText name;
    EditText number;
    EditText size;
    TextView datedisplay;
    TextView timedisplay;
    Button confirm;
    Button reset;
    RadioGroup rgMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        name = findViewById(R.id.editPersonName);
        number = findViewById(R.id.editPhone);
        size = findViewById(R.id.editNumber);
        datedisplay = findViewById(R.id.datedisplay);
        timedisplay = findViewById(R.id.timedisplay);
        rgMode = findViewById(R.id.rgMode);
        confirm = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);

        dp.updateDate(2020,5,1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                if (name.getText().toString().isEmpty()) {
                    msg = "Please enter name";
                } else if (number.getText().toString().isEmpty()) {
                    msg = "Please enter phone number";
                } else if (size.getText().toString().isEmpty()) {
                    msg = "Please enter size of group";
                } else {
                    msg = String.format("Name: %s \n Number: %s \n Size: %s \n Date: %2d/%2d/%d \n Time: %2d:%2d \n", name.getText().toString(), number.getText().toString(), size.getText().toString());
                    if (rgMode.getCheckedRadioButtonId() == R.id.smokingarea) {
                        msg += "Smoking Area: Yes \n Non-Smoking Area: No";
                    } else {
                        msg += "Smoking Area: No \n Non-Smoking Area: Yes";
                    }
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                size.setText("");
                rgMode.check(R.id.smokingarea);
                dp.updateDate(2020,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });

    }
}