package com.example.dota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HalamanDua extends AppCompatActivity {

    Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_dua);

        
        regis = (Button) findViewById(R.id.regis);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {regisDiklik();}
        });
    }
    public void regisDiklik () {

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        SharedPreferences.Editor edit = SP.edit();

        String isianUser = ((EditText) findViewById(R.id.user)).getText().toString();
        String isianPswd1 = ((EditText) findViewById(R.id.pswd1)).getText().toString();
        String isianPswd2 = ((EditText) findViewById(R.id.pswd2)).getText().toString();

        if(!isianPswd1.equals(isianPswd2)) {
            Toast.makeText(this.getBaseContext(),"Password tidak sama", Toast.LENGTH_LONG).show();
            return;
        }

        edit.putString("user", isianUser);
        edit.putString("password", isianPswd1);

        edit.commit();
        Intent MainActivity=new Intent(this, MainActivity.class);
        startActivity(MainActivity);
        Toast.makeText (this.getBaseContext(), "Anda Berhasil Registrasi Akun",Toast.LENGTH_SHORT).show();

    }
}
