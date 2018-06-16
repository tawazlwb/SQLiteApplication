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
public class DeleteContactFragment extends Fragment {

    private EditText txt_id;
    private Button bnDelete;

    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);

        txt_id = view.findViewById(R.id.txt_delete_id);
        bnDelete = view.findViewById(R.id.bn_delete);

        bnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact();
            }
        });

        return view;
    }

    private void deleteContact(){
        String id = txt_id.getText().toString();

        ContactDbHelper dbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        dbHelper.deleteContact(Integer.parseInt(id), database);
        dbHelper.close();

        txt_id.setText("");
        Toast.makeText(getActivity(), "Contact deleted successfully...", Toast.LENGTH_SHORT).show();
    }

}
