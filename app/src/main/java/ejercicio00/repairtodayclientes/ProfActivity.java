package ejercicio00.repairtodayclientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);
    }
    public void albañil (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="albañil";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void carpintero (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="carpintero";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void cerrajero (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="cerrajero";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void electricista (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="electricista";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void fontanero (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="fontanero";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void pintor (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="pintor";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void electrodomesticos (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="electrodomesticos";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
    public void climatizacion (View v)
    {
        Intent intent=new Intent(ProfActivity.this,LocActivity.class);
        String prof="climatizacion";
        intent.putExtra("servicio", prof);
        ProfActivity.this.startActivity(intent);
    }
}
