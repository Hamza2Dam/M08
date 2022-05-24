package com.example.projectf2f3;

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

    public AdapterDatos(ArrayList<MenuVo> listaUsuario) {
        this.listaMenu = listaUsuario;
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

        String urla =listaMenu.get(position).getFoto();
        String urlb ="https://www.google.com/search?q=pizza&rlz=1C1GCEA_enES929ES929&sxsrf=ALiCzsZi4cnXgkt6LF8wP4-vLH6MIwo75g:1653363442879&source=lnms&tbm=isch&sa=X&ved=2ahUKEwi43snlmvf3AhWDyoUKHU62CFkQ_AUoAnoECAMQBA&biw=1920&bih=937&dpr=1#imgrc=OHCj3BQ07nlg4M";

        //Picasso.with(this).load(urla).placeholder(R.mipmap.ic_launcher).into(holder.mAnimeImageView);
        //Picasso.with(this).load(urlb).into(holder.mAnimeImageView);

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
