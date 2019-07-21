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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */

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
            }
        });
        bStory.setEnabled(false);
        bStory.getBackground().setAlpha(128);


        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPowerFragmentInteraction(uri);
        }
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
        }  else if(btn == btnLaser) {
            leftDrawable = R.drawable.laser_vision;
        } else if(btn == btnWebSling) {
            leftDrawable = R.drawable.spiderweb;
        } else if(btn == btnFlight) {
            leftDrawable = R.drawable.superman_crest;
        } else if(btn == btnLighting) {
            leftDrawable = R.drawable.lightning;
        } else if(btn == btnStr) {
            leftDrawable = R.drawable.lightning;
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
        // TODO: Update argument type and name
        void onPowerFragmentInteraction(Uri uri);
    }
}
