package com.tamilandroo.womensguard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tamilandroo.womensguard.Helper.Contact;
import com.tamilandroo.womensguard.Helper.ContactListAdapter;
import com.tamilandroo.womensguard.Helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddRelative extends AppCompatActivity {

    DatabaseHelper myDB;
    ContactListAdapter adapter;

    ListView listView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relative);

        myDB = new DatabaseHelper(this);
        fab = findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.listView);

        List<Contact> theList = myDB.getAllContacts();

        adapter = new ContactListAdapter(this, theList);
        listView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (theList.size() == 5) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddRelative.this);
                    builder.setCancelable(false);
                    builder.setTitle("Warning!")
                            .setMessage("You can add only 5 important contacts. You can delete unwanted contact then Try again!")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.create().show();
                } else {
                    final Dialog dialog = new Dialog(AddRelative.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.add_contact_dialog);

                    Button add = (Button) dialog.findViewById(R.id.btnAdd);
                    Button cancel = (Button) dialog.findViewById(R.id.btnCancel);

                    final EditText name = dialog.findViewById(R.id.name);
                    final EditText num = dialog.findViewById(R.id.number);

                    add.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String newEntry1 = name.getText().toString();
                            String newEntry2 = num.getText().toString();
                            if (name.length() != 0 && num.length() >= 10 && !Pattern.matches("[a-zA-Z]+", newEntry2)) {
                                AddData(newEntry1, newEntry2);
                                name.setText("");
                                num.setText("");
                                dialog.dismiss();
                            } else {
                                Toast.makeText(AddRelative.this, "Enter correct values", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            }
        });
    }

    public void AddData(String newEntry1, String newEntry2) {
        myDB.addContact(new Contact(newEntry1, newEntry2));
        Toast.makeText(this, "Contact Added", Toast.LENGTH_LONG).show();
        AddRelative.this.recreate();
    }

}

