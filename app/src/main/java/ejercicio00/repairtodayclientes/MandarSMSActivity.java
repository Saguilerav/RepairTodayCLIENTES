package ejercicio00.repairtodayclientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MandarSMSActivity extends AppCompatActivity {
    String tel;
    EditText edtSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandar_sms);
        Intent intent=this.getIntent();
        //recuperamos el dato enviado por la actividad BuscarActivity
        tel=(String)intent.getSerializableExtra("Telefono");
            }
    public void enviar (View v)
    {
        edtSMS=(EditText)this.findViewById(R.id.edtMen);
        SmsManager manager=SmsManager.getDefault();
        manager.sendTextMessage(tel,null,edtSMS.getText().toString(),null,null);
        Toast.makeText(MandarSMSActivity.this,"El mensaje se ha enviado correctamente",Toast.LENGTH_LONG).show();
        MandarSMSActivity.this.startActivity(new Intent(MandarSMSActivity.this, MainActivity.class));

    }
}
