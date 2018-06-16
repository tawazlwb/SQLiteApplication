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

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText txt_id, txt_name, txt_email;
    private Button bnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        txt_id = view.findViewById(R.id.txt_update_id);
        txt_name = view.findViewById(R.id.txt_update_name);
        txt_email = view.findViewById(R.id.txt_update_email);
        bnUpdate = view.findViewById(R.id.bn_update);

        bnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateContact();
            }
        });

        return view;
    }

    private void updateContact(){
        String id = txt_id.getText().toString();
        String name = txt_name.getText().toString();
        String email = txt_email.getText().toString();

        ContactDbHelper dbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        dbHelper.updateContact(Integer.parseInt(id), name, email, database);
        dbHelper.close();
        Toast.makeText(getActivity(), "Contact updated...", Toast.LENGTH_SHORT).show();

        txt_id.setText("");
        txt_name.setText("");
        txt_email.setText("");
    }

}
