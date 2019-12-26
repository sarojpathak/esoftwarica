package com.saroj.esoftwarica.userInterface.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saroj.esoftwarica.ContactActivity;
import com.saroj.esoftwarica.Contacts;
import com.saroj.esoftwarica.MainActivity;
import com.saroj.esoftwarica.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView=root.findViewById(R.id.recyclerview);

        List<Contacts> contactsList=new ArrayList<>();

        if(MainActivity.contact.isEmpty()){
            MainActivity.contact.add(new Contacts("Saroj Pathak","Kathmandu","male",22));
            MainActivity.contact.add(new Contacts("Samir Pathak","Dhading","male",24));
            MainActivity.contact.add(new Contacts("Sajana Pathak","Nepal","female",17));
            ContactActivity contactActivity=new ContactActivity(getContext(),MainActivity.contact);
            recyclerView.setAdapter(contactActivity);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }
        else {

            ContactActivity contactActivity=new ContactActivity(getContext(),MainActivity.contact);
            recyclerView.setAdapter(contactActivity);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }




        return root;
    }
}