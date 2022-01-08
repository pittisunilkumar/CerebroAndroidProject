package com.example.cerebro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultstate extends AppCompatActivity {

    String sloc,sdeaths,sConfirmedCasesForeign,sConfirmedCasesIndian,sDischarged,sTotalConfirmed;
    TextView locc,ddeath,cconformfore,cconformindia,ddischarge,ttotalcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultstate);

        sloc = getIntent().getExtras().get("loc").toString();
        sdeaths = getIntent().getExtras().get("deaths").toString();
        sConfirmedCasesForeign =getIntent().getExtras().get("ConfirmedCasesForeign").toString();
        sConfirmedCasesIndian = getIntent().getExtras().get("ConfirmedCasesIndian").toString();
        sDischarged = getIntent().getExtras().get("Discharged").toString();
        sTotalConfirmed = getIntent().getExtras().get("TotalConfirmed").toString();

        locc = findViewById(R.id.locat);
        ddeath = findViewById(R.id.death);
        cconformfore = findViewById(R.id.conffore);
        cconformindia = findViewById(R.id.conindia);
        ddischarge = findViewById(R.id.discha);
        ttotalcon = findViewById(R.id.totalcon);

        locc.setText("LOCATION : "+sloc);
        ddeath.setText("DEATHS : "+sdeaths);
        cconformindia.setText("CONFIRMEDCASESINDIAN : "+sConfirmedCasesIndian);
        cconformfore.setText("CONFIRMEDCASESFOREIGN : "+sConfirmedCasesForeign);
        ddischarge.setText("DISCHARGED : "+sDischarged);
        ttotalcon.setText("TotalConfirmed : "+sTotalConfirmed);


    }
}