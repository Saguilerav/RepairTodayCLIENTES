package ejercicio00.repairtodayclientes;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javabeans.Datos;
import modelo.GestionDatosC;

public class BuscarProfActivity extends AppCompatActivity {
    EditText edtEmail;
    EditText edtTelefono;
    String email = null;
    String telefono = "";
    Datos p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_prof);
    }

    public void buscar(View v) {
        edtEmail = (EditText) this.findViewById(R.id.edtEmail);
        edtTelefono = (EditText) this.findViewById(R.id.edtTelefono);
        Comunicacion cm = new Comunicacion(BuscarProfActivity.this);
        cm.execute(edtEmail.getText().toString() , edtTelefono.getText().toString());
        System.out.println(email+","+telefono);

    }


    class Comunicacion extends AsyncTask<String, Void, Datos> {
        public Context ctx;

        public Comunicacion(Context ctx) {
            this.ctx = ctx;
        }


        @Override
        protected void onPostExecute(Datos d) {
            Intent intent = new Intent(ctx, MostrarActivity.class);
            intent.putExtra("profesional", d);
            ctx.startActivity(intent);

        }

        @Override
        protected Datos doInBackground(String... params) {
            GestionDatosC gbusquedas = new GestionDatosC();
                if(params[0].length()<2) {
                    return gbusquedas.recuperarPorTel(params[1]);
                }
                else {
                    return gbusquedas.recuperarPorEmail(params[0]);
                }

        }
    }
}
