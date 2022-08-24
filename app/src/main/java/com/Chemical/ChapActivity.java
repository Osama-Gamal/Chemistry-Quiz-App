package com.Chemical;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.media.MediaPlayer;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

public class ChapActivity extends Activity {
	

	private Button button33;
	private TextView textview11;
	private TextView textview1;

	private Button button34;
	private TextView textview12;
	private TextView textview2;

	private Button button35;
	private TextView textview13;
	private TextView textview3;

	private Button button36;
	private TextView textview14;
	private TextView textview4;

	private Button button37;
	private TextView textview15;
	private TextView textview5;

	private Button button38;
	private TextView textview21;
	private TextView textview22;
	
	private SharedPreferences total;
	private Intent i = new Intent();
	private MediaPlayer clk;
	private AlertDialog.Builder hd;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chap);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		

		button33 = (Button) findViewById(R.id.button33);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview1 = (TextView) findViewById(R.id.textview1);

		button34 = (Button) findViewById(R.id.button34);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview2 = (TextView) findViewById(R.id.textview2);

		button35 = (Button) findViewById(R.id.button35);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview3 = (TextView) findViewById(R.id.textview3);

		button36 = (Button) findViewById(R.id.button36);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview4 = (TextView) findViewById(R.id.textview4);

		button37 = (Button) findViewById(R.id.button37);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview5 = (TextView) findViewById(R.id.textview5);

		button38 = (Button) findViewById(R.id.button38);
		textview21 = (TextView) findViewById(R.id.textview21);
		textview22 = (TextView) findViewById(R.id.textview22);
		total = getSharedPreferences("total", Activity.MODE_PRIVATE);
		hd = new AlertDialog.Builder(this);
		
		button33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clk.start();
				i.setClass(getApplicationContext(), ChemistryActivity.class);
				i.putExtra("cha", "cha1");
				startActivity(i);
				finish();
			}
		});
		
		button34.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clk.start();
				i.setClass(getApplicationContext(), ChemistryActivity.class);
				i.putExtra("cha", "cha2");
				startActivity(i);
				finish();
			}
		});
		
		button35.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clk.start();
				hd.setTitle("قريبا");
				hd.setMessage("لم يتم الانتهاء من باقي الابواب بعد انتظرنا في الاصدار القادم عما قريب");
				hd.create().show();
			}
		});
		
		button36.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clk.start();
				hd.setTitle("قريبا");
				hd.setMessage("لم يتم الانتهاء من باقي الابواب بعد انتظرنا في الاصدار القادم عما قريب");
				hd.create().show();
			}
		});
		
		button37.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clk.start();
				hd.setTitle("قريبا");
				hd.setMessage("لم يتم الانتهاء من باقي الابواب بعد انتظرنا في الاصدار القادم عما قريب");
				hd.create().show();
			}
		});
		
		button38.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clk.start();
				i.setClass(getApplicationContext(), ChemistryActivity.class);
				i.putExtra("cha", "all");
				startActivity(i);
				finish();
			}
		});
	}
	private void initializeLogic() {
		clk = MediaPlayer.create(getApplicationContext(), R.raw.cliuck);
		if (total.getString("cha1", "").equals("")) {
			textview1.setText("%0");
		}
		else {
			textview1.setText("%".concat(total.getString("cha1", "")));
		}
		if (total.getString("cha2", "").equals("")) {
			textview2.setText("%0");
		}
		else {
			textview2.setText("%".concat(total.getString("cha2", "")));
		}
		if (total.getString("cha3", "").equals("")) {
			textview3.setText("%0");
		}
		else {
			textview3.setText("%".concat(total.getString("cha3", "")));
		}
		if (total.getString("cha4", "").equals("")) {
			textview4.setText("%0");
		}
		else {
			textview4.setText("%".concat(total.getString("cha4", "")));
		}
		if (total.getString("cha5", "").equals("")) {
			textview5.setText("%0");
		}
		else {
			textview5.setText("%".concat(total.getString("cha5", "")));
		}
		if (total.getString("all", "").equals("")) {
			textview22.setText("%0");
		}
		else {
			textview22.setText("%".concat(total.getString("all", "")));
		}
		if (total.getString("cha_high1", "").equals("")) {
			
		}
		else {
			textview11.setText("%".concat(total.getString("cha_high1", "")));
		}
		if (total.getString("cha_high2", "").equals("")) {
			
		}
		else {
			textview12.setText("%".concat(total.getString("cha_high2", "")));
		}
		if (total.getString("cha_high3", "").equals("")) {
			
		}
		else {
			textview13.setText("%".concat(total.getString("cha_high3", "")));
		}
		if (total.getString("cha_high4", "").equals("")) {
			
		}
		else {
			textview14.setText("%".concat(total.getString("cha_high4", "")));
		}
		if (total.getString("cha_high5", "").equals("")) {
			
		}
		else {
			textview15.setText("%".concat(total.getString("cha_high5", "")));
		}
		if (total.getString("cha_all", "").equals("")) {
			
		}
		else {
			textview21.setText("%".concat(total.getString("cha_all", "")));
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
