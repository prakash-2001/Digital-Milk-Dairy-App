package mad.mini.digitaldairyapp.admin.ui.edit_entry;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mad.mini.digitaldairyapp.Database;
import mad.mini.digitaldairyapp.R;
import mad.mini.digitaldairyapp.admin.admin;

public class edit_entry extends Fragment {

        private EditText ed_en_id, ed_en_date, ed_en_time, ed_en_ltr, ed_en_fat, ed_en_deg, ed_en_price;
        private Button ed_sb_btn;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.edit_entry, container, false);

            ed_en_id = rootView.findViewById(R.id.edit_client_id);
            ed_en_date = rootView.findViewById(R.id.edit_entry_date);
            ed_en_time = rootView.findViewById(R.id.edit_en_time);
            ed_en_ltr = rootView.findViewById(R.id.edit_milk_ltr);
            ed_en_fat = rootView.findViewById(R.id.edit_milk_fat);
            ed_en_deg = rootView.findViewById(R.id.edit_milk_degree);
            ed_en_price = rootView.findViewById(R.id.edit_market_price);
            ed_sb_btn = rootView.findViewById(R.id.edit_entry_btn);

            ed_sb_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String edit_d_id = ed_en_id.getText().toString();
                    String edit_d_date = ed_en_date.getText().toString();
                    String edit_d_time = ed_en_time.getText().toString();
                    String edit_d_ltr = ed_en_ltr.getText().toString();
                    String edit_d_fat = ed_en_fat.getText().toString();
                    String edit_d_deg = ed_en_deg.getText().toString();
                    String edit_d_price = ed_en_price.getText().toString();
                    if (edit_d_id.isEmpty() || edit_d_date.isEmpty() || edit_d_time.isEmpty() || edit_d_ltr.isEmpty() || edit_d_fat.isEmpty() || edit_d_deg.isEmpty() || edit_d_price.isEmpty()) {
                        Toast.makeText(getContext(), "Please fill in all details", Toast.LENGTH_SHORT).show();
                    }  else {
                        // Assuming Database class handles data storage correctly
                        Database db = new Database(getContext(), "digital_dairy_app", null, 1);
                        db.edit_daily_entry(edit_d_id, edit_d_date, edit_d_time, edit_d_ltr, edit_d_fat, edit_d_deg, edit_d_price);
                        Toast.makeText(getContext(), "updated inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), admin.class));
                    }
                }
            });

            return rootView;
        }

    }