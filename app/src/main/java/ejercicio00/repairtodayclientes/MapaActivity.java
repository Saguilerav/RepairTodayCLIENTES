package ejercicio00.repairtodayclientes;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javabeans.Coordenadas;
import javabeans.Datos;
import javabeans.DirTel;

public class MapaActivity extends AppCompatActivity {
    GoogleMap gm;
    String datprof;
    Marker k;
    ArrayList <Datos> resultado;
    ArrayList<Coordenadas> latlon=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        Intent intent=this.getIntent();
        //recuperamos el dato enviado por la actividad BuscarActivity
        resultado=(ArrayList<Datos>)intent.getSerializableExtra("DatosProf");
        //obtenemos una referencia al fragmento que contiene el mapa
        FragmentManager fm=this.getSupportFragmentManager();
        SupportMapFragment smf=(SupportMapFragment)fm.findFragmentById(R.id.mapa);

        if (resultado.size()==0)
        {
            Toast.makeText(MapaActivity.this,"No hay profesionales cerca",Toast.LENGTH_LONG).show();
            System.out.println("el array esta vacio");
            MapaActivity.this.finish();

        }
        else
        {
            System.out.println("el array se ha recibido!!!!!");
            try {
                Geocoder dir = new Geocoder(this, new Locale("ES"));


                for(Datos p:resultado)
                {
                    List<Address> direcciones = dir.getFromLocationName(p.getDireccion() ,1);
                    Address midireccion=direcciones.get(0);
                    Coordenadas c=new Coordenadas(midireccion.getLatitude(),midireccion.getLongitude(),p.getDni(),
                            p.getNombre(),p.getDireccion(),p.getServicio(),p.getEmail(),p.getCp(),p.getTelefono(),p.getOpcion());
                    latlon.add(c);
                }


                smf.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        gm=googleMap;
                        //tipo de mapa
                        gm.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        //habilitar controles
                        gm.getUiSettings().setZoomControlsEnabled(true);
                        //habilitar barra de herramientas
                        gm.getUiSettings().setMapToolbarEnabled(true);
                        //habilitar la localizacion
                        gm.getUiSettings().setMyLocationButtonEnabled(true);
                        //posicionar en una determinada localización
                        for(Coordenadas c:latlon) {

                            LatLng pos = new LatLng(c.getLatitud(), c.getLongitud());
                            gm.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,14));
                            //añadir un marcador
                            MarkerOptions mk=new MarkerOptions();
                            mk.position(pos);
                            mk.title(c.getTelefono());

                            gm.addMarker(mk);
                        }


                        //respuesta a evento click en el marcador
                        gm.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                k=marker;
                                AlertDialog.Builder adb= new AlertDialog.Builder(MapaActivity.this);
                                adb.setTitle("");
                                adb.setMessage("¿Desea enviar un SMS al profesional seleccionado?");
                                adb.setCancelable(false);
                                adb.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        datprof=k.getTitle();
                                        Intent intent=new Intent(MapaActivity.this,MandarSMSActivity.class);
                                        intent.putExtra("Telefono", datprof);
                                        MapaActivity.this.startActivity(intent);
                                    }
                                });
                                        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog ad=adb.create();

                                ad.show();


                                return false;
                            }
                        });

                    }
                });
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }



    }
}
