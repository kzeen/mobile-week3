package com.example.mobile_week3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgCampus;
    private RadioButton rbByblos;
    private RadioButton rbBeirut;
    private RadioButton rbUnspecified;
    private CheckBox cbSlides;
    private CheckBox cbClass;
    private CheckBox cbAssignment;
    private Switch swPreview;
    private Spinner spTopic;
    private RatingBar rbRating;
    private Button btSubmit;
    private TextView tvPreview;
    private Feedback feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        feedback = new Feedback();
        initializeViews();
        initializeListeners();
    }

    private void initializeViews() {
        rgCampus = findViewById(R.id.rg_campusrg);
        rbByblos = findViewById(R.id.rb_byblos);
        rbBeirut = findViewById(R.id.rb_beirut);
        rbUnspecified = findViewById(R.id.rb_unspecified);
        cbSlides = findViewById(R.id.cb_lecture);
        cbClass = findViewById(R.id.cb_classwork);
        cbAssignment = findViewById(R.id.cb_assignment);
        swPreview = findViewById(R.id.sw_turnon);
        spTopic = findViewById(R.id.sp_weeks);
        rbRating = findViewById(R.id.rt_rating);
        btSubmit = findViewById(R.id.bt_submit);
        tvPreview = findViewById(R.id.tv_preview_area);
    }

    private void initializeListeners() {
        rgCampus.setOnCheckedChangeListener((grp, checkedRadioID) -> {
            if (checkedRadioID == R.id.rb_byblos) {
                feedback.setCampus("Byblos");
            } else if (checkedRadioID == R.id.rb_beirut) {
                feedback.setCampus("Beirut");
            } else if (checkedRadioID == R.id.rb_unspecified) {
                feedback.setCampus("Unspecified");
            }
            refreshPreview();
        });

        cbSlides.setOnCheckedChangeListener((g, checked) -> {
            if (checked) {
                feedback.setSlideFeature("Slides");
            } else {
                feedback.setSlideFeature("");
            }
            refreshPreview();
        });

        cbClass.setOnCheckedChangeListener((g, checked) -> {
            if (checked) {
                feedback.setClassFeature("Class");
            } else {
                feedback.setClassFeature("");
            }
            refreshPreview();
        });

        cbAssignment.setOnCheckedChangeListener((g, checked) -> {
            if (checked) {
                feedback.setAssignmentFeature("Assignment");
            } else {
                feedback.setAssignmentFeature("");
            }
            refreshPreview();
        });

        //        Spinner cannot be done with lambda expression because its interface has 2 methods
        spTopic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTopic = spTopic.getItemAtPosition(position).toString();
                feedback.setTopic(selectedTopic);
                refreshPreview();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rbRating.setOnRatingBarChangeListener((a, rating, b) -> {
            feedback.setRating(rating);
            refreshPreview();
        });
    }

    private void refreshPreview() {
        if (swPreview.isChecked()) {
            tvPreview.setText(feedback.toString());
        } else {
            tvPreview.setText("");
        }
    }
}