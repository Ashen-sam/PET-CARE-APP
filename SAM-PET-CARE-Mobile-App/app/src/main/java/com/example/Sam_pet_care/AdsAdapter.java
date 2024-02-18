package com.example.Sam_pet_care;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleanme.R;

import java.util.ArrayList;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.ViewHolder> {

    private Context context;
    private ArrayList id, name, address, phone, nic, property, bedrooms, bathrooms, times;


    public AdsAdapter(Context context, ArrayList id, ArrayList name, ArrayList address, ArrayList phone, ArrayList nic, ArrayList property, ArrayList bedrooms, ArrayList bathrooms, ArrayList times) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.property = property;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.times = times;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customer_ads,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.address.setText(String.valueOf(address.get(position)));
        holder.phone.setText(String.valueOf(phone.get(position)));
        holder.nic.setText(String.valueOf(nic.get(position)));
        holder.property.setText(String.valueOf(property.get(position)));
        holder.bedrooms.setText(String.valueOf(bedrooms.get(position)));
        holder.bathrooms.setText(String.valueOf(bathrooms.get(position)));
        holder.times.setText(String.valueOf(times.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, address, phone, nic, property, bedrooms, bathrooms, times;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.adID);
            name=itemView.findViewById(R.id.adName);
            address=itemView.findViewById(R.id.adAddress);
            phone=itemView.findViewById(R.id.adPhone);
            nic=itemView.findViewById(R.id.adNIC);
            property=itemView.findViewById(R.id.adProperty);
            bedrooms=itemView.findViewById(R.id.adBedrooms);
            bathrooms=itemView.findViewById(R.id.adBathrooms);
            times=itemView.findViewById(R.id.adTimes);
        }
    }
}
