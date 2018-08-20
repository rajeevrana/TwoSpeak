package com.twospeak.twospeak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class MainActivity2 extends Fragment {
    View view;
    TutorAdapter tutor;
    ListView tutorlist;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.content_nav_drawer,container,false);

        viewPager =  view.findViewById(R.id.viewpager);
        tutorlist= (ListView) view.findViewById(R.id.tutor_list);
        tutor= new TutorAdapter(getContext());
        tutorlist.setAdapter(tutor);

//textcolor  285bae
        //orange color fb8a48
//afafaf
        return view;
    }

}
/*
<view
        android:layout_width="fill_parent"
                android:layout_height="1dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:background="#afafaf"
                android:layout_below="@+id/rel"
                />*/
