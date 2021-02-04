package com.example.recyclerviewwitheditext.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerviewwitheditext.R;
import com.example.recyclerviewwitheditext.model.ListModel;

import java.util.ArrayList;

public class LIstAdapter extends RecyclerView.Adapter<LIstAdapter.MyViewHolder> {
    ArrayList<ListModel> arrayList;
    ArrayList<String> payment;
    Context context;
    String[] alllistStr;
    String[] alllistStr1;
    String strValue;
    private int index;

    public LIstAdapter(ArrayList<ListModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        payment = new ArrayList<>();
        alllistStr = new String[arrayList.size()];
        alllistStr1 = new String[arrayList.size()];
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LIstAdapter.MyViewHolder holder, int position) {
        ListModel model = arrayList.get(position);
        holder.ET_ModelnumberHint.setText(model.getTitle());
        index = position;
        alllistStr = payment.toArray(new String[0]);
        alllistStr1 = payment.toArray(new String[0]);

        holder.ET_Modelnumber.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                strValue = arrayList.get(position).getTitle();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public int getList(int position) {
        index = position;
        return index;
    }

    public String[] getAlllistStr() {

        return alllistStr;
    }

    public String[] getAlllistStr1() {

        return alllistStr1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        EditText ET_Modelnumber;
        ImageView lastimg;
        TextView tv_lavel, ET_ModelnumberHint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ET_Modelnumber = itemView.findViewById(R.id.ET_Modelnumber);
            ET_ModelnumberHint = itemView.findViewById(R.id.ET_ModelnumberHint);

            ET_Modelnumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    try {

                        Log.d("strValue_", strValue);
                        alllistStr[getAdapterPosition()] = strValue + " +" + s.toString();
                        alllistStr1[getAdapterPosition()] = s.toString();
                        Log.d("charrr__", s.toString());


                    } catch (Exception ex) {
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }

    }

}

