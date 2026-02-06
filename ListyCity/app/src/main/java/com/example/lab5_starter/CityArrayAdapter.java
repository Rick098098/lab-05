package com.example.lab5_starter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {

    private final ArrayList<City> cities;
    private final Context context;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference citiesRef = db.collection("Cities");

    public CityArrayAdapter(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView tv = view.findViewById(R.id.content_view);
        Button deleteBtn = view.findViewById(R.id.btn_delete_city);

        tv.setText(city.getName() + ", " + city.getProvince());

        deleteBtn.setOnClickListener(v -> {
            if (city.getId() != null) {
                citiesRef.document(city.getId()).delete();
            }
        });

        return view;
    }
}
