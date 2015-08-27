package com.eulersonrodrigues.projetoqualidade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.Citations;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Citations myCitation = new Citations();
    EditText getEdtAuthor;
    EditText getEdtCitation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.FLAVOR == "free") {
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        }

        Log.d("flavor", BuildConfig.FLAVOR);





        Button getCitation = (Button) findViewById(R.id.btnGetCitation);
        Button addCitation = (Button) findViewById(R.id.btnAddCitation);

        getEdtAuthor = (EditText) findViewById(R.id.edtAuthor);
        getEdtCitation = (EditText) findViewById(R.id.edtCitation);

        getCitation.setOnClickListener(this);
        addCitation.setOnClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGetCitation:
                String testCitation = myCitation.GetCitation();
                Bundle dataBundle = new Bundle();
                dataBundle.putString("citation", testCitation);

                Intent intent = new Intent(getApplicationContext(),DisplayCitationActivity.class);
                intent.putExtras(dataBundle);

                startActivity(intent);

                break;
            case R.id.btnAddCitation:
                myCitation.AddCitation((getEdtAuthor.getText().toString()), (getEdtCitation.getText().toString()));
                Toast.makeText(getApplicationContext(), "Adicionado", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
