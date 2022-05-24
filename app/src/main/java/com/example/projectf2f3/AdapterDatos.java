package com.example.projectf2f3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectf2f3.entitades.MenuVo;
import com.example.projectf2f3.entitades.Usuario;

import java.util.ArrayList;
public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<MenuVo> listaMenu;
    private Context context;

    public AdapterDatos(ArrayList<MenuVo> listaUsuario) {
        this.listaMenu = listaUsuario;
        this.context = context;

    }

    @Override
    public ViewHolderDatos onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder( ViewHolderDatos holder, int position) {
        holder.ElNombre.setText(listaMenu.get(position).getNombre());
        holder.LaDescripcion.setText(listaMenu.get(position).getDescripcion());
        holder.ElPrecio.setText(listaMenu.get(position).getPrecio());

        String urla = listaMenu.get(position).getFoto();
        //String urlb = "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg";

        Picasso.get().load(urla).into(holder.mAnimeImageView);

    }

    @Override
    public int getItemCount() {
        return listaMenu.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView ElNombre, LaDescripcion, ElPrecio;
        ImageView mAnimeImageView;

        public ViewHolderDatos( View itemView) {
            super(itemView);
            ElNombre = (TextView) itemView.findViewById(R.id.idTitulo);
            LaDescripcion = (TextView) itemView.findViewById(R.id.idDescipcion);
            ElPrecio = (TextView) itemView.findViewById(R.id.idPrecio);
            mAnimeImageView = (ImageView) itemView.findViewById(R.id.idImagen);

        }
    }
}
