package com.example.recyclerviewwitheditext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewwitheditext.adapters.ProductAdapter;
import com.example.recyclerviewwitheditext.modelformyproduct.FilteredOrderItem;
import com.example.recyclerviewwitheditext.modelformyproduct.ProductModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyProductActivity extends AppCompatActivity {

    ProgressDialog progressbar;
    String accessTokenHome;
    RecyclerView rv_recyclerview;
    ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product);
        rv_recyclerview = findViewById(R.id.rv_recyclerview);
        try {
            dealerProductApi();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void dealerProductApi() throws UnsupportedEncodingException {
        progressbar = new ProgressDialog(MyProductActivity.this);
        progressbar.setMessage("Loading ...");
        List<FilteredOrderItem> arrayList = new ArrayList<>();
        String url = "{ \"data\": { \"dealer_products_filter\": { \"responseInfo\": { \"status\": 200, \"message\": \"\", \"error\": \"\" }, \"paginatorInfo\": { \"count\": 2, \"currentPage\": 1, \"firstItem\": 1, \"hasMorePages\": false, \"lastItem\": 2, \"lastPage\": 1, \"perPage\": 10, \"total\": 2 }, \"status_count\": { \"activated\": 1, \"new\": 2 }, \"filtered_order\": [ { \"id\": 1301874, \"no\": \"PRD6017D3C05B014\", \"serial_no\": \"\", \"under_warranty\": false, \"purchase_date\": \"2021-01-05 00:00:00\", \"inititated_by\": \"Dealer\", \"active\": true, \"status\": \"Pending\", \"dealer_location_id\": 1606, \"warrantyleft\": -1, \"user\": { \"name\": \"kuldeep singh\", \"username\": \"9990304802\", \"mobile\": \"9990304802\" }, \"address\": { \"alias\": \"home\", \"contact_name\": \"kuldeep\", \"address_1\": \"noida\", \"address_2\": \"gautam budh nagar\", \"pincode\": { \"pincode\": 201301, \"city\": { \"name\": \"Gautam Buddha Nagar\", \"state\": { \"name\": \"UTTAR PRADESH\", \"country\": { \"name\": \"India\" } } } }, \"area\": { \"name\": \"Noida\" } }, \"location\": { \"id\": \"1606\", \"name\": \"Rajeev\", \"dealer\": { \"id\": \"1601\", \"name\": \"DealerTesting\" }, \"address\": { \"alias\": \"Default\", \"contact_name\": \"Rajeev\", \"address_1\": \"add1\", \"address_2\": \"add2\", \"full_address\": \"add1, add2, Noida, Gautam Buddha Nagar, UTTAR PRADESH, 201301\", \"pincode\": { \"pincode\": 201301, \"city\": { \"name\": \"Gautam Buddha Nagar\", \"state\": { \"name\": \"UTTAR PRADESH\", \"country\": { \"name\": \"India\" } } } }, \"area\": { \"name\": \"Noida\" } } }, \"documents\": [], \"detail\": { \"history_summary\": [], \"installation_required\": true, \"name\": \"Daikin - 3 Star Split AC - 0.75 Ton\", \"brand\": { \"name\": \"Daikin\" }, \"category\": { \"name\": \"Split Ac\" }, \"product\": { \"name\": \"Daikin - 3 Star Split AC - 0.75 Ton\", \"sku\": \"ATC25QRV16\", \"cover\": \"https://eservify-s3-test.s3.ap-south-1.amazonaws.com/products/Dt94Qfs7X6nqrbIE2j8zAPRaaQ2n75Enin9NTDqs.png\" }, \"requests\": [], \"warrantees\": [] } }, { \"id\": 1301857, \"no\": \"PRD6013F83B8449B\", \"serial_no\": \"\", \"under_warranty\": false, \"purchase_date\": \"2021-01-29 00:00:00\", \"inititated_by\": \"Dealer\", \"active\": true, \"status\": \"Pending\", \"dealer_location_id\": 1606, \"warrantyleft\": -1, \"user\": { \"name\": \"kuldeep singh\", \"username\": \"9990304802\", \"mobile\": \"9990304802\" }, \"address\": { \"alias\": \"home\", \"contact_name\": \"kuldeep\", \"address_1\": \"noida\", \"address_2\": \"gautam budh nagar\", \"pincode\": { \"pincode\": 201301, \"city\": { \"name\": \"Gautam Buddha Nagar\", \"state\": { \"name\": \"UTTAR PRADESH\", \"country\": { \"name\": \"India\" } } } }, \"area\": { \"name\": \"Noida\" } }, \"location\": { \"id\": \"1606\", \"name\": \"Rajeev\", \"dealer\": { \"id\": \"1601\", \"name\": \"DealerTesting\" }, \"address\": { \"alias\": \"Default\", \"contact_name\": \"Rajeev\", \"address_1\": \"add1\", \"address_2\": \"add2\", \"full_address\": \"add1, add2, Noida, Gautam Buddha Nagar, UTTAR PRADESH, 201301\", \"pincode\": { \"pincode\": 201301, \"city\": { \"name\": \"Gautam Buddha Nagar\", \"state\": { \"name\": \"UTTAR PRADESH\", \"country\": { \"name\": \"India\" } } } }, \"area\": { \"name\": \"Noida\" } } }, \"documents\": [], \"detail\": { \"history_summary\": [], \"installation_required\": true, \"name\": \"Daikin - 3 Star Split AC - 0.75 Ton\", \"brand\": { \"name\": \"Daikin\" }, \"category\": { \"name\": \"Split Ac\" }, \"product\": { \"name\": \"Daikin - 3 Star Split AC - 0.75 Ton\", \"sku\": \"ATC25QRV16\", \"cover\": \"https://eservify-s3-test.s3.ap-south-1.amazonaws.com/products/Dt94Qfs7X6nqrbIE2j8zAPRaaQ2n75Enin9NTDqs.png\" }, \"requests\": [], \"warrantees\": [] } } ] } } }";
        url = url.replaceAll("\\\\", " ");
        url = url.replaceAll("\\\\", " ");
        Log.d("url___", url);
        //progressbar.show();
        String finalUrl = url;

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        ProductModel response1 = gson.fromJson(finalUrl, ProductModel.class);
        arrayList = response1.getData().getDealerProductsFilter().getFilteredOrder();
        adapter = new ProductAdapter(arrayList, getApplicationContext());
        rv_recyclerview.setAdapter(adapter);
    }

}