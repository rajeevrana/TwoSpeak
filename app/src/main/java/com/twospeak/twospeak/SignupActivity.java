package com.twospeak.twospeak;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {

    ListView list_item;
    AlertDialog alertDialog;
    String language_sel,chkitems1;
    CheckBox chk_one,chk_two;
   // ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        chk_one=(CheckBox)findViewById(R.id.checkBox1);
        chk_two=(CheckBox)findViewById(R.id.checkBox2);


        arrayAdapterListView();


    }

    private void arrayAdapterListView() {


        AlertDialog.Builder builder;

        LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.activity_list_view,
                null);
        TextView dialog_header = (TextView) layout
                .findViewById(R.id.dialog_header);

        ListView listView = (ListView)layout.findViewById(R.id.listViewExample);

        List<String> dataList = new ArrayList<String>();
        dataList.add("Java");
        dataList.add("Android");
        dataList.add("JavaEE");
        dataList.add("JSP");
        dataList.add("JDBC");

        dialog_header.setText("Select The Language You Want To Learn ");
        builder = new AlertDialog.Builder(SignupActivity.this);
        builder.setView(layout);
        alertDialog = builder.create();
        alertDialog.show();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                Toast.makeText(SignupActivity.this, "You clicked " + clickItemObj.toString(), Toast.LENGTH_SHORT).show();
                language_sel=clickItemObj.toString();
                alertDialog.dismiss();
            }
        });


        chk_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    Toast.makeText(SignupActivity.this, "You clicked " + chk_two.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    // Do your coding
                    Toast.makeText(SignupActivity.this, "You unclicked " + chk_two.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        chk_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    Toast.makeText(SignupActivity.this, "You clicked " + chk_one.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    // Do your coding
                    Toast.makeText(SignupActivity.this, "You unclicked " + chk_one.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
