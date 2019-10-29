package mx.com.yh.huntinghome.vistas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import mx.com.yh.huntinghome.R;

public class ListItemResidencia extends Fragment {

    ImageView imgUsr;
    ImageButton imgRes;
    Button btnNomUsr;
    TextView munRes, estRes, colRes, tipoRes, precioRes;
    CheckBox meGusta;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_list_item_residencias,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imgUsr=(ImageView)getView().findViewById(R.id.ivImgUsr);
        imgRes=(ImageButton)getView().findViewById(R.id.ivImgResidencia);
        btnNomUsr=(Button)getView().findViewById(R.id.btnNameUsr);
        munRes=(TextView)getView().findViewById(R.id.tvMunicipioRes);
        estRes=(TextView)getView().findViewById(R.id.tvEstadoRes);
        colRes=(TextView)getView().findViewById(R.id.tvComunidadRes);
        tipoRes=(TextView)getView().findViewById(R.id.tvTipoRes);
        precioRes=(TextView)getView().findViewById(R.id.tvPrecioRes);
        meGusta=(CheckBox)getView().findViewById(R.id.cbMeGusta);
    }

    public void cambiaPetana(){
        PerfilUsr perfilUsr=new PerfilUsr();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.list_iten_residencia, perfilUsr);
        ft.addToBackStack(null);
        ft.commit();
    }
}
