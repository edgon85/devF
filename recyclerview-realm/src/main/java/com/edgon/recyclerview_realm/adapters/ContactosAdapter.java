package com.edgon.recyclerview_realm.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edgon.recyclerview_realm.R;
import com.edgon.recyclerview_realm.activitys.DetailActivity;
import com.edgon.recyclerview_realm.models.Contactos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonza on 7/18/2017.
 */

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ContactosViewHolder> {

    public List<Contactos> listContactos = new ArrayList<>();

    public ContactosAdapter(List<Contactos> listContactos) {
        this.listContactos = listContactos;
    }

    @Override
    public ContactosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_contactos, parent, false);

        return new ContactosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactosViewHolder holder, int position) {

        Contactos contactos = listContactos.get(position);
        holder.tvName.setText(contactos.getName());
        holder.tvPhone.setText(contactos.getPhone());
        holder.tvEmail.setText(contactos.getEmail());


    }

    @Override
    public int getItemCount() {
        return listContactos.size();
    }

    public class ContactosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private TextView tvPhone;
        private TextView tvEmail;
        private FloatingActionButton btnAdd;

        public ContactosViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPhone = (TextView) itemView.findViewById(R.id.tv_phone);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            int position = getAdapterPosition();
            Contactos contactos = listContactos.get(position);
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", contactos.getName());
            intent.putExtra("phone", contactos.getPhone());
            intent.putExtra("email", contactos.getEmail());
            context.startActivity(intent);
            notifyDataSetChanged();
        }
    }
}
