package mad.mini.digitaldairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mad.mini.digitaldairyapp.admin.admin;
import mad.mini.digitaldairyapp.admin.ui.admin_login.admin_login;
import mad.mini.digitaldairyapp.user.ui.user_login.user_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ad_lg_button = findViewById(R.id.admin_login);
        Button ur_lg_button =findViewById(R.id.user_login);
        TextView ad_signup=findViewById(R.id.main_heading);


        ad_lg_button.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, admin_login.class);
            startActivity(intent);
        });
        ur_lg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, user_login.class);
                startActivity(intent);
            }
        });
        ad_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, admin.class));
            }

        });

    }
}