package mx.com.yh.huntinghome.vistas;

import androidx.appcompat.app.AppCompatActivity;

import mx.com.yh.huntinghome.LoginActivity;
import mx.com.yh.huntinghome.R;
//import mx.com.yh.huntinghome.logica.RegistrarResidencia;
import mx.com.yh.huntinghome.modelos.Constantes;
import mx.com.yh.huntinghome.modelos.Usuario;
import mx.com.yh.huntinghome.modelos.Validaciones;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class RegistroResidencia extends AppCompatActivity {

    private JSONObject datos;
    private Usuario usuarioUp;
    private Validaciones objValidar; //objeto de nuestro clase Validaciones
    private Constantes constantes;
    private HashMap headers = new HashMap();

    private RadioButton radioResidencia;
    private RadioButton radioHabitacion;
    private CheckBox cbServAgua, cbServElec, cbServGas, cbServDrenaje, cbServInternet, cbServCable, cbServTel, cbMasc, cbCuota;
    private Button btnGuardar;
    private EditText etNumHabitaciones, etCalle, etNumeroInt, etNumeroExt
            , etColonia, etMunicipio, etEstado,etDetallesResidencia;

    private String numHabitaciones, calle, numeroInt, numeroExt, colonia, municipio, estado, tipo_lugar, error, valorEstado,
            agua, electricidad, gas, drenaje, internet, cable, telefono, mascotas, cuota, userSesion;
    //private String fNacimiento, nombre, apPaterno, apMaterno, telefono, FeNacimiento, email, password, sexo, tipo_usuario, error, valorEstado;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_residencia);

        datos = new JSONObject();
        constantes = new Constantes();
        objValidar = new Validaciones();
        //usuarioUp = new Usuario(datos);

        //userSesion = usuarioUp.getIdUsuario();
        etNumHabitaciones = (EditText) findViewById(R.id.etNumHabit);
        etCalle = (EditText) findViewById(R.id.etCalleRes);
        etNumeroInt = (EditText) findViewById(R.id.etNumIntRes);
        etNumeroExt = (EditText) findViewById(R.id.etNumExtRes);
        etColonia = (EditText) findViewById(R.id.etColRes);
        etMunicipio = (EditText) findViewById(R.id.etMunRes);
        etEstado = (EditText) findViewById(R.id.etEstRes);
        //etDetallesResidencia = (EditText) findViewById(R.id.et);
        radioResidencia = (RadioButton) findViewById(R.id.rbRes);
        radioHabitacion = (RadioButton) findViewById(R.id.rbHabit);
        btnGuardar = (Button) findViewById(R.id.btnGuardarRes);
        cbServAgua = (CheckBox) findViewById(R.id.cbServAgua);
        cbServElec = (CheckBox) findViewById(R.id.cbServElec);
        cbServGas = (CheckBox) findViewById(R.id.cbServGas);
        cbServDrenaje = (CheckBox) findViewById(R.id.cbServDrenaje);
        cbServInternet = (CheckBox) findViewById(R.id.cbServInternet);
        cbServCable = (CheckBox) findViewById(R.id.cbServCable);
        cbServTel = (CheckBox) findViewById(R.id.cbServTel);
        cbMasc = (CheckBox) findViewById(R.id.cbMasc);
        cbCuota = (CheckBox) findViewById(R.id.cbCuota);
        headers.put("Content-Type", "application/json");
        headers.put("autorizar", "e3862d3b7f13b1055de9c2b62c25b89c");


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                numHabitaciones = etNumHabitaciones.getText().toString();
                calle = etCalle.getText().toString();
                numeroInt = etNumeroInt.getText().toString();
                numeroExt = etNumeroExt.getText().toString();
                colonia = etColonia.getText().toString();
                municipio = etMunicipio.getText().toString();
                estado = etEstado.getText().toString();

                if (radioResidencia.isChecked()) {
                    tipo_lugar = "Residencia";
                } else if (radioHabitacion.isChecked()) {
                    tipo_lugar = "Habitaciòn";
                }

                if(cbCuota.isChecked()){
                    cuota="1";
                }else{
                    cuota="0";
                }
                if(cbMasc.isChecked()){
                    mascotas="1";
                }else{
                    mascotas="0";
                }

                if(cbServAgua.isChecked()){
                    agua="1";
                }else{
                    agua="0";
                }

                if(cbServElec.isChecked()){
                    electricidad="1";
                }else{
                    electricidad="0";
                }
                if(cbServGas.isChecked()){
                    gas="1";
                }else{
                    gas="0";
                }
                if(cbServInternet.isChecked()){
                    internet="1";
                }else{
                    internet="0";
                }
                if(cbServCable.isChecked()){
                    cable="1";
                }else{
                    cable="0";
                }
                if(cbServDrenaje.isChecked()){
                    drenaje="1";
                }else{
                    drenaje="0";
                }
                if(cbServTel.isChecked()){
                    telefono="1";
                }else{
                    telefono="0";
                }

                if (!objValidar.Vacio(etNumHabitaciones) && !objValidar.Vacio(etCalle) && !objValidar.Vacio(etNumeroExt)
                        && !objValidar.Vacio(etColonia) && !objValidar.Vacio(etMunicipio) && !objValidar.Vacio(etEstado)) {
                    try {
                        datos.put("id_tipo", tipo_lugar);
                        datos.put("numHabitaciones", numHabitaciones);
                        datos.put("calle", calle);
                        datos.put("numInterior", numeroInt);
                        datos.put("numExterior", numeroExt);
                        datos.put("colonia", colonia);
                        datos.put("municipio", municipio);
                        datos.put("estado", estado);
                        datos.put("agua", agua);
                        datos.put("luz", electricidad);
                        datos.put("gas", gas);
                        datos.put("internet", internet);
                        datos.put("cable", cable);
                        datos.put("drenaje", drenaje);
                        datos.put("telefono", telefono);
                    } catch (JSONException e) {
                        Log.println(Log.ERROR, "error", e.toString());
                    }

                }

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JSONHeaderRequest jsonHeaderRequest = new JSONHeaderRequest(url, headerParams, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Aquí se procesa el JSON obtenido
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Aquí se procesa el error producido
                    }
                });
                JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, constantes.getRegistroResidencia(), datos,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject jO = new JSONObject();
                                    jO = response;
                                    valorEstado = jO.getString("estado");
                                } catch (JSONException e) {
                                    Log.println(Log.ERROR, "error", e.toString());
                                }
                                if (valorEstado.equals("1")) {
                                    startActivity(new Intent(RegistroResidencia.this, LoginActivity.class));
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Residencia no registrada", Toast.LENGTH_SHORT);
                            }
                        });



                queue.add(jsObjRequest);
            }
        });
    }
}
