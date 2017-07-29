package marte.ruben.com.manumarte.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import marte.ruben.com.manumarte.R;

public class MainActivity extends AppCompatActivity {
    Button mButtonStart;
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonStart =(Button) findViewById(R.id.buttonHistory);
        mEditText = (EditText)  findViewById(R.id.editTextHistory);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name="Guest";
                if(mEditText.getText().toString() != ""){
                    name = mEditText.getText().toString();
                }

                startHistory(name);


            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        mEditText.setText("");
    }

    private void startHistory(String name) {
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putExtra(getString(R.string.key),name);
        startActivity(intent);
    }

}
