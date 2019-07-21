package com.iss.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iss.herome.Activity.MainActivity;
import com.iss.herome.R;


public class PickPowerFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button btnTurtle;
    private Button btnWebSling;
    private Button btnFlight;
    private Button btnLaser;
    private Button btnLighting;
    private Button btnStr;
    private Button bStory;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }


    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pick_power, container, false);
        btnTurtle = v.findViewById(R.id.btnTurtle);
        btnTurtle.setOnClickListener(this);
        btnLighting = v.findViewById(R.id.btnLight);
        btnLighting.setOnClickListener(this);
        btnFlight = v.findViewById(R.id.btnFlight);
        btnFlight.setOnClickListener(this);
        btnStr = v.findViewById(R.id.btnStr);
        btnStr.setOnClickListener(this);
        btnWebSling = v.findViewById(R.id.btnWeb);
        btnWebSling.setOnClickListener(this);
        btnLaser = v.findViewById(R.id.btnLaser);
        btnLaser.setOnClickListener(this);
        bStory = v.findViewById(R.id.backStory);

        bStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadBackStory();
            }
        });
        bStory.setEnabled(false);
        bStory.getBackground().setAlpha(128);


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
    bStory.setEnabled(true);
    bStory.getBackground().setAlpha(255);

    Button btn = (Button) view;

    int leftDrawable = 0;

    btnLaser.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
    btnTurtle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        btnStr.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);
        btnFlight.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
        btnWebSling.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb,0,0,0);
        btnLighting.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);

        if(btn == btnTurtle){
            leftDrawable = R.drawable.turtle_power;
            MainActivity.name = "Michael Angelo";
            MainActivity.primaryPower ="Turtle Power";
        }  else if(btn == btnLaser) {
            leftDrawable = R.drawable.laser_vision;
            MainActivity.name = "Cyclops";
            MainActivity.primaryPower = "Laser Beams";
        } else if(btn == btnWebSling) {
            leftDrawable = R.drawable.spiderweb;
            MainActivity.name = "Spiderman";
            MainActivity.name = "Web Slinging";
        } else if(btn == btnFlight) {
            leftDrawable = R.drawable.superman_crest;
            MainActivity.name = "Superman";
            MainActivity.primaryPower="Flight";
        } else if(btn == btnLighting) {
            leftDrawable = R.drawable.lightning;
            MainActivity.name ="Thor";
            MainActivity.primaryPower="Lightning";
        } else if(btn == btnStr) {
            leftDrawable = R.drawable.super_strength;
            MainActivity.name = "Hulk";
            MainActivity.primaryPower="Super Strength";
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected, 0);


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        void onPowerFragmentInteraction(Uri uri);
    }
}
