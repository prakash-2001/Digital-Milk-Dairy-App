package mad.mini.digitaldairyapp.admin.ui.admin_login;

import static android.view.View.OnClickListener;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mad.mini.digitaldairyapp.Database;
import mad.mini.digitaldairyapp.R;
import mad.mini.digitaldairyapp.admin.admin;

public  class admin_login extends AppCompatActivity {
    EditText ad_lg_id, ad_lg_password;
    Button ad_lg_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        ad_lg_id = findViewById(R.id.admin_lg_id);
        ad_lg_password = findViewById(R.id.admin_lg_password);
        ad_lg_btn = findViewById(R.id.admin_lg_btn);

        ad_lg_btn.setOnClickListener(new OnClickListener()  {
            @Override
            public void onClick(View view) {
                String admin_id=ad_lg_id.getText().toString();
                String admin_password=ad_lg_password.getText().toString();
                Database db = new Database(getApplicationContext(),"digital_dairy_app",null,1);
                if (admin_id.length() == 0 || admin_password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if(db.login(admin_id,admin_password)==1){
                        Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("admin_id",admin_id);
                        editor.apply();
                        startActivity(new Intent(admin_login.this, admin.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

    }
}