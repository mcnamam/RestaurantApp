package com.osu.billiondollarapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
		 View view = inflater.inflate(R.layout.profile_content, container, false);
		 Button signIn = (Button)view.findViewById(R.id.signin);
		 signIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(getActivity(),Sign_In.class);
				startActivity(intent);		
			}
		 });
		 
		 return view;
	    }

}
