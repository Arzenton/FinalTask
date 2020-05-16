package com.example.intern_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static android.content.pm.PackageManager.*;

public class Main extends AppCompatActivity {
    Button mSms, mPhone, mInsta, mFb, mBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPhone = findViewById(R.id.phoneBtn);
        mSms = findViewById(R.id.button3);
        mInsta = findViewById(R.id.button4);
        mFb = findViewById(R.id.button5);
        mBrowse = findViewById(R.id.button6);

        mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7008683249"));
                startActivity(intent);
            }
        });

        mSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((Intent.ACTION_VIEW));
                intent.setData(Uri.parse("sms:"));
                startActivity(intent);
            }
        });

        mInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context ctx=Main.this; // or you can replace **'this'** with your **ActivityName.this**
                try {
                    Intent i = ctx.getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                    ctx.startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(Main.this,"App Not installed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context ctx=Main.this; // or you can replace **'this'** with your **ActivityName.this**
                try {
                    Intent i = ctx.getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                    ctx.startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(Main.this,"App Not installed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spectrumcet.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
