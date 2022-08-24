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
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class InfoActivity extends Activity {
	

	private TextView textview1;
	private ImageView imageview1;
	private Button button2;
	private Button button3;
	
	private Intent km = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.info);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		

		textview1 = (TextView) findViewById(R.id.textview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				km.setData(Uri.parse("https://www.youtube.com/channel/UCX7-KEWpYxeyGFWoCHyallQ"));
				km.setAction(Intent.ACTION_VIEW);
				startActivity(km);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				km.setAction(Intent.ACTION_VIEW);
				km.setData(Uri.parse("http://api.whatsapp.com/send?phone=+201125156975"));
				startActivity(km);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				km.setAction(Intent.ACTION_VIEW);
				km.setData(Uri.parse("http://api.whatsapp.com/send?phone=+201117973617"));
				startActivity(km);
			}
		});
	}
	private void initializeLogic() {
		textview1.setText("هذا التطبيق يهدف الي تيسير المذاكره علي زملائي في الثانوية العامة من دفعة 2019 بصوره مميزه عن الكتب لتوفير المال والوقت والمجهود حيث يعمل التطبيق علي إعلامك بالصواب والخطأ وتقييمك علي كل باب مما يساعدك في التعرف علي نقاط ضعفك كما يجعل المذاكره ممتعه عن الكتب وسوف يتم إصدار نسخة من هذا التطبيق كل عام لطلبة الثانوية العامه في كافة المواد وبأفكار ابداعيه تساعد علي المذاكره وسيتم إضافة الكثير والكثير من الاسئلة عما قريب اذا واجهتك اي مشاكل او لديك اي اقتراحات فيمكنك التواصل معي وإعلامي بها\n****************************\nتم برمجة التطبيق بواسطة المعيار\nالتطبيق تحت إشراف ومراجعة معلم الكيمياء حنفي العفاني\nالإصدار1.1\n****************\nجميع الحقوق محفوظة لصالح المعيار ©\nلا تنسي متابعة القناة الرسمية للمعيار علي يوتيوب لمتابعة باقي الإصدارات فور صدورها");
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
