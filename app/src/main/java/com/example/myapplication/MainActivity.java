package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> avatarLauncher;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView avatar = findViewById(R.id.imgAvatar);

        // ActivityResultLauncher setup
        avatarLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        int imgId = data.getIntExtra("img_id", -1);

                        ImageView img = findViewById(R.id.imgAvatar);

                        // --- DO NOT CHANGE THE FORMAT OF THIS IF-ELSE CHAIN (as requested) ---
                        if (imgId == R.id.img0) {
                            img.setImageResource(R.drawable.flag_00);
                        } else if (imgId == R.id.img1) {
                            img.setImageResource(R.drawable.flag_01);
                        } else if (imgId == R.id.img2) {
                            img.setImageResource(R.drawable.flag_02);
                        } else if (imgId == R.id.img3) {
                            img.setImageResource(R.drawable.flag_03);
                        } else if (imgId == R.id.img4) {
                            img.setImageResource(R.drawable.flag_04);
                        } else if (imgId == R.id.img5) {
                            img.setImageResource(R.drawable.flag_05);
                        } else if (imgId == R.id.img6) {
                            img.setImageResource(R.drawable.flag_06);
                        } else if (imgId == R.id.img7) {
                            img.setImageResource(R.drawable.flag_07);
                        } else if (imgId == R.id.img8) {
                            img.setImageResource(R.drawable.flag_08);
                        }
                    }
                }
        );
    }

    // --- Open the Avatar Selection Activity ---
    public void OnSetAvatarButton(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        avatarLauncher.launch(intent);
    }

    // --- Open in Google Maps ---
    public void OnOpenInGoogleMaps(View v) {
        EditText postal = findViewById(R.id.editPostal);
        String address = postal.getText().toString();

        Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
