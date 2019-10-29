package mx.com.yh.huntinghome.modelos;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String nombreUsuario;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private String tipoUsuario;
    private String FeNacimiento;
    private String sexoUsuario;
    private String correoUsuario;
    private String password;
    private String claveApi;

    public Usuario(JSONObject jsonObject) {
        try {
            idUsuario = jsonObject.getInt("id_usuario");
            nombreUsuario = jsonObject.getString("nombre");
            apPaterno = jsonObject.getString("ap_paterno");
            apMaterno = jsonObject.getString("ap_materno");
            telefono = jsonObject.getString("telefono");
            tipoUsuario = jsonObject.getString("tipo_usuario");
            sexoUsuario = jsonObject.getString("sexo");
            FeNacimiento = jsonObject.getString("fecha_nac");
            correoUsuario = jsonObject.getString("correo");
            claveApi = jsonObject.getString("claveApi");
        }catch (JSONException e){
            Log.println(Log.ERROR,"error",e.toString());
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFeNacimiento() {
        return FeNacimiento;
    }

    public void setFeNacimiento(String feNacimiento) {
        FeNacimiento = feNacimiento;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClaveApi() {
        return claveApi;
    }

    public void setClaveApi(String claveApi) {
        this.claveApi = claveApi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoUsuario != null ? correoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.correoUsuario == null && other.correoUsuario != null) || (this.correoUsuario != null && !this.correoUsuario.equals(other.correoUsuario))) {
            return false;
        }
        return true;
    }


}
