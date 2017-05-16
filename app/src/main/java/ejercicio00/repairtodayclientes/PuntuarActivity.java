package ejercicio00.repairtodayclientes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javabeans.Datos;
import modelo.GestionDatosC;

public class PuntuarActivity extends AppCompatActivity {
Datos d;
    EditText edtPuntuacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuar);
        Intent intent=this.getIntent();
        d=(Datos)intent.getSerializableExtra("datosP");

        System.out.println("He recibido todo el intent: "+d.getNombre());

    }
    public void altaPuntuacion (View v)
    {
        edtPuntuacion=(EditText)this.findViewById(R.id.edtPuntuar);
        String puntos=edtPuntuacion.getText().toString();
        Comunicacion com=new Comunicacion();
        com.execute(d.getDni(),puntos);


    }


    class Comunicacion extends AsyncTask<String,Void, Void> {


        @Override
        protected Void doInBackground(String... params) {
            GestionDatosC gbusquedas = new GestionDatosC();
            gbusquedas.altaPuntuacion(params[0],params[1]);
            return null;

        }
    }
}
