package com.example.prattoy.student;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class campus extends Fragment {

    public ListView listView;
    public String[] Bus;
    public String[] TimeCamp;
    int[] logo = {R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app,
            R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app, R.drawable.logo_app};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_campus, null);


        Bus = getResources().getStringArray(R.array.buses);
        TimeCamp = getResources().getStringArray(R.array.timecampus);
        listView = (ListView) view.findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        return view;
    }




        class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Bus.length;
        }

        @Override
        public Object getItem(int i) {

            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.reg, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView1 = (TextView) view.findViewById(R.id.busname);
            TextView textView2 = (TextView) view.findViewById(R.id.campustime);

            imageView.setImageResource(logo[i]);
            textView1.setText(Bus[i]);
            textView2.setText(TimeCamp[i]);

            return view;
        }
    }
}