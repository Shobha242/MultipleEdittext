package com.example.recyclerviewwitheditext.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewwitheditext.R;
import com.example.recyclerviewwitheditext.modelformyproduct.FilteredOrderItem;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    List<FilteredOrderItem> arrayList;
    Context context;

    public ProductAdapter(List<FilteredOrderItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_my_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.ET_ModelnumberHint.setText(arrayList.get(position).getPurchaseDate());
        holder.customerProductNo.setText(arrayList.get(position).getNo());
        holder.customerProductDate.setText(arrayList.get(position).getPurchaseDate());
        holder.customerProductName.setText(arrayList.get(position).getDetail().getProduct().getName());
        holder.customerProductnameMobno.setText(arrayList.get(position).getUser().getName() + "(" + arrayList.get(position).getUser().getMobile() + ")");
        holder.customerProductmodelno.setText(arrayList.get(position).getDetail().getProduct().getSku());

        Glide.with(context)
                .load(arrayList.get(position).getDetail().getProduct().getCover())
                .into(holder.customerProductImage);
        if (arrayList.get(position).getStatus().equals("Pending")) {
            holder.delete.setText("Delete Product");
            holder.instaRq.setText("Activate Product");
        } else if (arrayList.get(position).getDetail().isInstallationRequired() == true) {
            holder.delete.setText("");
            holder.instaRq.setText("Installation Request");
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        EditText ET_Modelnumber;
        TextView tv_lavel, ET_ModelnumberHint;

        TextView customerProductNo, customerProductDate, customerProductName, customerProductnameMobno, customerProductmodelno, customerProductDealerAddress;

        LinearLayout myproductfilterL1, myProductBelowLay, myPrditemClicked;
        ImageView customerProductImage;
        TextView instaRq, delete;
        RelativeLayout viewMyprod1;
        RecyclerView MyProductFilterAdapter_value;
        LinearLayout LL_MyProductFilterAdapter_value;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ET_Modelnumber = itemView.findViewById(R.id.ET_Modelnumber);
            ET_ModelnumberHint = itemView.findViewById(R.id.ET_ModelnumberHint);

            customerProductImage = itemView.findViewById(R.id.customerProductImage);
            customerProductNo = itemView.findViewById(R.id.customerProductNo);
            customerProductDate = itemView.findViewById(R.id.customerProductDate);
            customerProductName = itemView.findViewById(R.id.customerProductName);
            customerProductnameMobno = itemView.findViewById(R.id.customerProductnameMobno);
            customerProductmodelno = itemView.findViewById(R.id.customerProductmodelno);
            customerProductDealerAddress = itemView.findViewById(R.id.customerProductDealerAddress);
            MyProductFilterAdapter_value = itemView.findViewById(R.id.MyProductFilterAdapter_value);
            delete = itemView.findViewById(R.id.delete);
            instaRq = itemView.findViewById(R.id.instaRq);
            viewMyprod1 = itemView.findViewById(R.id.viewMyprod1);
            myProductBelowLay = itemView.findViewById(R.id.myProductBelowLay);
            myPrditemClicked = itemView.findViewById(R.id.myPrditemClicked);
            LL_MyProductFilterAdapter_value = itemView.findViewById(R.id.LL_MyProductFilterAdapter_value);

        }

    }

}
