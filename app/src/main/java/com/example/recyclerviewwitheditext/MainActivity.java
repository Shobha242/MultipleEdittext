package com.example.recyclerviewwitheditext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerviewwitheditext.adapters.LIstAdapter;
import com.example.recyclerviewwitheditext.model.ListModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_requestProblems;
    private LIstAdapter paymentAdapter;
    LinearLayout submitLL;
    private ArrayList<ListModel> arrayList = new ArrayList<>();
    private ArrayList<ListModel> arrayList2 = new ArrayList<>();
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_requestProblems = findViewById(R.id.rv_requestProblems);
        submitLL = findViewById(R.id.submitLL);
        paymentAdapter = new LIstAdapter(arrayList, getApplicationContext());
        paymentList(arrayList);
        rv_requestProblems.setAdapter(paymentAdapter);

        submitLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] allllistStr = paymentAdapter.getAlllistStr();
                String listvalue = Arrays.toString(allllistStr);
                listvalue = listvalue.replaceAll("\\[", "").replaceAll("\\]", "");
                listvalue = listvalue.replace(",", "~").replaceAll("", "");
                Log.d("listvalue__", listvalue);
                String[] allllistStr1 = paymentAdapter.getAlllistStr1();
                StringBuffer result = new StringBuffer();
                String pos = "";
                try {
                    for (int i = 0; i < arrayList.size(); i++) {
                        View view = rv_requestProblems.getChildAt(i);
                        EditText editText = view.findViewById(R.id.ET_Modelnumber);
                        String value = editText.getText().toString().trim();
                        if (value.equals("")) {
                            Toast.makeText(MainActivity.this, "Please enter  " + arrayList.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            Toast.makeText(MainActivity.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void paymentList(ArrayList<ListModel> arrayList) {
        arrayList.clear();
        for (int i = 1; i < 6; i++) {
            ListModel model = new ListModel();
            if (i == 1) {
                model.setTitle("first title");
            } else if (i == 2) {
                model.setTitle("second title");
            } else if (i == 3) {

                model.setTitle("third title");
            } else if (i == 4) {
                model.setTitle("fourth title");

            } else if (i == 5) {

                model.setTitle("fifth title");
            } else if (i == 6) {

                model.setTitle("six title");
            }
            arrayList.add(model);
        }
    }

}