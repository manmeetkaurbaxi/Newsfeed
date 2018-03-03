package tech.terx.newsfeed;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import tech.terx.newsfeed.m_Firebase.FirebaseHelper;
import tech.terx.newsfeed.m_Model.Spacecraft;
import tech.terx.newsfeed.m_UI.CustomAdapter;

public class MainActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView lv;

    EditText headEditTxt, subheadTxt, detailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.lv);

        //INITIALIZE FIREBASE DB
        db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cgctest-d0a5b.firebaseio.com/Spacecraft");
        helper = new FirebaseHelper(db);

        //ADAPTER
        adapter = new CustomAdapter(this, helper.retrieve());
        lv.setAdapter(adapter);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                displayInputDialog();
//            }
//        });

        //RETRIEVE
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {


                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

//    //DISPLAY INPUT DIALOG
//    private void displayInputDialog() {
//        Dialog d = new Dialog(this);
//        d.setTitle("Save To Firebase");
//        d.setContentView(R.layout.input_dialog);
//
//        headEditTxt = (EditText) d.findViewById(R.id.headEditText);
//        subheadTxt = (EditText) d.findViewById(R.id.subheadEditText);
//        detailTxt = (EditText) d.findViewById(R.id.detailEditText);
//        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);
//
//        //SAVE
//        saveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //GET DATA
//                String head = headEditTxt.getText().toString();
//                String subhead = subheadTxt.getText().toString();
//                String detail = detailTxt.getText().toString();
//
//                //SET DATA
//                Spacecraft s = new Spacecraft();
//                s.setHead(head);
//                s.setSubhead(subhead);
//                s.setDetail(detail);
//
//
//                //SIMPLE VALIDATION
//                if (head != null && head.length() > 0) {
//                    //THEN SAVE
//                    if (helper.save(s)) {
//                        //IF SAVED CLEAR EDITXT
//                        headEditTxt.setText("");
//                        subheadTxt.setText("");
//                        detailTxt.setText("");
//
//
//                        adapter = new CustomAdapter(MainActivity.this, helper.retrieve());
//                        lv.setAdapter(adapter);
//
//
//                    }
//                } else {
//                    Toast.makeText(MainActivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

//        d.show();
//    }
}

