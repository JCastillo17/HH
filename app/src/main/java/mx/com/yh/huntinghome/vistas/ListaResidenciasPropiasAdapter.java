package mx.com.yh.huntinghome.vistas;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.EntidadListaPropiasResidencias;

public class ListaResidenciasPropiasAdapter extends ArrayAdapter<EntidadListaPropiasResidencias> {

    Context context;
    int layoutResource;
    EntidadListaPropiasResidencias datos[]=null;


    public ListaResidenciasPropiasAdapter(Context context, int layoutResource, EntidadListaPropiasResidencias[] datos) {
        super(context, layoutResource,datos);
        this.context = context;
        this.layoutResource = layoutResource;
        this.datos = datos;
    }

    public View getView(int poscion, View convertView, ViewGroup parent){
        View row=convertView;
        ListaResidenciasPropiasAdapter.ResidenciasHolder resHold=new ListaResidenciasPropiasAdapter.ResidenciasHolder();

        if(row==null){
            row= LayoutInflater.from(this.context).inflate(R.layout.activity_items_residencias_propias,parent,false);

            resHold.cv=(CardView) row.findViewById(R.id.cvResPropia);
            resHold.btnEdtRes=(Button)row.findViewById(R.id.btnEdtRes);
            resHold.imgRes=(ImageView) row.findViewById(R.id.ivImgResidenciaPropia);
            resHold.munRes=(TextView) row.findViewById(R.id.tvMunicipioResPrp);
            resHold.estRes=(TextView) row.findViewById(R.id.tvEstadoResPrp);
            resHold.colRes=(TextView) row.findViewById(R.id.tvComunidadResPrp);
            resHold.tipoRes=(TextView) row.findViewById(R.id.tvTipoResPrp);
            resHold.precioRes=(TextView) row.findViewById(R.id.tvPrecioResPrp);
            resHold.swchActRes=(Switch) row.findViewById(R.id.swchDispRes);
            row.setTag(resHold);
        }else {
            resHold=(ListaResidenciasPropiasAdapter.ResidenciasHolder)row.getTag();
        }
        EntidadListaPropiasResidencias res=null;
        setListRes(resHold,res,poscion);
        return row;
    }

    static class ResidenciasHolder{
        CardView cv;
        ImageView imgRes;
        Button btnEdtRes;
        TextView munRes, estRes, colRes, tipoRes, precioRes;
        Switch swchActRes;
    }

    public void setListRes(ListaResidenciasPropiasAdapter.ResidenciasHolder holder, EntidadListaPropiasResidencias res, int posicion){
        res=datos[posicion];
        holder.cv.setRadius(20);
        holder.cv.setCardBackgroundColor(Color.WHITE);
        holder.imgRes.setImageResource(res.getImgRes());
        holder.munRes.setText(res.getMunRes());
        holder.estRes.setText(res.getEstRes());
        holder.colRes.setText(res.getColRes());
        holder.tipoRes.setText(res.getTipoRes());
        holder.precioRes.setText(res.getPrecioRes());
        holder.swchActRes.setChecked(res.isResidenciaActiva());
    }
}
