package com.ikheiry.sqliteapplication.fragment;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ikheiry.sqliteapplication.R;
import com.ikheiry.sqliteapplication.db.ContactDbHelper;

public class AddContactFragment extends Fragment {

    private EditText txt_id, txt_name, txt_email;
    private Button bnSave;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        txt_id = view.findViewById(R.id.txt_contact_id);
        txt_name = view.findViewById(R.id.txt_contact_name);
        txt_email = view.findViewById(R.id.txt_contact_email);
        bnSave = view.findViewById(R.id.bn_save);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txt_id.getText().toString();
                String name = txt_name.getText().toString();
                String email = txt_email.getText().toString();

                ContactDbHelper dbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                dbHelper.addContact(Integer.parseInt(id), name, email, database);

                txt_id.setText("");
                txt_name.setText("");
                txt_email.setText("");
                Toast.makeText(getActivity(), "Contact Saved Successfully...", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
