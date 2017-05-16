package ejercicio00.repairtodayclientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import javabeans.Datos;
import modelo.GestionDatosC;

public class MostrarActivity extends AppCompatActivity {
    TextView tv;
   Datos profesional=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        Intent intent = this.getIntent();
        profesional=((Datos)intent.getSerializableExtra("profesional"));


        String s= "Nombre: "+profesional.getNombre().toString()+"\n"+"Servicio: "+profesional.getServicio().toString()+
                "\n"+"Dirección: "+profesional.getDireccion().toString()+"\n"+"Email: "+profesional.getEmail().toString()+"\n"+"Teléfono: "+profesional.getTelefono().toString();
        tv=(TextView)this.findViewById(R.id.textView5);
        tv.setText(s);

    }




    public void puntuar (View v)
    {
        Intent intent2=new Intent(MostrarActivity.this,PuntuarActivity.class);
        intent2.putExtra("datosP",profesional);
        this.startActivity(intent2);
    }
    }

