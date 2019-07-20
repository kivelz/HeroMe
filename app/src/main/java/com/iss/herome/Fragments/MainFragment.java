package com.iss.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iss.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnAccident;
    private Button btnGenetics;
    private Button btnBorn;
    private Button choosebtn;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btnGenetics = view.findViewById(R.id.button2);
        btnGenetics.setOnClickListener(this);
        btnAccident = view.findViewById(R.id.button1);
        btnAccident.setOnClickListener(this);
        btnBorn = view.findViewById(R.id.button3);
        btnBorn.setOnClickListener(this);
        choosebtn = view.findViewById(R.id.chooseBtn);



        choosebtn.setEnabled(false);
        choosebtn.getBackground().setAlpha(128);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
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
        choosebtn.setEnabled(true);
        choosebtn.getBackground().setAlpha(255);

        Button btn = (Button)view;
        int leftDrawable = 0;

        btnAccident.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        btnBorn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);
        btnGenetics.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);

        if(btn == btnAccident) {
            leftDrawable = R.drawable.lightning;
        }
        else if(btn == btnGenetics) {
            leftDrawable = R.drawable.atomic;
        }
        else if(btn == btnBorn) {
            leftDrawable = R.drawable.rocket;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);



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
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
