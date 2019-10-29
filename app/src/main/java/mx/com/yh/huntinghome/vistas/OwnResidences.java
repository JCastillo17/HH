package mx.com.yh.huntinghome.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.EntidadListaPropiasResidencias;
import mx.com.yh.huntinghome.modelos.EntidadListaReidencia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

public class OwnResidences extends Fragment {

    ListView listView;
    ImageButton ibImgRes;

    EntidadListaPropiasResidencias elr[]=new EntidadListaPropiasResidencias[]{
            new EntidadListaPropiasResidencias(R.drawable.img_res1,
                    "Guadalupe","Zacatecas","Casa Blanca",
                    "Habitación","1000",true),
            new EntidadListaPropiasResidencias(R.drawable.img_res2,
                    "Guadalupe","Zacatecas","Villas",
                    "habitacion","1300",false),
            new EntidadListaPropiasResidencias(R.drawable.img_res3,
                    "Guadalupe","Zacatecas","Villas",
                    "habitacion","1300",true)
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_own_residences, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)getView().findViewById(R.id.lvShowOwnResidences);
        ListaResidenciasPropiasAdapter adapter = new ListaResidenciasPropiasAdapter(getActivity().getApplicationContext(), R.layout.activity_list_item_residencias,elr);
        listView.setAdapter(adapter);

    }
}
