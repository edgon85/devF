package com.edgon.retrofit_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edgon.retrofit_recyclerview.R;
import com.edgon.retrofit_recyclerview.models.Contactos;

import java.util.ArrayList;
import java.util.List;


public class ContactosAdapter extends
        RecyclerView.Adapter<ContactosAdapter.ContactosViewHolder>{

    List<Contactos> listContactos = new ArrayList<>();

    public ContactosAdapter(List<Contactos> listContactos) {
        this.listContactos = listContactos;
    }

    @Override
    public ContactosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_contactos,parent,false);

        return new ContactosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactosViewHolder holder, int position) {
        Contactos contactos = listContactos.get(position);
        holder.txtName.setText(contactos.getName());
        holder.txtAddress.setText(contactos.getAddress());
        holder.txtEmail.setText(contactos.getEmail());
    }

    @Override
    public int getItemCount() {
        return listContactos.size();
    }

    public class ContactosViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public TextView txtAddress;
        public TextView txtEmail;
        public ImageView imgPhoto;

        public ContactosViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtAddress = (TextView) itemView.findViewById(R.id.txt_address);
            txtEmail = (TextView) itemView.findViewById(R.id.txt_email);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_view);
        }
    }
}
