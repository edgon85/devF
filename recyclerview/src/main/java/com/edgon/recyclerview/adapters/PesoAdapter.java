package com.edgon.recyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edgon.recyclerview.R;
import com.edgon.recyclerview.models.Peso;

import java.util.ArrayList;
import java.util.List;


public class PesoAdapter extends RecyclerView.Adapter<PesoAdapter.PesoViewHolder>{

    public List<Peso> pesoList = new ArrayList<>();

    public PesoAdapter(List<Peso> pesoList) {
        this.pesoList = pesoList;
    }

    @Override
    public PesoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new PesoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PesoViewHolder pesoViewholder, int position) {
        Peso peso = pesoList.get(position);

        pesoViewholder.tvPeso.setText(peso.getPeso());
        pesoViewholder.tvFecha.setText(peso.getFecha());
    }

    @Override
    public int getItemCount() {
        return pesoList.size();
    }



    public class PesoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvFecha;
        public TextView tvPeso;

        public PesoViewHolder(View itemView) {
            super(itemView);
            tvFecha = (TextView) itemView.findViewById(R.id.tv_fecha);
            tvPeso = (TextView) itemView.findViewById(R.id.tv_peso);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e("MyLog","click");
            /*Context context = view.getContext();
            int position = getAdapterPosition();
            Peso peso = pesoList.get(position);
            Intent intent = new Intent(view.getContext(),Description.class);
            intent.putExtra("Peso",peso.getPeso());
            context.startActivity(intent);*/
        }
    }
}
