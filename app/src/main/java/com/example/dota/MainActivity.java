package com.example.dota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button regis1;
    TextView user;
    TextView pswd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (TextView) findViewById(R.id. user);
        pswd = (TextView) findViewById(R.id. pswd);

        login = (Button) findViewById(R.id. login );
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loginDiklik();
            }
        });
        regis1 = (Button) findViewById(R.id. regis1 );
        regis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {RegisDiklik();
            }
        });
    }

    public void loginDiklik() {
        String ID , password ;
        ID = user.getText().toString();
        password = pswd.getText().toString();

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String isianUser= SP.getString("user", "admin");

        String isianPswd= SP.getString("password","admin");

        if (ID .equals(isianUser) && password .equals(isianPswd)){
            Intent halamanakhir=new Intent(this, Halamanakhir.class);
            Bundle data = new Bundle();
            data.putString("USER",ID);
            halamanakhir.putExtras(data) ;
            startActivity(halamanakhir);
        }
        else{
            Toast.makeText(this.getBaseContext(), "Maaf, User atau Password yang kamu masukan salah yahh",Toast.LENGTH_SHORT).show();
        }

    }

    public void RegisDiklik() {
        Intent Halamandua=new Intent (getApplicationContext(), HalamanDua.class);
        startActivity(Halamandua);


    }

}


