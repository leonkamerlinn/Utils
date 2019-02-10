package com.kamerlin.leon.utils.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

import androidx.fragment.app.DialogFragment;

public class TimePickerFragmentDialog extends DialogFragment {
    public static final String TAG = TimePickerFragmentDialog.class.getSimpleName();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), null, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public static com.wdullaer.materialdatetimepicker.time.TimePickerDialog Material() {
        return com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance(null, false);
    }

    public static com.wdullaer.materialdatetimepicker.time.TimePickerDialog Material(com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener listener) {
        return com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance(listener, false);
    }
}