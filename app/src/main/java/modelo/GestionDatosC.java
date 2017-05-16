package modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import javabeans.Datos;

/**
 * Created by USUARIO on 28/04/2017.
 */

public class GestionDatosC {
    Socket sc;

    public ArrayList<Datos> recuperarDatosC(String cp, String servicio) {
        ArrayList<Datos> todos=new ArrayList<>();
        try {
            JSONObject job = new JSONObject();
            job.put("cp", cp);
            job.put("servicio",servicio);
            job.put("opcion","2");
            sc = new Socket("192.168.0.117", 9000);
            PrintStream salida = new PrintStream(sc.getOutputStream(),true,"UTF-8");
            BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //enviamos objeto al servidor
            salida.println(job.toString());
            System.out.println("codigo postal: "+cp);
            System.out.println("servicio: "+servicio);
            //recogemos el array JSON con los datos de todas las personas
            JSONArray jarray=new JSONArray(bf.readLine());
            System.out.println("ArrayJSON: "+jarray.toString());
            //y lo transformamos en un arraylist de objetos DatosPersona
            for(int i=0;i<jarray.length();i++){
                JSONObject aux=jarray.getJSONObject(i);
                Datos dt=new Datos(aux.getString("dni"),
                        aux.getString("nombre"),
                        aux.getString("direccion"),
                        aux.getString("servicio"),
                        aux.getString("email"),
                        aux.getString("cp"),
                        aux.getString("telefono"),"2");
                todos.add(dt);

            }
            sc.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return todos;

    }
    public ArrayList<Datos> recuperarDatos(String servicio) {
        ArrayList<Datos> todos=new ArrayList<>();
        try {
            JSONObject job = new JSONObject();
            job.put("servicio",servicio);
            job.put("opcion","2");
            sc = new Socket("192.168.0.117", 9000);
            PrintStream salida = new PrintStream(sc.getOutputStream(),true,"UTF-8");
            BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //enviamos objeto al servidor
            salida.println(job.toString());
            System.out.println("servicio: "+servicio);
            //recogemos el array JSON con los datos de todas las personas
            JSONArray jarray=new JSONArray(bf.readLine());
            System.out.println("ArrayJSON: "+jarray.toString());
            //y lo transformamos en un arraylist de objetos DatosPersona
            for(int i=0;i<jarray.length();i++){
                JSONObject aux=jarray.getJSONObject(i);
                Datos dt=new Datos(aux.getString("dni"),
                        aux.getString("nombre"),
                        aux.getString("direccion"),
                        aux.getString("servicio"),
                        aux.getString("email"),
                        aux.getString("cp"),
                        aux.getString("telefono"),"2");
                todos.add(dt);

            }
            sc.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return todos;

    }
    public double recuperarPunt(String dni){
        double punt=0;
        try{
            sc=new Socket("192.168.0.117",9000);
            JSONObject job = new JSONObject();
            job.put("dni",dni);
            job.put("opcion","6");
            PrintStream salida=new PrintStream(sc.getOutputStream());
            BufferedReader bf=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //enviamos objeto al servidor
            salida.println(job.toString());
            //recuperamos objeto con respuesta
            JSONObject jobRespuesta=new JSONObject(bf.readLine());
            punt= jobRespuesta.getDouble("puntuacion");
            //cierre del socket
            sc.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return punt;

    }

    public Datos recuperarPorEmail(String email){
        Datos todo=null;
        try{
            sc=new Socket("192.168.0.117",9000);
            JSONObject job = new JSONObject();
            job.put("email",email);
            job.put("opcion","3");
            PrintStream salida=new PrintStream(sc.getOutputStream());
            BufferedReader bf=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //enviamos objeto al servidor
            salida.println(job.toString());
            //recuperamos objeto con respuesta
            JSONObject jobRespuesta=new JSONObject(bf.readLine());
            todo=new Datos(jobRespuesta.getString("dni"),
                    jobRespuesta.getString("nombre"),jobRespuesta.getString("direccion"),
                    jobRespuesta.getString("servicio"),jobRespuesta.getString("email"),
                    jobRespuesta.getString("cp"),jobRespuesta.getString("telefono"),null);
            //cierre del socket
            sc.close();
            //String dni, String nombre, String direccion, String servicio, String email,
            //       String cp, String telefono,String opcion)
        }
        catch(IOException ex){
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return todo;

    }
    public Datos recuperarPorTel(String telefono){
        Datos todo=null;
        try{
            sc=new Socket("192.168.0.117",9000);
            JSONObject job = new JSONObject();
            job.put("telefono",telefono);
            job.put("opcion","4");
            PrintStream salida=new PrintStream(sc.getOutputStream());
            BufferedReader bf=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //enviamos objeto al servidor
            salida.println(job.toString());
            System.out.println("estoy enviando: "+telefono);
            //recuperamos objeto con respuesta
            JSONObject jobRespuesta=new JSONObject(bf.readLine());
            todo=new Datos(jobRespuesta.getString("dni"),
                    jobRespuesta.getString("nombre"),jobRespuesta.getString("direccion"),
                    jobRespuesta.getString("servicio"),jobRespuesta.getString("email"),
                    jobRespuesta.getString("cp"),jobRespuesta.getString("telefono"),null);
            //cierre del socket
            sc.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return todo;



    }

    public void altaPuntuacion(String dni,String puntuacion){
        try{
            sc=new Socket("192.168.0.117",9000);
            JSONObject job = new JSONObject();
            job.put("dni",dni);
            job.put("puntuacion",puntuacion);
            job.put("opcion","5");
            PrintStream salida=new PrintStream(sc.getOutputStream());
            BufferedReader bf=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //enviamos objeto al servidor
            salida.println(job.toString());
            //cierre del socket
            sc.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
