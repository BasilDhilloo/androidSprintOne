package com.example.covidwatch.UsersView.InitialInterview.TestingTreatment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.covidwatch.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TreatmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TreatmentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    AutoCompleteTextView edtsoughtmedicalcare;
    AutoCompleteTextView edthospitalization;
    MultiAutoCompleteTextView edtReceivedmedicalcare;

    final static String[] item_YN = new String[]{"Yes", "No"};
    final static String[] item_Mc = new String[]{"Monoclonal antibody infusion",
            "Convalescent plasma",
            "Remdesivir","--None--","Other"
    };
    public TreatmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TreatmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TreatmentFragment newInstance(String param1, String param2) {
        TreatmentFragment fragment = new TreatmentFragment();
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
        View v = inflater.inflate(R.layout.fragment_treatment, container, false);
        edtsoughtmedicalcare = v.findViewById( R.id.edtsoughtmedicalcare );
        ArrayAdapter<String> adapterYn = new ArrayAdapter( requireContext(), R.layout.list_item, item_YN );
        //Yesno.setTokenizer( new MultiAutoCompleteTextView.CommaTokenizer() );
        edtsoughtmedicalcare.setAdapter( adapterYn );

        edtReceivedmedicalcare = v.findViewById( R.id.edtReceivedmedicalcare );
        ArrayAdapter<String> adapter_Mc = new ArrayAdapter( requireContext(), R.layout.list_item, item_Mc );
        edtReceivedmedicalcare.setTokenizer( new MultiAutoCompleteTextView.CommaTokenizer() );
        edtReceivedmedicalcare.setAdapter( adapter_Mc );

        edthospitalization = v.findViewById( R.id.edthospitalization );
        ArrayAdapter<String> adapter_Yn = new ArrayAdapter( requireContext(), R.layout.list_item, item_YN );
        //Yesno.setTokenizer( new MultiAutoCompleteTextView.CommaTokenizer() );
        edthospitalization.setAdapter( adapter_Yn );

        return v;
    }
}