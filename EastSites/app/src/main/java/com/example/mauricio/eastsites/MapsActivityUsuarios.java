package com.example.mauricio.eastsites;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static android.R.layout;

public class MapsActivityUsuarios extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static final LatLng orienteAntioqueño = new LatLng(6.203070,-75.512113);
    private   LatLng lugar = null;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ListView listaTodosLugares;
    private ListView listaLugaresCategoria;
    private ListView listaLugaresFavoritos;
    private String[] busquedas;
    private String[] vistas;
    private ActionBarDrawerToggle drawerListener;
    private RelativeLayout rlConsultaCoordenadas;
    private RelativeLayout rlConsultaNombre;
    private  RelativeLayout rlConsultaTodosLugares;
    private RelativeLayout rlConsultaCategoria;
    private RelativeLayout rlAgregarFavorito;
    private RelativeLayout rlConsultaFavoritos;
    private Spinner spinnerVistas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        Toast.makeText(getApplicationContext(), "Bienvenido  "+getIntent().getStringExtra("email"), Toast.LENGTH_SHORT).show();
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orienteAntioqueño, 5));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(9), 200, null);
        rlConsultaFavoritos = (RelativeLayout)findViewById(R.id.rlConsultaFavoritos);
        rlConsultaFavoritos.setVisibility(View.INVISIBLE);
        rlAgregarFavorito=  (RelativeLayout)findViewById(R.id.rlAgregarFavorito);
        rlAgregarFavorito.setVisibility(View.INVISIBLE);
        rlConsultaCoordenadas = (RelativeLayout) findViewById(R.id.rlConsultaCoordenadas);
        rlConsultaNombre = (RelativeLayout)findViewById(R.id.rlConsultaNombre);
        rlConsultaTodosLugares = (RelativeLayout)findViewById(R.id.rlConsultaTodosLugares);
        rlConsultaCategoria = (RelativeLayout) findViewById(R.id.rlConsultaCategoria);
        rlConsultaCategoria.setVisibility(View.INVISIBLE);
        rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
        rlConsultaTodosLugares.setVisibility(View.INVISIBLE);
        rlConsultaNombre.setVisibility(View.INVISIBLE);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        listView=(ListView) findViewById(R.id.drawerList);
        busquedas = getResources().getStringArray(R.array.busquedasUsuario);
        vistas = getResources().getStringArray(R.array.Vistas);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new ArrayAdapter<>(this, layout.simple_list_item_1, busquedas));
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
        if(busquedas[position].equalsIgnoreCase("Por Coordenadas")){
            rlConsultaCoordenadas.setVisibility(View.VISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            rlConsultaTodosLugares.setVisibility(View.INVISIBLE);
            rlConsultaCategoria.setVisibility(View.INVISIBLE);
            rlConsultaFavoritos.setVisibility(View.INVISIBLE);
            rlAgregarFavorito.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Agregar Favorito")){
            rlAgregarFavorito.setVisibility(View.VISIBLE);
            rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            rlConsultaTodosLugares.setVisibility(View.INVISIBLE);
            rlConsultaFavoritos.setVisibility(View.INVISIBLE);
            rlConsultaCategoria.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Por Nombre")){
            rlConsultaNombre.setVisibility(View.VISIBLE);
            rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
            rlConsultaTodosLugares.setVisibility(View.INVISIBLE);
            rlConsultaCategoria.setVisibility(View.INVISIBLE);
            rlConsultaFavoritos.setVisibility(View.INVISIBLE);
        }if(busquedas[position].equalsIgnoreCase("Todos Los Lugares")){
            listaTodosLugares = (ListView)findViewById(R.id.listaTodosLugares);
            listaTodosLugares.setVisibility(View.INVISIBLE);
            rlConsultaTodosLugares.setVisibility(View.VISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            rlConsultaFavoritos.setVisibility(View.INVISIBLE);
            rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
            rlConsultaCategoria.setVisibility(View.INVISIBLE);
            rlAgregarFavorito.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Consultar Mis Favoritos")){
            listaLugaresFavoritos = (ListView)findViewById(R.id.listaFavoritos);
            listaLugaresFavoritos.setVisibility(View.INVISIBLE);
            rlConsultaFavoritos.setVisibility(View.VISIBLE);
            rlConsultaCategoria.setVisibility(View.INVISIBLE);
            rlConsultaTodosLugares.setVisibility(View.INVISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
        }
        if(busquedas[position].equalsIgnoreCase("Por Categoria")){
            listaLugaresCategoria = (ListView)findViewById(R.id.listaLugaresCategoria);
            listaLugaresCategoria.setVisibility(View.INVISIBLE);
            rlConsultaCategoria.setVisibility(View.VISIBLE);
            rlConsultaTodosLugares.setVisibility(View.INVISIBLE);
            rlConsultaNombre.setVisibility(View.INVISIBLE);
            rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
            rlConsultaFavoritos.setVisibility(View.INVISIBLE);
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
        }
    }
    public void accionCoordenadas(View view){
        LugaresPorCoordenadas lugaresPorCoordenadas = new LugaresPorCoordenadas();
        lugaresPorCoordenadas.execute();
    }
    public void accionNombre(View view){
        LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
        lugaresPorNombre.execute();
    }
    public void accionTodos(View view){
        TodosLosLugares todosLosLugares = new TodosLosLugares();
        todosLosLugares.execute();
    }
    public void accionCategorias(View view){
        LugaresPorCategoria lugaresPorCategoria = new LugaresPorCategoria();
        lugaresPorCategoria.execute();
    }
    public void accionFavoritos(View view){
        AgregarFavoritos agregarFavoritos = new AgregarFavoritos();
        agregarFavoritos.execute();
    }
    public void accionLugaresFavoritos(View view){
        LugaresFavoritos lugaresFavoritos = new LugaresFavoritos();
        lugaresFavoritos.execute();
    }
    private class LugaresPorCoordenadas extends AsyncTask<String, String, String> {
        String strFileContents=null;
        EditText etLatitud = (EditText) findViewById(R.id.etConsulta1);
        EditText etLongitud = (EditText) findViewById(R.id.etConsulta2);
        String latit = etLatitud.getText().toString();
        String longit = etLongitud.getText().toString();
        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;
            if(!isOnline()){
                return null;
            }else {
                if (latit.length() == 0 || longit.length() == 0) {
                    return strFileContents;
                } else {
                    try {
                        //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaLugarCoordenadas/" + latit + "/" + longit);
                        URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultaLugarCoordenadas/" + latit + "/" + longit);
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
                    Toast.makeText(getApplicationContext(), "ALERTA!!! Debe Ingresar Valores para proceder", Toast.LENGTH_SHORT).show();
                } else {

                    if (result.equalsIgnoreCase("[]")) {
                        Toast.makeText(getApplicationContext(), "El Lugar no se encuentra, Intente Nuevamente", Toast.LENGTH_SHORT).show();
                    } else {
                        String[] vectorCoordenadas = result.split(",");
                        String nombre = vectorCoordenadas[0].toString();
                        String descripcion = vectorCoordenadas[1].toString();
                        double latitud = Double.parseDouble(latit);
                        double longitud = Double.parseDouble(longit);
                        lugar = new LatLng(latitud, longitud);
                        mMap.addMarker(new MarkerOptions().position(lugar).title(nombre)).setSnippet(descripcion);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, 18));
                        mMap.animateCamera(CameraUpdateFactory.zoomIn());
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                        etLatitud.setText("");
                        etLongitud.setText("");
                        rlConsultaCoordenadas.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
    private class LugaresPorNombre extends AsyncTask<String, String, String> {
        String strFileContents=null;
        EditText etNombre = (EditText) findViewById(R.id.etCNombre);
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
                        URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultaLugarNombre/" +getIntent().getStringExtra("email")+"/"+ nombrej);
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
                        final String la = vectorCoordenadas[0].toString();
                        final String lo = vectorCoordenadas[0].toString();
                        final View view;
                        lugar = new LatLng(latitud, longitud);
                        mMap.addMarker(new MarkerOptions().position(lugar).title(nombre+"("+categoria+")")).setSnippet("Descripción="+descripcion+"\nTelefono="+telefono);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, 18));
                        mMap.animateCamera(CameraUpdateFactory.zoomIn());
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                        etNombre.setText("");
                        /*new AlertDialog.Builder(MapsActivityUsuarios.this)
                                .setTitle("ALERTA")
                                .setMessage("Desea Ingresar El Lugar Seleccionado A Favoritos??")
                                .setCancelable(false).setIcon(R.drawable.user)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // whatever...
                                        AgregarFavoritos agregarFavoritos = new AgregarFavoritos();
                                        agregarFavoritos.setLatitud(la);
                                        agregarFavoritos.setLongitud(lo);
                                        accionFavoritos(view);
                                        Toast.makeText(getApplicationContext(), "El lugar se ingreso a favoritos satisfactoriamente", Toast.LENGTH_SHORT).show();

                                    }
                                }).setNegativeButton("No,Gracias", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // whatever...
                            }
                        }).create().show();*/
                        rlConsultaNombre.setVisibility(View.INVISIBLE);
                    }
                }
            }

        }
    }
    private class LugaresFavoritos extends AsyncTask<String, String, String> {
        String strFileContents=null;
        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;
            // HTTP Get
            if(!isOnline()){
                return null;
            }else {
                try {
                    //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaTodosLugares/"+getIntent().getStringExtra("email"));
                    URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultarFavoritos/"+getIntent().getStringExtra("email"));
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
                String[] vectorCoordenadas = result.split("/");
                listaLugaresFavoritos = (ListView) findViewById(R.id.listaFavoritos);
                final ArrayList<String> lugares = new ArrayList<>();
                final ArrayList<String> lugaresParaMostrar = new ArrayList<>();
                for (int i = 0; i < vectorCoordenadas.length; i++) {
                    lugares.add(vectorCoordenadas[i]);
                }

                for (int i = 0; i < lugares.size(); i++) {
                    String[] lugar = lugares.get(i).split(",");
                    lugaresParaMostrar.add(lugar[0]+" ---"+lugar[1]);
                }

                listaLugaresFavoritos.setAdapter(new ArrayAdapter<>(getApplicationContext(), layout.simple_list_item_1, lugaresParaMostrar));
                listaLugaresFavoritos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                        String[] lugar = lugares.get(position).split(",");
                        String nombre = lugar[0];
                        LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
                        lugaresPorNombre.setEt(nombre);
                        accionNombre(view);
                        listaLugaresFavoritos.setVisibility(View.INVISIBLE);
                        lugaresPorNombre.setEt("");
                    }
                });
                listaLugaresFavoritos.setVisibility(View.VISIBLE);
            }
        }
    }
    private class TodosLosLugares extends AsyncTask<String, String, String> {
        String strFileContents=null;
        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;
            // HTTP Get
            if(!isOnline()){
                return null;
            }else {
                try {
                    //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaTodosLugares/"+getIntent().getStringExtra("email"));
                    URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultaTodosLugares/"+getIntent().getStringExtra("email"));
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
                String[] vectorCoordenadas = result.split("/");
                listaTodosLugares = (ListView) findViewById(R.id.listaTodosLugares);
                final ArrayList<String> lugares = new ArrayList<>();
                final ArrayList<String> lugaresParaMostrar = new ArrayList<>();
                for (int i = 0; i < vectorCoordenadas.length; i++) {
                    lugares.add(vectorCoordenadas[i]);
                }

                for (int i = 0; i < lugares.size(); i++) {
                    String[] lugar = lugares.get(i).split(",");
                    lugaresParaMostrar.add(lugar[0]+" ---"+lugar[1]);
                }

                listaTodosLugares.setAdapter(new ArrayAdapter<>(getApplicationContext(), layout.simple_list_item_1, lugaresParaMostrar));
                listaTodosLugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                        String[] lugar = lugares.get(position).split(",");
                        String nombre = lugar[0];
                        final String latitud = lugar[2];
                        final String longitud = lugar[3];
                        LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
                        lugaresPorNombre.setEt(nombre);
                        accionNombre(view);
                        new AlertDialog.Builder(MapsActivityUsuarios.this)
                                .setTitle("FAVORITOS")
                                .setMessage("¿Desea Ingresar el Lugar Seleccionado a Favoritos?")
                                .setCancelable(false).setIcon(R.drawable.user)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // whatever...
                                        AgregarFavoritos agregarFavoritos = new AgregarFavoritos();
                                        agregarFavoritos.setLatitud(latitud);
                                        agregarFavoritos.setLongitud(longitud);
                                        accionFavoritos(view);
                                    }
                                }).setNegativeButton("No,Gracias", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // whatever...
                            }
                        }).create().show();
                        listaTodosLugares.setVisibility(View.INVISIBLE);
                        lugaresPorNombre.setEt("");


                    }
                });
                listaTodosLugares.setVisibility(View.VISIBLE);
            }
        }
    }
    private class AgregarFavoritos extends AsyncTask<String, String, String> {
        String strFileContents=null;
        EditText etLatitudF =(EditText)findViewById(R.id.etLatitudF);
        EditText etLongitudF =(EditText)findViewById(R.id.etLongitudF);
        String latitud = etLatitudF.getText().toString();
        String longitud=etLongitudF.getText().toString();

        public void setLongitud(String longitud) {
            etLongitudF.setText(longitud);
        }

        public void setLatitud(String latitud) {
            etLatitudF.setText(latitud);
        }

        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;
            // HTTP Get
            if(!isOnline()){
                return null;
            }else {
                try {
                    //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaTodosLugares");
                    URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/agregarFavorito/"+getIntent().getStringExtra("email")+"/"+latitud+"/"+longitud);
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
            //Toast.makeText(getApplicationContext(), "HOLA FAVORITOSS"+result, Toast.LENGTH_SHORT).show();
            if (!isOnline()) {
                Toast.makeText(getApplicationContext(), "Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    if ((Integer.parseInt(result) == 1)) {
                        Toast.makeText(getApplicationContext(), "El lugar se ingreso a FAVORITOS", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "El lugar NO se ingreso a FAVORITOS", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR AL INGRESAR EL LUGAR A FAVORITOS", Toast.LENGTH_SHORT).show();
                }
              /* String[] vectorCoordenadas = result.split("-");
                listaTodosLugares = (ListView) findViewById(R.id.listaTodosLugares);
                final ArrayList<String> lugares = new ArrayList<>();
                for (int i = 0; i < vectorCoordenadas.length; i++) {
                    lugares.add(vectorCoordenadas[i]);
                }
                listaTodosLugares.setAdapter(new ArrayAdapter<>(getApplicationContext(), layout.simple_list_item_1, lugares));
                listaTodosLugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] lugar = lugares.get(position).split(",");
                        String nombre = lugar[0];
                        LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
                        lugaresPorNombre.setEt(nombre);
                        accionNombre(view);
                        listaTodosLugares.setVisibility(View.INVISIBLE);
                        lugaresPorNombre.setEt("");
                    }
                });
                listaTodosLugares.setVisibility(View.VISIBLE);*/
            }
        }
    }
    private class LugaresPorCategoria extends AsyncTask<String, String, String> {
        String strFileContents = null;
        Spinner spinnerCategorias = (Spinner) findViewById(R.id.spinnerCategorias);
        String categoria = spinnerCategorias.getSelectedItem().toString();

        @Override
        protected String doInBackground(String... params) {
            InputStream in = null;
            if(!isOnline()){
                return null;
            }else {
                try {
                    //URL url = new URL("http://10.0.2.2:8080/Jacam/resources/ConsultaLugares/consultaLugarCategoria/"+categoria);
                    URL url = new URL("http://eastsites.j.facilcloud.com/Jacam/resources/ConsultaLugares/consultaLugarCategoria/"+getIntent().getStringExtra("email")+"/" + categoria);
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
        protected void onPostExecute(String result) {
            if (!isOnline()) {
                Toast.makeText(getApplicationContext(), "Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();
            }else {
                final String[] vectorCoordenadas = result.split("/");
                listaLugaresCategoria = (ListView) findViewById(R.id.listaLugaresCategoria);
                final ArrayList<String> lugares = new ArrayList<>();
                for (int i = 0; i < vectorCoordenadas.length; i++) {
                    lugares.add(vectorCoordenadas[i]);
                }
                listaLugaresCategoria.setAdapter(new ArrayAdapter<>(getApplicationContext(), layout.simple_list_item_1, lugares));
                listaLugaresCategoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] lugar = lugares.get(position).split(",");
                        String nombre = lugar[0];
                        LugaresPorNombre lugaresPorNombre = new LugaresPorNombre();
                        lugaresPorNombre.setEt(nombre);
                        accionNombre(view);
                        listaLugaresCategoria.setVisibility(View.INVISIBLE);
                        lugaresPorNombre.setEt("");
                    }
                });
                listaLugaresCategoria.setVisibility(View.VISIBLE);
            }
        }
    }
}
