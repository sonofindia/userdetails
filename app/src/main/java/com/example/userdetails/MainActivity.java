package com.example.userdetails;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    Button mButton;
    EditText mEdit;
    TextView mText;
    Spinner sp;
    RadioGroup rb;
    String[] country = { "Andhra Pradesh","Telangana","MadhyaPradesh","Gujarat","Goa","TamilNadu","Karnataka","Delhi" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                String s="";
                mEdit = (EditText) findViewById(R.id.editText1);
                s+="Hello " + mEdit.getText().toString() + "!\n";
                mEdit = (EditText) findViewById(R.id.editText3);
                s+="Address "+mEdit.getText().toString()+"\n";
                rb = (RadioGroup) findViewById(R.id.r);
                int d = rb.getCheckedRadioButtonId();
                RadioButton x;
                x = (RadioButton)findViewById(d);
                s+="Gender "+x.getText().toString()+"\n";
                mEdit = (EditText) findViewById(R.id.editTextDate2);
                s+="Date of birth "+mEdit.getText().toString()+"\n";
                mEdit = (EditText) findViewById(R.id.editText4);
                s+="Age "+mEdit.getText().toString()+"\n";
                sp = (Spinner) findViewById(R.id.spinner);
                s+="State "+sp.getSelectedItem().toString()+"\n";
                mText = (TextView) findViewById(R.id.textView1);
                mText.setText(s);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position],
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
    }
}