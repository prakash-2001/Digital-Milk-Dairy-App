package mad.mini.digitaldairyapp.admin.ui.ad_signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mad.mini.digitaldairyapp.Database;
import mad.mini.digitaldairyapp.R;
import mad.mini.digitaldairyapp.admin.admin;

public class admin_signup extends Fragment {

    private EditText ad_id, ad_name, ad_email, ad_ph_no, ad_passwd;
    private Button ad_sp_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_signup, container, false);

        ad_id = rootView.findViewById(R.id.admin_id);
        ad_name = rootView.findViewById(R.id.admin_name);
        ad_email = rootView.findViewById(R.id.ad_sp_email);
        ad_ph_no = rootView.findViewById(R.id.admin_phone);
        ad_passwd = rootView.findViewById(R.id.admin_sp_password);
        ad_sp_btn = rootView.findViewById(R.id.admin_sp_btn);

        ad_sp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String admin_id = ad_id.getText().toString();
                String admin_name = ad_name.getText().toString();
                String admin_email = ad_email.getText().toString();
                String admin_phoneno = ad_ph_no.getText().toString();
                String admin_password = ad_passwd.getText().toString();

                if (admin_id.isEmpty() || admin_name.isEmpty() || admin_email.isEmpty() || admin_phoneno.isEmpty() || admin_password.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(admin_email)) {
                    Toast.makeText(getContext(), "Invalid email format", Toast.LENGTH_SHORT).show();
                } else if (!isValid(admin_password)) {
                    Toast.makeText(getContext(), "Password must contain at least 8 characters", Toast.LENGTH_SHORT).show();
                } else {
                    // Assuming Database class handles data storage correctly
                    Database db = new Database(getContext(), "digital_dairy_app", null, 1);
                    db.admin_signup(admin_id, admin_name, admin_email, admin_phoneno, admin_password);
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
