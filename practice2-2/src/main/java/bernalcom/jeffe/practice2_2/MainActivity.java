package bernalcom.jeffe.practice2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double R_Suma, R_Resta, R_Mult, R_Div;
    EditText First_Number, Second_Number;
    Button Send;
    TextView Text;
    Boolean suma=false,resta=false,multiplicacion=false,division=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        First_Number = (EditText) findViewById(R.id.First_Number);
        Second_Number = (EditText) findViewById(R.id.Second_Number);
        Send = (Button) findViewById(R.id.Send);
        Text= (TextView) findViewById(R.id.Text_view);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Number1=First_Number.getText().toString();
                String Number2=Second_Number.getText().toString();

                if(TextUtils.isEmpty(Number1))
                    First_Number.setError("Digite Este Campo");
                else if(TextUtils.isEmpty(Number2))
                    Second_Number.setError("Digite Este Campo");
                else if (suma.equals(true)){
                    R_Suma = Integer.parseInt(First_Number.getText().toString()) + Integer.parseInt(Second_Number.getText().toString());
                    Text.setText(String.valueOf(R_Suma));
                    suma=false;
                }else if (resta.equals(true)) {
                    R_Resta = Integer.parseInt(First_Number.getText().toString()) - Integer.parseInt(Second_Number.getText().toString());
                    Text.setText(String.valueOf(R_Resta));
                    resta=false;
                }else if (multiplicacion.equals(true)) {
                    R_Mult = R_Suma = Integer.parseInt(First_Number.getText().toString()) * Integer.parseInt(Second_Number.getText().toString());
                    Text.setText(String.valueOf(R_Mult));
                    multiplicacion=false;
                }else if(division.equals(true)) {
                    R_Div = Integer.parseInt(First_Number.getText().toString()) / Integer.parseInt(Second_Number.getText().toString());
                    Text.setText(String.valueOf(R_Div));
                    division=false;
                }



            }
        });


    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Suma:
                if (checked)
                    suma=true;

                break;
            case R.id.Resta:
                if (checked)
                    resta=true;
                break;

            case R.id.Mult:
                if (checked)
                    multiplicacion=true;
                break;
            case R.id.Div:
                if (checked)
                    division=true;
                break;
            default:
                Text.setText("Seleccione Una de las Operaciones");
                break;

        }
    }
}