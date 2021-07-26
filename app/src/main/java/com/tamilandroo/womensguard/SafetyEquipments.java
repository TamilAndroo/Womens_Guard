package com.tamilandroo.womensguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class SafetyEquipments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_equipments);

    }

    public void click1(View v){
        String l="https://www.flipkart.com/search?q=pepper+spray&sid=hlc%2Ciwt%2Cmie&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&as-pos=1&as-type=RECENT&suggestionId=pepper+spray%7CPepper+Safety+Device&requestId=0521eaad-0d30-4e8b-9e43-44b5c6c18939&as-searchtext=pepper";
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(l));
        startActivity(intent);
    }
    public void click2(View v){
        String l="https://www.amazon.com/VIPERTEK-VTS-989-Billion-Rechargeable-Flashlight/dp/B01FHDZGGM/ref=sr_1_2?_encoding=UTF8&c=ts&dchild=1&keywords=Stun+Guns&qid=1626484780&s=hunting-fishing&sr=1-2&ts_id=7824770011";
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(l));
        startActivity(intent);
    }
    public void click3(View v){
        String l="https://www.flipkart.com/knife-india-executive-defense-pocket/p/itme9qqbwhq7ft6w";
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(l));
        startActivity(intent);
    }
    public void click4(View v){
        String l="https://www.flipkart.com/search?q=safety+rod&sid=abc%2Cfvf%2Cyc2&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_10_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_10_na_na_na&as-pos=1&as-type=RECENT&suggestionId=safety+rod%7CCamming+Devices&requestId=d19f3041-86a8-4629-8132-2b353dfac5ac&as-searchtext=safety%20rod";
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(l));
        startActivity(intent);
    }
}