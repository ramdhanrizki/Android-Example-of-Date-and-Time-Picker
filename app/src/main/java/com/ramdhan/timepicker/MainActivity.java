package com.ramdhan.timepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    EditText inputDate,inputTime;
    private int mYear,mMounth,mDay,mHour,mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = (Button)findViewById(R.id.btn_date);
        btnTimePicker = (Button)findViewById(R.id.btn_time);
        inputDate = (EditText)findViewById(R.id.input_date);
        inputTime = (EditText)findViewById(R.id.input_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnDatePicker){
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMounth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    inputDate.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                }
            },mYear,mMounth,mDay);
            datePickerDialog.show();
        }

        if(v==btnTimePicker){
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    inputTime.setText(hourOfDay+":"+minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();
        }
    }
}
