package com.smartpos.demo.btpair.receiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class BluetoothReceiver extends BroadcastReceiver {
    String targetDeviceName = "realme Q2 Pro 5G";  //device name

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("action1=", action);
        BluetoothDevice btDevice = null;
        btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

        String btDeviceName = btDevice.getName();

        if (BluetoothDevice.ACTION_FOUND.equals(action)) {  //FOUND DEVICE
            Log.e("FOUND:", "[" + btDeviceName + "]" + ":" + btDevice.getAddress());
            if (btDeviceName == null) {
                btDeviceName = "null";
            }
            if (btDeviceName.contains(targetDeviceName)) {//If there are multiple devices, the first one found will be tried.
                if (btDevice.getBondState() == BluetoothDevice.BOND_NONE) {
                    Log.e("BOND_NONE", "createBond to :" + "[" + btDeviceName + "]");
                    btDevice.createBond();
                }
            } else
                Log.e("error", "Is faild");
        } else if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
            Log.e("action2=", action);
            if (btDeviceName.contains(targetDeviceName)) {
                Log.e("RECEIVE PAIRING_REQUEST", "attemp to pair");

            } else
                Log.e("tips", "this device not target device");
        }
    }
}