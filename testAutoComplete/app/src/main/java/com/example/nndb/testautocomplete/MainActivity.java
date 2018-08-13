package com.example.nndb.testautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;
    AutoCompleteTextView autoTinhThanh;
    Button btnOK;
    TextView tvThongTin;
    String []arrTinhThanhVN;
    ArrayAdapter<String>adapterTinhThanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        txtTen=findViewById(R.id.txtTen);
        autoTinhThanh=findViewById(R.id.autoTinhThanh);
        tvThongTin=findViewById(R.id.tvThongTin);
        btnOK=findViewById(R.id.btnOK);
        arrTinhThanhVN=getResources().getStringArray(R.array.arrTinhThanh);
        adapterTinhThanh=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTinhThanhVN
        );
        autoTinhThanh.setAdapter(adapterTinhThanh);
    }

    private void addEvents() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=txtTen.getText().toString()+"\n"+autoTinhThanh.getText().toString();
                tvThongTin.setText(s);
            }
        });
    }
}
