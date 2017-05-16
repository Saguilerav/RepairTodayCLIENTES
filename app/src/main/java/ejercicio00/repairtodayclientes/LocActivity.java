package ejercicio00.repairtodayclientes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import javabeans.Datos;
import modelo.GestionDatosC;

public class LocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);

    }

    public void cualquiera (View v)
    {
        Intent intent1=LocActivity.this.getIntent();
        String servicio = intent1.getStringExtra("servicio");
        TareaCom tc=new LocActivity.TareaCom();
        tc.execute(servicio);
        this.finish();
    }

    class TareaCom extends AsyncTask<String,Void,ArrayList<Datos>>
    {
        @Override
        protected void onPostExecute(ArrayList<Datos> datos) {
            Intent intent=new Intent(LocActivity.this,MapaActivity.class);
            intent.putExtra("DatosProf", datos);
            LocActivity.this.startActivity(intent);
        }

        @Override
        protected ArrayList<Datos> doInBackground(String... params) {
            ArrayList<Datos> dt;
            GestionDatosC gdatosC=new GestionDatosC();
            dt=gdatosC.recuperarDatos(params[0]);
            System.out.println(dt.size());
            return dt;
        }
    }

    public void cp(View v)
    {
        EditText edtBuscarCP=(EditText)this.findViewById(R.id.edtCPB);
        Intent intent1=LocActivity.this.getIntent();
        String servicio = intent1.getStringExtra("servicio");
        System.out.println(servicio);
        TareaCom3 tc3=new LocActivity.TareaCom3();
        tc3.execute(edtBuscarCP.getText().toString(),servicio);
        this.finish();

    }
    class TareaCom3 extends AsyncTask<String,Void,ArrayList<Datos>> {

        @Override
        protected void onPostExecute(ArrayList<Datos> datos) {
            Intent intent=new Intent(LocActivity.this,MapaActivity.class);
            intent.putExtra("DatosProf", datos);
            LocActivity.this.startActivity(intent);

        }

        @Override
        protected ArrayList<Datos> doInBackground(String... params) {
            String buscarCP=new String(params[0]);
            ArrayList<Datos> dt;
            //recuperamos el dato enviado por la actividad ProfActivity
            GestionDatosC gdatosC=new GestionDatosC();
            dt=gdatosC.recuperarDatosC(buscarCP, params[1]);
            System.out.println(dt.size());
            return dt;



        }


    }

}
