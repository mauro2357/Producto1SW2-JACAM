package com.example.mauricio.eastsites;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.validation.Validator;


public class RegistroActivity extends ActionBarActivity {
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean isOnline(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }else{
            return false;
        }
    }
    public void crearMensaje(String mensaje){
        new AlertDialog.Builder(RegistroActivity.this)
                .setTitle("ALERTA")
                .setMessage(mensaje)
                .setCancelable(false).setIcon(R.drawable.wifi)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // whatever...
                    }
                }).create().show();
    }
    public void accionRegistrar(View view){
        Registrar registrar = new Registrar();
        registrar.execute();
    }
    private class Registrar extends AsyncTask<String, String, String> {
        String strFileContents=null;
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etClave1 = (EditText) findViewById(R.id.etClave1);
        EditText etClave2 = (EditText) findViewById(R.id.etClave2);
        EditText etNombre  = (EditText) findViewById(R.id.etNombre);
        Spinner spTipo = (Spinner) findViewById(R.id.spinnerTipos);
        String email = etEmail.getText().toString();
        String clave1 = etClave1.getText().toString();
        String clave2 = etClave2.getText().toString();
        String nombre = etNombre.getText().toString();
        String tipo = spTipo.getSelectedItem().toString();
        public String getEmail() {
            return email;
        }
        @Override
        protected void onPreExecute() {
            if(isOnline()) {
                super.onPreExecute();
                pDialog = new ProgressDialog(RegistroActivity.this);
                pDialog.setMessage("Cargando");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                //pDialog.show();
            }

        }
        @Override
        protected String doInBackground(String... params) {

            InputStream in = null;
            if(!isOnline()){
                return null;
            }else {
                if (email.length() == 0 || clave1.length() == 0|| clave2.length() == 0|| nombre.length() == 0 ) {
                    return strFileContents;
                } else {
                    try {
                        //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaLugarCoordenadas/" + email+"/"+clave1+"/"+nombre+"/"+tipo);
                        URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/GestionPersona/registrar/" + email+"/"+clave1+"/"+nombre+"/"+tipo);
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        in = new BufferedInputStream(urlConnection.getInputStream());
                        byte[] contents = new byte[1024];
                        int bytesRead = 0;
                        while ((bytesRead = in.read(contents)) != -1) {
                            strFileContents = new String(contents, 0, bytesRead);
                        }
                        return strFileContents;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return e.getMessage();
                    }
                }
            }

        }
        protected void onPostExecute(String result) {
            //Toast.makeText(getApplicationContext(), "result="+result, Toast.LENGTH_SHORT).show();
            if (!isOnline()) {
                crearMensaje("Vaya a la Configuración del equipo y active su conexión a Internet");
            }else{
                if(result==null){
                    crearMensaje("Debe Ingresar Todos Los Datos o LAS CONTRASEÑAS NO COINCIDEN");
                }else {
                    if (Integer.parseInt(result) == 0) {
                        Toast.makeText(getApplicationContext(), "Ya está Registrado", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(result) == 2) {
                        pDialog.show();
                        Intent i = new Intent(getApplicationContext(), MapsActivityPropietario.class);
                        i.putExtra("email", email);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }else if(Integer.parseInt(result)==1) {
                        pDialog.show();
                        Intent i = new Intent(getApplicationContext(), MapsActivityUsuarios.class);
                        i.putExtra("email", email);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                }
            }
        }
    }
}
