package com.ikheiry.sqliteapplication.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ikheiry.sqliteapplication.R;
import com.ikheiry.sqliteapplication.db.ContactContract;
import com.ikheiry.sqliteapplication.db.ContactDbHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactFragment extends Fragment {

    private TextView display;

    public ReadContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contact, container, false);

        display = view.findViewById(R.id.txt_display);
        readContact();
        return view;
    }

    private void readContact(){
        ContactDbHelper dbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        String info = "";
        Cursor cursor = dbHelper.readContact(database);
        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));

            info += "\n\nId : " + id + "\nName : " + name + "\nEmail : " + email;
        }

        display.setText(info);
        dbHelper.close();
    }

}
