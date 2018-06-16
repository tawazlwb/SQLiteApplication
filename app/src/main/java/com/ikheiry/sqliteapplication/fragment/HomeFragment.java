package com.ikheiry.sqliteapplication.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ikheiry.sqliteapplication.R;


public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button bnAdd, bnView, bnDelete, bnUpdate;
    private OnDbOPListener dbOPListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOPListener{
        public void onDbOpPerfomed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bnAdd = view.findViewById(R.id.add_contact);
        bnAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_contact:
                dbOPListener.onDbOpPerfomed(0);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            dbOPListener = (OnDbOPListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement the interface method...");
        }

    }
}
