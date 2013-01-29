package com.example.splitthebill;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class splitBill extends Activity {
	TextView cost;
	EditText number;
	double total;

	public splitBill() {
		// TODO Auto-generated constructor stub
	}
	
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splitbill);
		cost = (TextView) findViewById(R.id.cost);
		number = (EditText) findViewById(R.id.number);
		Intent i = getIntent();
		total = i.getDoubleExtra("totalCost", total);
	}
	public void split(View v) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
		int num = Integer.parseInt(number.getText().toString());
		double perperson = total/num;
		DecimalFormat df = new DecimalFormat("@@@@");
		String spp = df.format(perperson);
		cost.setText("$"+spp);
	}
}
