package com.kamerlin.leon.utils.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

/* Wrapper to show a managed date picker */
public class DatePickerFragmentDialog extends DialogFragment {
    public static final String TAG = DatePickerFragmentDialog.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it

        DatePickerDialog.OnDateSetListener listener = (getActivity() instanceof DatePickerDialog.OnDateSetListener) ? (DatePickerDialog.OnDateSetListener) getActivity() : null;
        return new DatePickerDialog(getActivity(), listener, year, month, day);
    }

    public static com.wdullaer.materialdatetimepicker.date.DatePickerDialog Material() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        com.wdullaer.materialdatetimepicker.date.DatePickerDialog dialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(null, year, month, day);
        return dialog;
    }

    public static com.wdullaer.materialdatetimepicker.date.DatePickerDialog Material(com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener listener) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(listener, year, month, day);
    }
}
