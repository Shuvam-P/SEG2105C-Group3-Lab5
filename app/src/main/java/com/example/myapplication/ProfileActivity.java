package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void setTeamIcon(View v) {
        Intent result = new Intent();
        result.putExtra("img_id", v.getId());
        setResult(RESULT_OK, result);
        finish();
    }
}
