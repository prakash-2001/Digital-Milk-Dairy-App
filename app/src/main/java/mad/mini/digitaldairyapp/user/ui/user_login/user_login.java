package mad.mini.digitaldairyapp.user.ui.user_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mad.mini.digitaldairyapp.Database;
import mad.mini.digitaldairyapp.R;
import mad.mini.digitaldairyapp.admin.admin;
import mad.mini.digitaldairyapp.admin.ui.admin_login.admin_login;
import mad.mini.digitaldairyapp.user.user;

public class user_login extends AppCompatActivity {

    EditText ur_lg_id, ur_lg_password;
    Button ur_lg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        ur_lg_id = findViewById(R.id.user_lg_id);
        ur_lg_password = findViewById(R.id.user_lg_password);
        ur_lg_btn = findViewById(R.id.user_lg_btn);

        ur_lg_btn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                String user_id=ur_lg_id.getText().toString();
                String user_password=ur_lg_password.getText().toString();
                Database db = new Database(getApplicationContext(),"digital_dairy_app",null,1);
                if (user_id.length() == 0 || user_password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if(db.user_login(user_id,user_password)==1){
                        Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user_id",user_id);
                        editor.apply();
                        Intent intent=new Intent(user_login.this, user_login.class);
                        intent.putExtra("name",user_id);
                        intent.putExtra("password",user_password);
                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });
    }
}