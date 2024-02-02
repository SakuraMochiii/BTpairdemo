package com.smartpos.demo.btpair.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smartpos.demo.btpair.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * Called when the activity is first created.
     */
    private Button autopairbtn = null;
    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autopairbtn = (Button) findViewById(R.id.button1);
        autopairbtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View arg0) {

        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
        } else {
            bluetoothAdapter.startDiscovery();
        }

    }
}