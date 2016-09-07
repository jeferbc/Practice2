package bernalcom.jeffe.practice2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double Area;
    Boolean Triangulo=false,Cuadro=false,Rectangulo=false,Circulo=false;
    TextView Text;
    EditText Base,Altura;
    Button send;
    public final double pi=3.1416;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=(Button)findViewById(R.id.Calcular);
        Text=(TextView)findViewById(R.id.Print);
        Base=(EditText)findViewById(R.id.Base);
        Altura=(EditText)findViewById(R.id.Altura);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Cuadro==true){
                    String BaseC=Base.getText().toString();
                    if(TextUtils.isEmpty(BaseC))
                        Base.setError("Digite Base");
                    else{
                        Area=Integer.parseInt(BaseC)*Integer.parseInt(BaseC);
                        Text.setVisibility(View.VISIBLE);
                        Text.setText(String.valueOf(Area));
                    }


                }else if(Triangulo==true){
                    String BaseC=Base.getText().toString();
                    String AlturaC=Altura.getText().toString();
                    if(TextUtils.isEmpty(BaseC)) {
                        Base.setError("Digite Base");
                    }else if(TextUtils.isEmpty(AlturaC)){
                        Altura.setError("Digite Altura");
                    }else{
                        Area=Integer.parseInt(BaseC)*Integer.parseInt(AlturaC)/2;
                        Text.setVisibility(View.VISIBLE);
                        Text.setText(String.valueOf(Area));}

                }else if(Rectangulo==true){

                        String BaseC=Base.getText().toString();
                        String AlturaC=Altura.getText().toString();
                        if(TextUtils.isEmpty(BaseC)) {
                            Base.setError("Digite Base");
                        }else if(TextUtils.isEmpty(AlturaC)){
                            Altura.setError("Digite Altura");
                        }else{
                            Area=Integer.parseInt(BaseC)*Integer.parseInt(AlturaC);
                            Text.setVisibility(View.VISIBLE);
                            Text.setText(String.valueOf(Area));}

                }else if(Circulo==true){

                            String BaseC=Base.getText().toString();

                            if(TextUtils.isEmpty(BaseC)) {
                                Base.setError("Digite Radio");
                            }else{
                                Area=Integer.parseInt(BaseC)*Integer.parseInt(BaseC)*pi;
                                Text.setVisibility(View.VISIBLE);
                                Text.setText(String.valueOf(Area));}


                }

            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Cuadro:
                if (checked){                                   //comes visible the Edit Text of Base and the button send
                    int lenght=Base.getText().length();
                    if(lenght>0){
                        Base.getText().delete(lenght-1,lenght);
                    }
                    Altura.setVisibility(View.INVISIBLE);
                    Base.setVisibility(View.VISIBLE);
                    Base.setHint(R.string.Base);
                    send.setVisibility(View.VISIBLE);
                    Cuadro=true;
                    Triangulo=false;
                    Circulo=false;
                    Rectangulo=false;

                }

                    break;
            case R.id.Triangulo:
                if (checked){                                   //comes visible the both Edit Text of Base and Altura and the button send
                    int lenght=Base.getText().length();
                    if(lenght>0){
                        Base.getText().delete(lenght-1,lenght);
                    }
                    lenght=Altura.getText().length();
                    if(lenght>0){
                        Altura.getText().delete(lenght-1,lenght);
                    }
                    Base.setVisibility(View.VISIBLE);
                    Base.setHint(R.string.Base);
                    Altura.setVisibility(View.VISIBLE);
                    Altura.setHint(R.string.Altura);
                    send.setVisibility(View.VISIBLE);
                    Cuadro=false;
                    Triangulo=true;
                    Circulo=false;
                    Rectangulo=false;
                }

                    break;

            case R.id.Rectangulo:
                if (checked){
                    int lenght=Base.getText().length();
                    if(lenght>0){
                        Base.getText().delete(lenght-1,lenght);
                    }
                    lenght=Altura.getText().length();
                    if(lenght>0){
                        Altura.getText().delete(lenght-1,lenght);
                    }
                    Base.setVisibility(View.VISIBLE);
                    Base.setHint(R.string.Base);
                    Altura.setHint(R.string.Altura);
                    Altura.setVisibility(View.VISIBLE);
                    send.setVisibility(View.VISIBLE);
                    Rectangulo=true;
                    Cuadro=false;
                    Triangulo=false;
                    Circulo=false;
                }

                    break;
            case R.id.Circulo:
                if (checked) {
                    int lenght=Base.getText().length();
                    if(lenght>0){
                        Base.getText().delete(lenght-1,lenght);
                    }
                    Altura.setVisibility(View.INVISIBLE);
                    Base.setVisibility(View.VISIBLE);
                    Base.setHint(R.string.Radio);
                    send.setVisibility(View.VISIBLE);

                    Circulo=true;
                    Cuadro=false;
                    Triangulo=false;
                    Rectangulo=false;
                }
                    break;
            default:
                break;

        }
    }

}
