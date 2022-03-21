package com.example.covidwatch.UsersView.InitialInterview.Demographic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.covidwatch.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CaseInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class CaseInformationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    String mParam1, mParam2;
    ImageButton calDeceasedDate;
    String selectedDate;
    public static final int REQUEST_CODE = 11;

    public CaseInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CaseInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CaseInformationFragment newInstance(String param1, String param2) {
        CaseInformationFragment fragment = new CaseInformationFragment();
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
        return inflater.inflate(R.layout.fragment_case_information, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //UI reference of textView
        final AutoCompleteTextView autoConsent = view.findViewById(R.id.autoConsent);
        final AutoCompleteTextView autoReinfected = view.findViewById(R.id.autoReinfected);
        final AutoCompleteTextView autoDeceased = view.findViewById(R.id.autoDeceased);
        final AutoCompleteTextView autoRace = view.findViewById(R.id.autoRace);
        final AutoCompleteTextView autoPrimaryLanguage = view.findViewById(R.id.autoPrimaryLanguage);

        //Create adapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.arrYesNo));
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.arrRace));
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.arrPrimaryLanguage));

        //Set adapter
        autoConsent.setAdapter(adapter1);
        autoReinfected.setAdapter(adapter1);
        autoDeceased.setAdapter(adapter1);
        autoRace.setAdapter(adapter2);
        autoPrimaryLanguage.setAdapter(adapter3);

        calDeceasedDate = view.findViewById(R.id.calDeceasedDate);

        calDeceasedDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DeceasedDate");

            }
        });
    }

}