package pe.edu.tecsup.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public EditText pantalla;
    public double operador1, operador2, resultado;
    int operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalla=(EditText)findViewById(R.id.caja);
    }

    public void btn1 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"1";
        pantalla.setText(valor);
    }

    public void btn2 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"2";
        pantalla.setText(valor);
    }

    public void btn3 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"3";
        pantalla.setText(valor);
    }

    public void btn4 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"4";
        pantalla.setText(valor);
    }

    public void btn5 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"5";
        pantalla.setText(valor);
    }

    public void btn6 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"6";
        pantalla.setText(valor);
    }

    public void btn7 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"7";
        pantalla.setText(valor);
    }

    public void btn8 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"8";
        pantalla.setText(valor);
    }

    public void btn9 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"9";
        pantalla.setText(valor);
    }

    public void btn0 (View v){
        String valor=pantalla.getText().toString();
        valor=valor+"0";
        pantalla.setText(valor);
    }

    public void btnPunto (View v){
        String valor;
        if (pantalla.getText().toString().contains(".") ) { valor = ""; }else {
            valor=pantalla.getText().toString();
            valor=valor+".";
            pantalla.setText(valor);
        }
    }

    public void suma (View v){
        try {
            String proceso=pantalla.getText().toString();
            operador1=Double.parseDouble(proceso);

        } catch (NumberFormatException nfe){}
        pantalla.setText("");
        operacion=1;
    }

    public void resta (View v){
        try {
            String proceso=pantalla.getText().toString();
            operador1=Double.parseDouble(proceso);

        } catch (NumberFormatException nfe){}
        pantalla.setText("");
        operacion=2;
    }

    public void multiplicacion (View v){
        try {
            String proceso=pantalla.getText().toString();
            operador1=Double.parseDouble(proceso);

        } catch (NumberFormatException nfe){}
        pantalla.setText("");
        operacion=3;
    }

    public void division (View v){
        try {
            String proceso=pantalla.getText().toString();
            operador1=Double.parseDouble(proceso);

        } catch (NumberFormatException nfe){}
        pantalla.setText("");
        operacion=4;
    }

    public void btnIgual(View v){
        try {
            String proceso2=pantalla.getText().toString();
            operador2=Double.parseDouble(proceso2);
        }catch (NumberFormatException nfe){}
        pantalla.setText("");

        if (operacion==1) {
            resultado = operador1 + operador2;
        }else if(operacion==2){
            resultado=operador1-operador2;
        }else if(operacion==3) {
            resultado = operador1 * operador2;
        }else if(operacion==4) {
            if(operador2==0){
                pantalla.setText("Error");
            }else {
                resultado = operador1 / operador2;
            }
        }
        pantalla.setText(""+resultado);
        operador1=resultado;
    }

    public void btnBorrarTodo(View v){
        pantalla.setText("");
        operador1=0.0;
        operador2=0.0;
        resultado=0.0;
    }

    public void btnBorrarUno(View v){
        if (!pantalla.getText().toString().equals("")){
            pantalla.setText(pantalla.getText().subSequence(0,pantalla.getText().length()-1)+"");
        }
    }




}
