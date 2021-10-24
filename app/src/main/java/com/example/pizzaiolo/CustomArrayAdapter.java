package com.example.pizzaiolo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Flour> {

    private String key;
    private Context mContext;

    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Flour> customLists) {
        super(context, resource, customLists);
    }


    public void setConfig(){

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);

        }

        Flour flour = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.img);
        imageView.setImageResource(flour.getmImgRedId());
        TextView mFlourName = listItemView.findViewById(R.id.flour_name);
        mFlourName.setText(flour.getmFlourName());
        this.key = key;

        return listItemView;
    }

}
