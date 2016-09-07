package bernalcom.jeffe.practice2_4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    private  EditText Login,Password,Password1,Correo,eDate;
    private TextView Result,tSexo;
    private Button Send;
    private int day;
    private int month;
    private int year;
    String password,password1,Email,Ciudad,Sexo,login,Fecha,hobbies;
    private static final int TipoDialogo=0;
    private static DatePickerDialog.OnDateSetListener oyenteselector;
    private Spinner Ciudades;
    boolean Hombre=false,Hobbie1=false,Hobbie2=false,Hobbie3=false,Hobbie4=false,Sexoerror=true;                                                                       //if true is Male, if it is False is Female



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login=(EditText)findViewById(R.id.Login);
        Password=(EditText)findViewById(R.id.Password);
        Password1=(EditText)findViewById(R.id.Password1);
        Correo=(EditText)findViewById(R.id.Correo);
        Send=(Button)findViewById(R.id.Enviar);
        eDate=(EditText) findViewById(R.id.eDate);
        tSexo=(TextView)findViewById(R.id.textViewSexo);
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        Ciudades=(Spinner)findViewById(R.id.Ciudades_spinner);
        //tDate=(TextView)findViewById(R.id.tDate);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Cities_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        Ciudades.setAdapter(adapter);

        oyenteselector = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                year=i;
                month=i1+1;
                day=i2;
                ShowDate();

            }
        };




        Send.setOnClickListener(new View.OnClickListener(){
            public void onClick(View View){
                if(!Validation())
                    PrintResults();
                }
        });




    }

    protected Dialog onCreateDialog(int id){
        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteselector,year,month,day);

        }
        return null;
    }


    public void showDatePickerDialog(View view) {
        showDialog(TipoDialogo);
    }

    public void ShowDate(){
        eDate.setText(day+"/"+month+"/"+year);
    }

    public void PrintResults(){
        Hobbies();
        if(Hombre)
            Sexo="Hombre";
        else
            Sexo="Mujer";

        Result=(TextView)findViewById(R.id.Resultados);
        Result.setVisibility(android.view.View.VISIBLE);

        Result.setText("Login: "+login+"\nContraseña: "+password+"\nCorreo: "+Email+"\nSexo: "+Sexo+"\nFecha Nacimiento: "+day+"/"+month+"/"+year+"\nCiudad: "+Ciudad+"\nHobbies: "+hobbies);
    }

    public boolean Validation() {
        login = Login.getText().toString();
        Email = Correo.getText().toString();
        password = Password.getText().toString();
        password1 = Password1.getText().toString();
        Fecha = eDate.getText().toString();
        Ciudad=Ciudades.getSelectedItem().toString();
        if (TextUtils.isEmpty(login)) {
            Login.setError("Digite Este Campo");
            return true;
        } else if (TextUtils.isEmpty(password)) {
            Password.setError("Digite Este Campo");
            return true;
        } else if (TextUtils.isEmpty(password1)) {
            Password1.setError("Digite Este Campo");
            return true;
        } else if (TextUtils.isEmpty(Email)) {
            Correo.setError("Digite Este Campo");
            return true;
        } else if (!password.equals(password1)) {
            Password1.setError("Contraseñas No Son Iguales");
            return true;
        } else if (Sexoerror) {
            tSexo.setError("Seleccione un Sexo");
            return true;
        }else if (TextUtils.isEmpty(Fecha)) {
            eDate.setError("Digite Este Campo");
            return true;
        }else if (Ciudad.equals("Selecciona Tu Ciudad")) {
            setSpinnerError(Ciudades, "Digite Este Campo");
            return true;
        }
        return false;
    }

    static public void setSpinnerError(Spinner spinner, String error){
        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            selectedTextView.setError(error);
        }
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Male:
                if (checked){
                    Hombre=true;
                    Sexoerror=false;
                }

                break;
            case R.id.Female:
                if (checked){
                    Hombre=false;
                    Sexoerror=false;
                }

                break;
            case R.id.Hobbie1:
                if (checked){
                    Hobbie1=true;
                }else
                    Hobbie1=false;


                break;
            case R.id.Hobbie2:
                if (checked){
                    Hobbie2=true;
                }else
                    Hobbie2=false;

                break;
            case R.id.Hobbie3:
                if (checked){
                    Hobbie3=true;
                }else
                    Hobbie3=false;

                break;
            case R.id.Hobbie4:
                if (checked){
                    Hobbie4=true;
                }else
                    Hobbie4=false;
                break;

            default:
                break;

        }
    }
    public void Hobbies (){
        if(Hobbie1){
            if(Hobbie2 && Hobbie3 && Hobbie4) {
                hobbies = "Hobbie1, " + "Hobbie2, " + "Hobbie3, " + "Hobbie4";
            }else if(Hobbie2 && Hobbie3){
                hobbies = "Hobbie1, " + "Hobbie2, " + "Hobbie3 ";
            }else if(Hobbie3 && Hobbie4){
                hobbies = "Hobbie1, " + "Hobbie3, " + "Hobbie4";
            }else if(Hobbie2 && Hobbie4){
                hobbies = "Hobbie1, " + "Hobbie2, " + "Hobbie4";
            } else if(Hobbie2){
                hobbies = "Hobbie1, " + "Hobbie2 ";
            }else if(Hobbie3){
                hobbies = "Hobbie1, " + "Hobbie3 ";
            }else if(Hobbie4){
                hobbies = "Hobbie1, " + "Hobbie4 ";
            }else
                hobbies = "Hobbie1";
        }else if(Hobbie2){
            if(Hobbie3 && Hobbie4){
                hobbies = "Hobbie2, " + "Hobbie3, " + "Hobbie4";
            }else if(Hobbie3){
                hobbies = "Hobbie2, " + "Hobbie3 ";
            }else if(Hobbie4){
                hobbies = "Hobbie2, " + "Hobbie4";
            }else
                hobbies="Hobbie2";
        }else if(Hobbie3){
            if(Hobbie4){
                hobbies = "Hobbie3, " + "Hobbie4";
            }else
                hobbies="Hobbie3";
        }else if(Hobbie4){
            hobbies="Hobbie4";
        }
    }
}
