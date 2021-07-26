package com.tamilandroo.womensguard.Helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.tamilandroo.womensguard.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListAdapter extends BaseAdapter {
    Activity activity;
    private List<Contact> theList = new ArrayList<Contact>();
    private static LayoutInflater inflater = null;

    public ContactListAdapter(final Activity a, List<Contact> theList) {
        activity = a;
        this.theList = theList;
        inflater = (LayoutInflater) a
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return theList.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.contact_list_layout, null);

        TextView letter = v.findViewById(R.id.letter);
        TextView details = v.findViewById(R.id.contact_details);
        ImageView call = v.findViewById(R.id.call);
        ImageView delete = v.findViewById(R.id.delete);

        details.setText(theList.get(position).getName() + "\n" + theList.get(position).getPhoneNumber());
        letter.setText(theList.get(position).getName().substring(0, 1).toUpperCase());


        call.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (activity.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    activity.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    Intent phone_intent = new Intent(Intent.ACTION_CALL);
                    phone_intent.setData(Uri.parse("tel:" + theList.get(position).getPhoneNumber()));
                    activity.startActivity(phone_intent);
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDB = new DatabaseHelper(activity);
                myDB.deleteContact(theList.get(position));
                activity.recreate();
            }
        });

        return v;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}