package ejercicio00.repairtodayclientes;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenemos el telefono del emulador para luego enviar el sms
        TelephonyManager tm=(TelephonyManager)this.getSystemService(TELEPHONY_SERVICE);
        System.out.println(tm.getLine1Number()+"******************");
    }
    public void buscarP (View v)
    {
        this.startActivity(new Intent(this, ProfActivity.class));
    }
    public void puntuaciones (View v)
    {
        this.startActivity(new Intent(this, BuscarProfActivity.class));
    }

}
