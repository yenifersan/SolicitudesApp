package com.santiago.solicitudesapp.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.santiago.solicitudesapp.R;
import com.santiago.solicitudesapp.models.ResponseMessage;
import com.santiago.solicitudesapp.models.Solicitud;
import com.santiago.solicitudesapp.service.ApiService;
import com.santiago.solicitudesapp.service.ApiServiceGenerator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolicitudesAdapter extends RecyclerView.Adapter<SolicitudesAdapter.ViewHolder> {

    private static final String TAG = SolicitudesAdapter.class.getSimpleName();

    private List<Solicitud> solicitudes;

    public SolicitudesAdapter(){
        this.solicitudes = new ArrayList<>();
    }

    public void setSolicitudes(List<Solicitud> solicitudes){
        this.solicitudes = solicitudes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView fotoImage;
        public TextView correoText;
        public TextView tipoText;
        public TextView motivoText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.foto_image);
            correoText = itemView.findViewById(R.id.correo_text);
            tipoText = itemView.findViewById(R.id.tipo_text);
            motivoText = itemView.findViewById(R.id.motivo_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitud, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final Solicitud solicitud = this.solicitudes.get(position);

        viewHolder.correoText.setText(solicitud.getCorreo());
        viewHolder.tipoText.setText(solicitud.getTipo());
        viewHolder.motivoText.setText(solicitud.getMotivo());

        String url = ApiService.API_BASE_URL + "/solicitudes/images/" + solicitud.getImagen();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.solicitudes.size();
    }

}