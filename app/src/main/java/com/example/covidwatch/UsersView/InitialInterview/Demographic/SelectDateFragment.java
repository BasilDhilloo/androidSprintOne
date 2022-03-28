package com.example.covidwatch.UsersView.InitialInterview.Demographic;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.example.covidwatch.R;

import java.util.Calendar;

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{

    public Boolean getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(Boolean deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public Boolean deceasedDate;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }

    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        populateSetDeceasedDate(yy, mm + 1, dd);

    }
    public void populateSetDeceasedDate(int year, int month, int day) {

        try {
                EditText edtDeceasedDate = getActivity().findViewById( R.id.edtDeceasedDate );
                edtDeceasedDate.setText( month + "/" + day + "/" + year );

                EditText edtfirstfeelDate = getActivity().findViewById( R.id.edtDateFirstFellSick );
                edtfirstfeelDate.setText( month + "/" + day + "/" + year );

            EditText edtAdmissionDate = getActivity().findViewById(R.id.edtAdmissionDate);
            edtDeceasedDate.setText(month + "/" + day + "/" + year);

            EditText edtDischargedDate = getActivity().findViewById(R.id.edtDischargeDate);
            edtDeceasedDate.setText(month + "/" + day + "/" + year);
            }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void populateSetSickDate(int year, int month, int day) {
        EditText edtDeceasedDate = getActivity().findViewById(R.id.edtDateFirstFellSick);
        edtDeceasedDate.setText(month + "/" + day + "/" + year);
    }
    public void populateSetAdmissionDate(int year, int month, int day) {
        EditText edtDeceasedDate = getActivity().findViewById(R.id.edtAdmissionDate);
        edtDeceasedDate.setText(month + "/" + day + "/" + year);
    }
    public void populateSetDischargeDate(int year, int month, int day) {
        EditText edtDeceasedDate = getActivity().findViewById(R.id.edtDischargeDate);
        edtDeceasedDate.setText(month + "/" + day + "/" + year);
    }
}
