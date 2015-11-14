package com.example.mauricio.eastsites;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MapsActivityPropietario extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static final LatLng orienteAntioqueño = new LatLng(6.203070,-75.512113);
    private   LatLng lugar = null;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] busquedas;
    private String[] vistas;
    private ActionBarDrawerToggle drawerListener;
    private RelativeLayout rlAgregarLugar;
    private RelativeLayout rlLugaresPropietario;
    private RelativeLayout rlConsultaNombre;
    private Spinner spinnerVistas;

    private ListView listaLugaresPropietario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_activity_propietario);
        setUpMapIfNeeded();
        Toast.makeText(getApplicationContext(), "Bienvenido "+getIntent().getStringExtra("email"), Toast.LENGTH_SHORT).show();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orienteAntioqueño, 5));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(9), 200, null);
        rlConsultaNombre = (RelativeLayout)findViewById(R.id.rlConsultaNombrePropietario);
        rlConsultaNombre.setVisibility(View.INVISIBLE);
        rlLugaresPropietario = (RelativeLayout) findViewById(R.id.rlLugaresPropietario);
        rlLugaresPropietario.setVisibility(View.INVISIBLE);
        rlAgregarLugar = (RelativeLayout) findViewById(R.id.rlAgregarLugar);
        rlAgregarLugar.setVisibility(View.INVISIBLE);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        listView=(ListView) findViewById(R.id.drawerList);
        busquedas = getResources().getStringArray(R.array.busquedasPropietario);
        vistas = getResources().getStringArray(R.array.Vistas);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, busquedas));
        drawerListener=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }
        };
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinnerVistas = (Spinner) findViewById(R.id.spinnerVistas);
        spinnerVistas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vistas[position].equalsIgnoreCase("Satélite")){
                    mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
                }
                if(vistas[position].equalsIgnoreCase("Híbrido")){
                    mMap.setMapType(mMap.MAP_TYPE_HYBRID);
                }
                if(vistas[position].equalsIgnoreCase("Terreno")){
                    mMap.setMapType(mMap.MAP_TYPE_TERRAIN);
                }
                if(vistas[position].equalsIgnoreCase("Normal")){
                    mMap.setMapType(mMap.MAP_TYPE_NORMAL);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // update TextView here!
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
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
    @Override
    public void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(drawerListener.onOptionsItemSelected(menuItem)){
            return  true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
    @Override
    public void onConfigurationChanged(Configuration configuration){
        super.onConfigurationChanged(configuration);
        drawerListener.onConfigurationChanged(configuration);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,busquedas[position]+ position,Toast.LENGTH_LONG).show();
        selectItem(position);
        drawerLayout.closeDrawers();
        if(busquedas[position].equalsIgnoreCase("Agregar Lugar")){
            rlAgregarLugar.setVisibility(View.VISIBLE);
            rlLugaresPropietario.setVisibility(View.INVISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            spinnerVistas.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Consultar Lugares Por Nombre")){
            rlConsultaNombre.setVisibility(View.VISIBLE);
            rlAgregarLugar.setVisibility(View.INVISIBLE);
            rlLugaresPropietario.setVisibility(View.INVISIBLE);
            spinnerVistas.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Consultar Mis Lugares")){
            rlLugaresPropietario.setVisibility(View.VISIBLE);
            rlAgregarLugar.setVisibility(View.INVISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            spinnerVistas.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Cerrar Sesión")){
            Intent i = new Intent(this,LogInActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        if(busquedas[position].equalsIgnoreCase("Acerca de")){
            Intent i = new Intent(this,AcercaDe.class);
            startActivity(i);
        }
    }
    private void selectItem(int position) {
        listView.setItemChecked(position,true);
        setTitle(busquedas[position]);
    }
    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
        }
    }
    public void crearMensaje(String titulo,String mensaje){
        new AlertDialog.Builder(MapsActivityPropietario.this)
                .setTitle(titulo)
                .setMessage(mensaje)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // whatever...
                    }
                }).create().show();
    }
    public void accionAgregarLugar(View view){
        AgregarLugar agregarLugar = new AgregarLugar();
        agregarLugar.execute();
    }
    public void accionLugaresPropietario(View view){
        LugaresPropietario lugaresPropietario = new LugaresPropietario();
        lugaresPropietario.execute();
    }
    public void accionNombre(View view){
        LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
        lugaresPorNombre.execute();
    }
    private class LugaresPorNombre extends AsyncTask<String, String, String> {
        String strFileContents=null;
        EditText etNombre = (EditText) findViewById(R.id.etConsultaNombre);
        String nombre = etNombre.getText().toString();
        String[] vector_nombre = nombre.split(" ");
        String nombrej = vector_nombre[0];
        private void setEt(String nombre){
            etNombre.setText(nombre);
        }
        @Override
        protected String doInBackground(String... params) {
            if(vector_nombre.length>1) {
                for (int i = 1; i < vector_nombre.length; i++) {
                    if (vector_nombre.length > 1) {
                        nombrej = nombrej+"%20"+vector_nombre[i].toString();
                    }
                }
            }
            InputStream in = null;
            if(!isOnline()){
                return null;
            }else {
                if (nombre.length() == 0) {
                    return strFileContents;
                } else {
                    try {
                        ///URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaLugarNombre/" + nombre);
                        URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultaLugarNombre/"+getIntent().getStringExtra("email")+"/" + nombrej);
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        in = new BufferedInputStream(urlConnection.getInputStream());
                        byte[] contents = new byte[1024];
                        int bytesRead = 0;
                        while ((bytesRead = in.read(contents)) != -1) {
                            strFileContents = new String(contents, 0, bytesRead);
                        }
                        return strFileContents;
                    } catch (Exception e) {
                        return e.getMessage();
                    }
                }
            }
        }

        protected void onPostExecute(String result) {
            //Toast.makeText(getApplicationContext(), "r="+result, Toast.LENGTH_SHORT).show();
            if(!isOnline()){
                Toast.makeText(getApplicationContext(), "Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();
            }else {
                if (result == null) {
                    Toast.makeText(getApplicationContext(), "ALERTA!!! Debe Ingresar un Nombre", Toast.LENGTH_SHORT).show();
                } else {
                    if (result.equalsIgnoreCase("[]")) {
                        Toast.makeText(getApplicationContext(), "El Lugar " + nombre + " no se encuentra, Intente Nuevamente", Toast.LENGTH_SHORT).show();
                    } else {
                        String[] vectorCoordenadas = result.split(",");
                        double latitud = Double.parseDouble(vectorCoordenadas[0].toString());
                        double longitud = Double.parseDouble(vectorCoordenadas[1].toString());
                        String descripcion = vectorCoordenadas[2].toString();
                        String categoria = vectorCoordenadas[3].toString();
                        String telefono = vectorCoordenadas[4].toString();
                        lugar = new LatLng(latitud, longitud);
                        mMap.addMarker(new MarkerOptions().position(lugar).title(nombre+"("+categoria+")")).setSnippet("Descripción="+descripcion+"\nTelefono="+telefono);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, 18));
                        mMap.animateCamera(CameraUpdateFactory.zoomIn());
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                        //rlConsultaNombre.setVisibility(View.INVISIBLE);
                    }
                }
            }

        }
    }
    private class LugaresPropietario extends AsyncTask<String, String, String> {
        String strFileContents=null;
        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;
            // HTTP Get
            if(!isOnline()){
                return null;
            }else {
                try {
                    //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaTodosLugares");
                    URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultaLugaresPropietario/"+getIntent().getStringExtra("email"));
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
                    //e.printStackTrace();
                    return e.getMessage();
                }
            }
        }
        protected void onPostExecute(String result) {

            if (!isOnline()) {
                Toast.makeText(getApplicationContext(), "Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();
            } else {
                if(result.equalsIgnoreCase("[]")){
                    crearMensaje("SIN LUGARES","No Se Encuentran Lugares Asociados a Tu Cuenta");
                }else {
                    String[] vectorCoordenadas = result.split("/");
                    listaLugaresPropietario = (ListView) findViewById(R.id.listaLugaresPropietario);
                    final ArrayList<String> lugares = new ArrayList<>();
                    for (int i = 0; i < vectorCoordenadas.length; i++) {
                        lugares.add(vectorCoordenadas[i]);
                    }
                    listaLugaresPropietario.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lugares));
                    listaLugaresPropietario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String[] lugar = lugares.get(position).split(",");
                            String nombre = lugar[0];
                            Toast.makeText(getApplicationContext(), nombre, Toast.LENGTH_SHORT).show();
                            LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
                            lugaresPorNombre.setEt(nombre);
                            accionNombre(view);
                            listaLugaresPropietario.setVisibility(View.INVISIBLE);
                            lugaresPorNombre.setEt("");
                        }
                    });
                    listaLugaresPropietario.setVisibility(View.VISIBLE);
                }
            }
        }
    }
   private class AgregarLugar extends AsyncTask<String, String, String> {
       Spinner spinnerCategorias = (Spinner) findViewById(R.id.spinnerCat);
        String strFileContents=null;
       EditText etNombre = (EditText) findViewById(R.id.etNombre);
       String nombre = etNombre.getText().toString();
       EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
       String telefono = etTelefono.getText().toString();
       EditText etLatitud =(EditText) findViewById(R.id.etLatitud);
       String latitud = etLatitud.getText().toString();
       EditText etLongitud = (EditText) findViewById(R.id.etLongitud);
       String longitud = etLongitud.getText().toString();
       EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);
       String descripcion = etDescripcion.getText().toString();
       String[] sel = spinnerCategorias.getSelectedItem().toString().split("-");
       String categoria = sel[0];
        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;

            if(!isOnline()){
                return null;
            }else {
                if (nombre.length()==0 || telefono.length()==0 ||latitud.length()==0 ||longitud.length()==0 ||categoria.length()==0 ||descripcion.length()==0 ) {
                    return strFileContents;
                } else {
                    try {
                        //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/GestionLugares/registrarLugar/" + nombre + "/" + telefono+"/" + latitud+"/" + longitud+"/"+   getIntent().getStringExtra("email")+"/" + categoria+"/" + descripcion);
                        URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/GestionLugares/registrarLugar/" + nombre + "/" + telefono+"/" + latitud+"/" + longitud+"/"+   getIntent().getStringExtra("email")+"/" + categoria+"/" + descripcion);
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
            if(!isOnline()){
                Toast.makeText(getApplicationContext(), "Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();
            }else {
                if (result == null) {
                    Toast.makeText(getApplicationContext(), "ALERTA!!! Debe Ingresar Todos Los Valores para proceder", Toast.LENGTH_SHORT).show();
                } else {

                    if (Integer.parseInt(result)==0) {
                        crearMensaje("ALERTA","No se pudo registrar el lugar,posiblemente ya se encuentren estas mismas coordenadas en el sistema");
                        //Toast.makeText(getApplicationContext(), "No se pudo registrar el lugar", Toast.LENGTH_SHORT).show();
                    } else if(Integer.parseInt(result)==1){
                        crearMensaje("EXCELENTE","El lugar se registro satisfactoriamente");
                        rlAgregarLugar.setVisibility(View.INVISIBLE);
                        etNombre.setText("");
                        etTelefono.setText("");
                        etLatitud.setText("");
                        etLongitud.setText("");
                        etDescripcion.setText("");
                        //Toast.makeText(getApplicationContext(), "El lugar se registro correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
