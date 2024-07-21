package mad.mini.digitaldairyapp.admin.ui.user_signup;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import mad.mini.digitaldairyapp.Database;
import mad.mini.digitaldairyapp.R;
import mad.mini.digitaldairyapp.admin.admin;

public class user_signup extends Fragment {

    private EditText ur_id, ur_name, ur_email, ur_phoneno, ur_passwd;
    private Button ur_sp_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_signup, container, false);

        ur_id = rootView.findViewById(R.id.user_sp_id);
        ur_name = rootView.findViewById(R.id.user_sp_name);
        ur_email = rootView.findViewById(R.id.user_sp_email);
        ur_phoneno = rootView.findViewById(R.id.user_sp_phone);
        ur_passwd = rootView.findViewById(R.id.user_sp_password);
        ur_sp_btn = rootView.findViewById(R.id.user_sp_btn);

        ur_sp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = ur_id.getText().toString();
                String user_name = ur_name.getText().toString();
                String user_email = ur_email.getText().toString();
                String user_phoneno = ur_phoneno.getText().toString();
                String user_password = ur_passwd.getText().toString();

                if (user_id.isEmpty() || user_name.isEmpty() || user_email.isEmpty() || user_phoneno.isEmpty() || user_password.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(user_email)) {
                    Toast.makeText(getContext(), "Invalid email format", Toast.LENGTH_SHORT).show();
                } else if (!isValid(user_password)) {
                    Toast.makeText(getContext(), "Password must contain at least 8 characters", Toast.LENGTH_SHORT).show();
                } else {
                    // Assuming Database class handles data storage correctly
                    Database db = new Database(getContext(), "digital_dairy_app", null, 1);
                    db.user_signup(user_id, user_name, user_email, user_phoneno, user_password);
                    Toast.makeText(getContext(), "Record inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), admin.class));
                }
            }
        });

        return rootView;
    }

    private static boolean isValid(String password) {
        return password.length() >= 8 && password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()\\-_=+\\[\\]{}|:;',./<>?].*");
    }

    private static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}