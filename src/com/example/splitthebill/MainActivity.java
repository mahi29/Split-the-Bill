package com.example.splitthebill;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener, TextWatcher {
	EditText billamt;
	TextView tipmsg;
	TextView totalamt;
	SeekBar tip;
	Double finaltip;
	Double dbill;
	Double damt;
	Double total;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tipmsg = (TextView) findViewById(R.id.tipmsg);
		totalamt = (TextView) findViewById(R.id.totalamt);
		tip = (SeekBar) findViewById(R.id.tip);
		tip.setOnSeekBarChangeListener(this);
		billamt = (EditText) findViewById(R.id.billamt);
		billamt.addTextChangedListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onProgressChanged(SeekBar tip, int amount, boolean arg2) {
		String bill = ((EditText)findViewById(R.id.billamt)).getText().toString();
		if ((bill.length() != 0) && (!bill.equals(null))) {
			tipmsg.setText("Lets tip " + amount +"%");
			tipUpdate(amount);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
	}
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		tipmsg.setText("Awesome. Now, how much would you like to tip?");
		totalamt.setText("");
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub	
	}
	public void splitBill(View v) {
		Intent i  = new Intent (this, splitBill.class);
		i.putExtra("totalCost", total);
		startActivity(i);
	}
	public void tenpercent(View v) {
		tipmsg.setText("Lets tip 10%");
		tip.setProgress(10);
		tipUpdate(10);
	}
	public void fifteenpercent (View v) {
		tipmsg.setText("Lets tip 15%");
		tip.setProgress(15);
		tipUpdate(15);		
	}
	public void twentypercent (View v) {
		tipmsg.setText("Lets tip 20%");
		tip.setProgress(20);
		tipUpdate(20);		
	}
	public void tipUpdate(int amount) {
		String bill = ((EditText)findViewById(R.id.billamt)).getText().toString();
		dbill = Double.parseDouble(bill);
		damt = (double) amount;
		finaltip = (damt/100)*dbill;
		total = (dbill + finaltip);
		DecimalFormat dftot = new DecimalFormat("@@@@");
		String finaltot = dftot.format(total);
		totalamt.setText("The total bill is $" + finaltot);
	}
}
