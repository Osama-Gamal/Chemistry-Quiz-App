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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.media.MediaPlayer;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.animation.Animator;
import java.text.DecimalFormat;

public class ChemistryActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private int num1 = 0;
	private double tim = 0;
	private double total_question = 0;
	private double total_true = 0;
	private double total_divide = 0;
	private double total_finish = 0;
	private double falsee = 0;
	private double checkvalue = 0;
	
	private ArrayList<String> rev = new ArrayList<>();
	private TextView textview1;
	private Button button2;
	private Button button4;
	private ImageView imageview1;
	private TextView textview2;
	private Button button1;
	private Button button3;

	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	
	private TimerTask t;
	private MediaPlayer pla;
	private ObjectAnimator sho = new ObjectAnimator();
	private MediaPlayer wron;
	private TimerTask count;
	private SharedPreferences total;
	private Intent go = new Intent();
	private MediaPlayer click;
	private MediaPlayer congr;
	private ObjectAnimator sno = new ObjectAnimator();
	private MediaPlayer freez;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chemistry);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		

		textview1 = (TextView) findViewById(R.id.textview1);

		button2 = (Button) findViewById(R.id.button2);
		button4 = (Button) findViewById(R.id.button4);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		button1 = (Button) findViewById(R.id.button1);
		button3 = (Button) findViewById(R.id.button3);

		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		total = getSharedPreferences("total", Activity.MODE_PRIVATE);
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				click.start();
				_btn2_que1();
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				click.start();
				_btn4_que1();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				click.start();
				_btn1_que1();
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				click.start();
				_btn3_que1();
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (total_true == 0) {
					_get();
				}
				else {
					if (total_true == 1) {
						total_true = total_true - 0.5d;
						_get();
					}
					else {
						total_true = total_true - 0.5d;
						_get();
					}
				}
			}
		});
		
		sho.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator _param1) {
				button2.setEnabled(true);
				button1.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				_timer();
			}
			
			@Override
			public void onAnimationCancel(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator _param1) {
				
			}
		});
	}
	private void initializeLogic() {
		pla = MediaPlayer.create(getApplicationContext(), R.raw.cir);
		wron = MediaPlayer.create(getApplicationContext(), R.raw.wrongcli);
		congr = MediaPlayer.create(getApplicationContext(), R.raw.atada);
		click = MediaPlayer.create(getApplicationContext(), R.raw.cliuck);
		imageview1.setVisibility(View.GONE);
		total_question = 0;
		total_true = 0;
		if (getIntent().getStringExtra("cha").equals("cha1")) {
			textview3.setText("الباب الاول");
			_que1();
			_que2();
			_que3();
		}
		else {
			if (getIntent().getStringExtra("cha").equals("cha2")) {
				textview3.setText("الباب الثاني");
				_que1();
			}
			else {
				if (getIntent().getStringExtra("cha").equals("cha3")) {
					textview3.setText("الباب الثالث");
				}
				else {
					if (getIntent().getStringExtra("cha").equals("cha4")) {
						textview3.setText("الباب الرابع");
					}
					else {
						if (getIntent().getStringExtra("cha").equals("cha5")) {
							textview3.setText("الباب الخامس");
						}
						else {
							if (getIntent().getStringExtra("cha").equals("all")) {
								textview5.setText("60 /");
								textview3.setText("مراجعة");
								_que1();
							}
							else {
								
							}
						}
					}
				}
			}
		}
		_all_false();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (total_true == 0) {
			_get();
		}
		else {
			if (total_true == 1) {
				total_true = total_true - 0.5d;
				_get();
			}
			else {
				total_true = total_true - 0.5d;
				_get();
			}
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		rev.clear();
		total_question = 0;
		if (tim == 30) {
			
		}
		else {
			count.cancel();
		}
	}
	private void _que1 () {
		_text_show();
		textview2.setText("30");
		_check_cha();
		if (num1 == 1) {
			textview1.setText("عناصر تحتل المنطقة الوسطي من الجدول الدوري وتقع بين عناصر الفئتين s, p ويتتابع فيها امتلاء المستوي الفرعي d");
			button1.setText("الممثله");
			button2.setText("النبيله");
			button3.setText("الانتقالية الرئيسية");
			button4.setText("الانتقالية الداخلية");
			_reverse();
		}
		else {
			if (num1 == 2) {
				textview1.setText("مجموعة العناصر التي تحتل الاعمده الرئيسية الثلاثه 8,9,10 في الجدول");
				button1.setText("المجموعة الاولي");
				button2.setText("المجموعة الثامنه");
				button3.setText("المجموعة السابعه");
				button4.setText("المجموعة الثالثه");
				_reverse();
			}
			else {
				if (num1 == 3) {
					textview1.setText("عناصر يتتابع فيها امتلاء المستوي الفرعي 3d");
					button1.setText("الانتقالية الاولي");
					button2.setText("الانتقالية الثانيه");
					button3.setText("الانتقالية الثالثه");
					button4.setText("الانتقالية الرابعه");
					_reverse();
				}
				else {
					if (num1 == 4) {
						textview1.setText("العنصر الذي يمزج مع الحديد لصناعة قضبان القطارات");
						button1.setText("الفاناديوم");
						button2.setText("التيتانيوم");
						button3.setText("المنجنيز");
						button4.setText("السكانديوم");
						_reverse();
					}
					else {
						if (num1 == 5) {
							textview1.setText("سلسلة العناصر التي تبدأ بعنصر اللانثانيوم وتنتهي بعنصر الزئبق");
							button1.setText("الانتقالية الاولي");
							button2.setText("الانتقالية الثانيه");
							button3.setText("الانتقالية الثالثه");
							button4.setText("الانتقالية الخامسة");
							_reverse();
						}
						else {
							if (num1 == 6) {
								textview1.setText("الطريقة المستخدمة في تحضير غاز النشادر في الصناعه من عنصريه");
								button1.setText("فيشر وتروبش");
								button2.setText("الانحلال الحراري");
								button3.setText("الترسيب الكهربي");
								button4.setText("هابر وبوش");
								_reverse();
							}
							else {
								if (num1 == 7) {
									textview1.setText("المركب الذي تستخدم دقائقه النانويه في تركيب مستحضرات الحماية من اشعة الشمس");
									button1.setText("ثاني اكسيد التيتانيوم");
									button2.setText("خامس اكسيد الفاناديوم");
									button3.setText("كبريتات النحاس");
									button4.setText("كبريتيد الخارصين");
									_reverse();
								}
								else {
									if (num1 == 8) {
										textview1.setText("عنصر انتقالي يستخدم في صناعة البطاريات القابلة لإعادة الشحن");
										button1.setText("النيكل");
										button2.setText("التيتانيوم");
										button3.setText("الخارصين");
										button4.setText("الكوبلت");
										_reverse();
									}
									else {
										if (num1 == 9) {
											textview1.setText("السبيكة المستخدمة في صناعة ملفات التسخين ولا تتأثر بإرتفاع الحراره");
											button1.setText("الحديد والمنجنيز");
											button2.setText("الصلب");
											button3.setText("النيكل مع الصلب");
											button4.setText("النيكل كروم");
											_reverse();
										}
										else {
											if (num1 == 10) {
												textview1.setText("عنصر انتقالي من السلسلة الاولى يعطي عدد تأكسد اعلي من رقم مجموعته بالجدول الدوري");
												button1.setText("الخارصين");
												button2.setText("السكانديوم");
												button3.setText("الكوبلت");
												button4.setText("النحاس");
												_reverse();
											}
											else {
												if (num1 == 11) {
													textview1.setText("المركب المستخدم في صناعة الطلائات المضيئة وشاشات الاشعه السينية");
													button1.setText("اكسيد الخارصين");
													button2.setText("كبريتات النحاس");
													button3.setText("كبريتيد الخارصين");
													button4.setText("برمنجنات البوتاسيوم");
													_reverse();
												}
												else {
													if (num1 == 12) {
														textview1.setText("يستخدم النحاس في صناعة كل مما يأتي, عدا");
														button1.setText("سبائك العملات");
														button2.setText("محلول فهلنج");
														button4.setText("السكك الحديدية");
														button3.setText("سبيكة البرونز");
														_reverse();
													}
													else {
														if (num1 == 13) {
															textview1.setText("عندما يحتوي المستوي الفرعي d علي ثمانية الكترونات فإن عدد اوربيتالات d النصف ممتلئه يساوي");
															button1.setText("2");
															button2.setText("1");
															button3.setText("3");
															button4.setText("4");
															_reverse();
														}
														else {
															if (num1 == 14) {
																textview1.setText("عند إضافة قطرات من محلول فهلنج الي محلول سكر الجلوكوز يتحول اللون من");
																button1.setText("البرتقالي الي الازرق");
																button2.setText("الازرق الي البرتقالي");
																button3.setText("الاحمر الي الازرق");
																button4.setText("الازرق الي الاحمر");
																_reverse();
															}
															else {
																if (num1 == 15) {
																	textview1.setText("حالات التأكسد الشائعة لعنصر السكانديوم هي");
																	button1.setText("+4");
																	button2.setText("+3");
																	button3.setText("+2");
																	button4.setText("+1");
																	_reverse();
																}
																else {
																	if (num1 == 16) {
																		textview1.setText("الصلب الذي لا يصدأ سبيكة تتكون من الحديد و");
																		button1.setText("الكوبلت");
																		button2.setText("المنجنيز");
																		button3.setText("النحاس");
																		button4.setText("الكروم");
																		_reverse();
																	}
																	else {
																		if (num1 == 17) {
																			textview1.setText("سبيكة النحاس والذهب من السبائك");
																			button1.setText("البينفلزيه");
																			button2.setText("البينيه");
																			button3.setText("الاستبداليه");
																			button4.setText("لا توجد اجابه");
																			_reverse();
																		}
																		else {
																			if (num1 == 18) {
																				textview1.setText("السبيكة التي تتحد فيها العناصر اتحادا كيميائيا");
																				button1.setText("السبيكة البينية");
																				button2.setText("السبيكة الاستبدالية");
																				button3.setText("السبيكة البينفلزية");
																				button4.setText("سبيكة الصلب");
																				_reverse();
																			}
																			else {
																				if (num1 == 19) {
																					textview1.setText("جميع المركبات الاتيه من خامات الحديد عدا");
																					button1.setText("المجنتيت");
																					button2.setText("الدولوميت");
																					button3.setText("الليمونيت");
																					button4.setText("الهيماتيت");
																					_reverse();
																				}
																				else {
																					if (num1 == 20) {
																						textview1.setText("كل مما يأتي من عمليات تجهيز خام الحديد في الصناعة عدا");
																						button1.setText("التكسير");
																						button2.setText("الاختزال");
																						button3.setText("التركيز");
																						button4.setText("التلبيد");
																						_reverse();
																					}
																					else {
																						_que2();
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _btn1_que1 () {
		count.cancel();
		button1.setBackgroundResource(R.drawable.wai);
		_all_false();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						switch (num1){
							case 3:
							case 7:
							case 8:
							case 13:
							case 22:
							case 28:
							case 30:
							case 31:
							case 34:
							case 40:
							case 42:
							case 47:
							case 49:
							case 51:
							case 56:
							case 63:
							case 64:
							case 69:
							case 75:
								button1.setBackgroundResource(R.drawable.truee);
								_true_();
								break;
							default:
								_btn1_que2();
								break;
						}
					}
				});
			}
		};
		_timer.schedule(t, (int)(3000));
	}
	
	
	private void _btn2_que1 () {
		count.cancel();
		button2.setBackgroundResource(R.drawable.wai);
		_all_false();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						switch(num1){
							case 2:
							case 15:
							case 19:
							case 20:
							case 23:
							case 29:
							case 41:
							case 43:
							case 46:
							case 52:
							case 53:
							case 57:
							case 60:
							case 65:
							case 67:
							case 70:
							case 76:
							case 77:
							case 14:
								button2.setBackgroundResource(R.drawable.truee);
								_true_();
								break;
							default:
								_btn2_que2();
								break;
						}
					}
				});
			}
		};
		_timer.schedule(t, (int)(3000));
	}
	
	
	private void _btn3_que1 () {
		count.cancel();
		button3.setBackgroundResource(R.drawable.wai);
		_all_false();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						switch (num1){
							case 1:
							case 4:
							case 5:
							case 11:
							case 17:
							case 18:
							case 21:
							case 24:
							case 27:
							case 32:
							case 33:
							case 35:
							case 39:
							case 44:
							case 48:
							case 54:
							case 58:
							case 61:
							case 66:
							case 68:
							case 71:
							case 74:
							case 87:
								button3.setBackgroundResource(R.drawable.truee);
								_true_();
								break;
							default:
								_btn3_que2();
								break;
						}
					}
				});
			}
		};
		_timer.schedule(t, (int)(3000));
	}
	
	
	private void _btn4_que1 () {
		count.cancel();
		button4.setBackgroundResource(R.drawable.wai);
		_all_false();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						switch (num1){
							case 6:
							case 9:
							case 10:
							case 12:
							case 16:
							case 25:
							case 26:
							case 36:
							case 37:
							case 38:
							case 45:
							case 50:
							case 55:
							case 59:
							case 62:
							case 72:
							case 73:
								button4.setBackgroundResource(R.drawable.truee);
								_true_();
								break;
							default:
								_btn4_que2();
								break;
						}
					}
				});
			}
		};
		_timer.schedule(t, (int)(3000));
	}
	
	
	private void _true_ () {
		pla.start();
		total_true++;
		textview6.setText(String.valueOf((long)(total_true)));
		if (getIntent().getStringExtra("cha").equals("all")) {
			if (total_true == 60) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								congr.start();
								_get();
							}
						});
					}
				};
				_timer.schedule(t, (int)(3000));
			}
			else {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								button1.setBackgroundResource(R.drawable.btn);
								button2.setBackgroundResource(R.drawable.btn);
								button3.setBackgroundResource(R.drawable.btn);
								button4.setBackgroundResource(R.drawable.btn);
								_que1();
							}
						});
					}
				};
				_timer.schedule(t, (int)(3000));
			}
		}
		else {
			if (total_true == 30) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								congr.start();
								_get();
							}
						});
					}
				};
				_timer.schedule(t, (int)(3000));
			}
			else {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								button1.setBackgroundResource(R.drawable.btn);
								button2.setBackgroundResource(R.drawable.btn);
								button3.setBackgroundResource(R.drawable.btn);
								button4.setBackgroundResource(R.drawable.btn);
								_que1();
							}
						});
					}
				};
				_timer.schedule(t, (int)(3000));
			}
		}
	}
	
	
	private void _false_ () {
		wron.start();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_num1_core();
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										_get();
									}
								});
							}
						};
						_timer.schedule(t, (int)(3000));
					}
				});
			}
		};
		_timer.schedule(t, (int)(3000));
	}
	
	
	private void _all_false () {
		button2.setEnabled(false);
		button1.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
	}
	
	
	private void _text_show () {
		sho.setTarget(textview1);
		sho.setPropertyName("alpha");
		sho.setFloatValues((float)(0), (float)(1));
		sho.setDuration((int)(1500));
		sho.start();
	}
	
	
	private void _num1_core () {
		switch (num1) {
			case 1:
			case 4:
			case 5:
			case 17:
			case 18:
			case 24:
			case 27:
			case 32:
			case 33:
			case 35:
			case 39:
			case 44:
			case 48:
			case 54:
			case 58:
			case 61:
			case 66:
			case 68:
			case 71:
			case 74:
			case 78:
			case 80:
			case 88:
			case 89:
			case 91:
			case 95:
			case 98:
			case 100:
			case 102:
			case 108:
			case 109:
			case 111:
			case 121:
				button3.setBackgroundResource(R.drawable.truee);
				break;
			case 3:
			case 7:
			case 8:
			case 22:
			case 28:
			case 30:
			case 31:
			case 34:
			case 40:
			case 42:
			case 47:
			case 49:
			case 51:
			case 56:
			case 63:
			case 64:
			case 69:
			case 75:
			case 79:
			case 83:
			case 87:
			case 93:
			case 97:
			case 101:
			case 106:
			case 113:
			case 114:
			case 117:
				button1.setBackgroundResource(R.drawable.truee);
				break;
			case 2:
			case 13:
			case 14:
			case 15:
			case 19:
			case 20:
			case 23:
			case 29:
			case 41:
			case 43:
			case 46:
			case 52:
			case 53:
			case 57:
			case 60:
			case 65:
			case 67:
			case 70:
			case 76:
			case 77:
			case 81:
			case 85:
			case 86:
			case 94:
			case 99:
			case 103:
			case 107:
			case 115:
			case 116:
			case 120:
				button2.setBackgroundResource(R.drawable.truee);
				break;
			case 6:
			case 9:
			case 10:
			case 12:
			case 16:
			case 25:
			case 26:
			case 36:
			case 37:
			case 38:
			case 45:
			case 50:
			case 55:
			case 59:
			case 62:
			case 72:
			case 73:
			case 82:
			case 84:
			case 90:
			case 92:
			case 96:
			case 104:
			case 105:
			case 110:
			case 112:
			case 118:
			case 119:
				button4.setBackgroundResource(R.drawable.truee);
				break;

		}
	}
	
	
	private void _timer () {
		tim = 30;
		if ((num1 == 116) || ((num1 == 117) || ((num1 == 118) || ((num1 == 119) || (num1 == 113))))) {
			freez = MediaPlayer.create(getApplicationContext(), R.raw.frozen);
			freez.start();
			imageview1.setVisibility(View.VISIBLE);
			textview2.setVisibility(View.GONE);
			textview2.setText(String.valueOf((long)(tim)));
			sno.setTarget(imageview1);
			sno.setPropertyName("alpha");
			sno.setFloatValues((float)(0), (float)(1));
			sno.setDuration((int)(1500));
			sno.start();
		}
		else {
			imageview1.setVisibility(View.GONE);
			textview2.setVisibility(View.VISIBLE);
			count = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							tim--;
							textview2.setText(String.valueOf((long)(tim)));
							if (tim == 0) {
								_all_false();
								count.cancel();
								_false_();
							}
							else {
								
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(count, (int)(0), (int)(1000));
		}
	}
	
	
	private void _que2 () {
		if (num1 == 21) {
			textview1.setText("اهم خام يستخلص منه الحديد بعد عمليات التجهيز هو");
			button1.setText("المجنتيت");
			button2.setText("السيدريت");
			button3.setText("الهيماتيت");
			button4.setText("الليمونيت");
			_reverse();
		}
		else {
			if (num1 == 22) {
				textview1.setText("النحاس الاصفر سبيكة تتكون من النحاس و");
				button1.setText("الخارصين");
				button2.setText("القصدير");
				button3.setText("الذهب");
				button4.setText("الحديد");
				_reverse();
			}
			else {
				if (num1 == 23) {
					textview1.setText("مركب برمنجنات البوتاسيوم يمتص اللون الاصفر من الضوء الابيض لذا يظهر باللون");
					button1.setText("الاخضر");
					button2.setText("البنفسجي");
					button3.setText("البرتقالي");
					button4.setText("الازرق");
					_reverse();
				}
				else {
					if (num1 == 24) {
						textview1.setText("المادة التي تمتص اللون البرتقالي من الضوء الابيض تظهر باللون ");
						button1.setText("الاصفر");
						button2.setText("البرتقالي");
						button3.setText("الازرق");
						button4.setText("البنفسجي");
						_reverse();
					}
					else {
						if (num1 == 25) {
							textview1.setText("عنصر تشذ كتلته الذريه مقارنة بالكتل الذريه لباقي عناصر السلسلة الانتقالية الاولي");
							button1.setText("السكانديوم");
							button2.setText("النحاس");
							button3.setText("الكوبلت");
							button4.setText("النيكل");
							_reverse();
						}
						else {
							if (num1 == 26) {
								textview1.setText("المركب المستخدم كعامل حفاز في صناعة حمض الكبريتيك بطريقة التلامس");
								button1.setText("كبريتات النحاس");
								button2.setText("ثاني اكسيد التيتانيوم");
								button3.setText("اكسيد الخارصين");
								button4.setText("خامس اكسيد الفاناديوم");
								_reverse();
							}
							else {
								if (num1 == 27) {
									textview1.setText("يبدأ ظهور العناصر السلسلة الانتقالية الاولي بعد عنصر");
									button1.setText("الماغنسيوم");
									button2.setText("الارجون");
									button3.setText("الكالسيوم");
									button4.setText("السكانديوم");
									_reverse();
								}
								else {
									if (num1 == 28) {
										textview1.setText("السبيكة المستخدمة في صناعة عبوات المشروبات الغازية تتكون من");
										button1.setText("الالومنيوم والمنجنيز");
										button2.setText("الحديد والمنجنيز");
										button3.setText("النحاس والقصدير");
										button4.setText("النحاس والخارصين");
										_reverse();
									}
									else {
										if (num1 == 29) {
											textview1.setText("يحضر كلوريد الحديد الثنائي من تفاعل الحديد مع");
											button1.setText("غاز الكلور");
											button2.setText("الهيدروكلوريك المخفف");
											button3.setText("الهواء");
											button4.setText("جميع ما سبق");
											_reverse();
										}
										else {
											if (num1 == 30) {
												textview1.setText("يمكن الحصول علي اكسيد الحديد الثنائي فقط من تسخين...........بمعزل عن الهواء");
												button1.setText("اكسالات الحديد II");
												button2.setText("كبريتات الحديد II");
												button3.setText("اكسيد الحديد III");
												button4.setText("كلوريد الحديد II");
												_reverse();
											}
											else {
												if (num1 == 31) {
													textview1.setText("يتفاعل اكسيد الحديد الثنائي مع الاحماض المخففه منتجا");
													button1.setText("ملح الحديد II وماء");
													button2.setText("ملح الحديد III وهيدروجين");
													button3.setText("ملح الحديد II وهيدروجين");
													button4.setText("ملح الحديد III وماء");
													_reverse();
												}
												else {
													if (num1 == 32) {
														textview1.setText("عند تسخين هيدروكسيد الحديد الثلاثي لدرجة حراره اعلي من °200C  ينتج");
														button1.setText("اكسيد الحديد II");
														button2.setText("Fe3o4");
														button3.setText("اكسيد الحديد III");
														button4.setText("هيدروكسيد الحديد II");
														_reverse();
													}
													else {
														if (num1 == 33) {
															textview1.setText("عند تسخين كبريتات الحديد الثنائي يتكون اكسيد الحديد الثلاثي وثاني اكسيد الكبريت و");
															button1.setText("هيدروجين");
															button2.setText("ماء");
															button3.setText("ثالث اكسيد الكبريت");
															button4.setText("كبريتيد الهيدروجين");
															_reverse();
														}
														else {
															if (num1 == 34) {
																textview1.setText("يذوب الحديد في الاحماض المخففه منتجا.....");
																button1.setText("املاح حديد II");
																button2.setText("املاح حديد III");
																button3.setText("اكسيد الحديد II");
																button4.setText("اكسيد الحديد III");
																_reverse();
															}
															else {
																if (num1 == 35) {
																	textview1.setText("عند تسخين الحديد في الهواء لدرجة الاحمرار يتكون اكسيد الحديد");
																	button1.setText("الثنائي");
																	button2.setText("الثلاثي");
																	button3.setText("المغناطيسي");
																	button4.setText("الاحمر");
																	_reverse();
																}
																else {
																	if (num1 == 36) {
																		textview1.setText("عند تفاعل الحديد مع الكبريت يتكون");
																		button1.setText("Feso4");
																		button2.setText("Fe2(So4)3");
																		button3.setText("Fe2S3");
																		button4.setText("FeS");
																		_reverse();
																	}
																	else {
																		if (num1 == 37) {
																			textview1.setText("عند إمرار غاز الكلور علي الحديد المسخن لدرجة الاحمرار يتكون");
																			button1.setText("كلوريد حديد II");
																			button4.setText("كلوريد حديد III");
																			button3.setText("كلوريد حديد I");
																			button2.setText("كلورات حديد III");
																			_reverse();
																		}
																		else {
																			if (num1 == 38) {
																				textview1.setText("عند إضافة حمض الهيدروكلوريك المخفف الي برادة الحديد يتصاعد");
																				button1.setText("Co2");
																				button2.setText("N2");
																				button3.setText("بخار الماء");
																				button4.setText("الهيدروجين");
																				_reverse();
																			}
																			else {
																				if (num1 == 39) {
																					textview1.setText("عند اختزال اكسيد الحديد المغناطيسي عند درجة حرارة 400°:700° ينتج");
																					button1.setText("FeSo4");
																					button2.setText("Fe2O3");
																					button3.setText("FeO");
																					button4.setText("Fe");
																					_reverse();
																				}
																				else {
																					if (num1 == 40) {
																						textview1.setText("خام من الحديد له خواص مغناطيسيه وصعب الاختزال ولونه اسود");
																						button1.setText("المجنتيت");
																						button2.setText("الهيماتيت");
																						button3.setText("الليمونيت");
																						button4.setText("السيدريت");
																						_reverse();
																					}
																					else {
																						_que3();
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	

	
	private void _que3 () {
		if (num1 == 41) {
			textview1.setText("عنصر تتميز سبائكه مع الصلب بالصلابة ومقاومة التآكل ومقاومة الاحماض");
			button1.setText("المنجنيز");
			button2.setText("النيكل");
			button3.setText("النحاس");
			button4.setText("الكربون");
			_reverse();
		}
		else {
			if (num1 == 42) {
				textview1.setText("يزداد العزم المغناطيسي للعنصر البارا مغناطيسي كلما زاد");
				button1.setText("الكترونات d المفرده");
				button2.setText("العدد الكتلي");
				button3.setText("عدد البروتونات");
				button4.setText("حجم الذره");
				_reverse();
			}
			else {
				if (num1 == 43) {
					textview1.setText("سبائك تستخدم بدلا من الالومنيوم في صناعة الطائرات والمركبات الفضائيه");
					button1.setText("التيتانيوم والذهب");
					button2.setText("التيتانيوم والالومنيوم");
					button3.setText("التيتانيوم والفضه");
					button4.setText("الحديد والخارصين");
					_reverse();
				}
				else {
					if (num1 == 44) {
						textview1.setText("عنصر يستخدم في صناعة زنبركات السيارات");
						button1.setText("المنجنيز");
						button2.setText("الخارصين");
						button3.setText("الفاناديوم");
						button4.setText("السكانديوم");
						_reverse();
					}
					else {
						if (num1 == 45) {
							textview1.setText("من مركبات المنجنيز ويستخدم كعامل مؤكسد قوي وفي صناعة العمود الجاف");
							button1.setText("برمنجنات البوتاسيوم");
							button2.setText("كبريتات المنجنيز");
							button3.setText("فهلنج الازرق");
							button4.setText("ثاني اكسيد المنجنيز");
							_reverse();
						}
						else {
							if (num1 == 46) {
								textview1.setText("آخر عنصر من عناصر السلسلة الانتقالية الاولي ");
								button1.setText("السكانديوم");
								button2.setText("الخارصين");
								button3.setText("الكادميوم");
								button4.setText("اليتريوم");
								_reverse();
							}
							else {
								if (num1 == 47) {
									textview1.setText("ما هو ترتيب الحديد بين عناصر القشره الارضيه من حيث الانتشار ");
									button1.setText("الرابع");
									button2.setText("الخامس");
									button3.setText("السادس");
									button4.setText("السابع");
									_reverse();
								}
								else {
									if (num1 == 48) {
										textview1.setText("ما هي نسبة الحديد في وزن القشره الارضيه ");
										button1.setText("5%");
										button2.setText("6%");
										button3.setText("5.1%");
										button4.setText("5.5%");
										_reverse();
									}
									else {
										if (num1 == 49) {
											textview1.setText("خام من خامات الحديد لونه احمر داكن وسهل الاختزال");
											button1.setText("الهيماتيت");
											button2.setText("المجنتيت");
											button3.setText("السيدريت");
											button4.setText("الليمونيت");
											_reverse();
										}
										else {
											if (num1 == 50) {
												textview1.setText("جميع الافران الاتيه تستخدمه في تحضير الصلب عدا");
												button1.setText("المحول الاكسجيني");
												button2.setText("الفرن المفتوح");
												button3.setText("الفرن الكهربي");
												button4.setText("فرن مدركس");
												_reverse();
											}
											else {
												if (num1 == 51) {
													textview1.setText("عملية تسخين خامات الحديد بشده في الهواء بغرض تجفيف الخام والتخلص من الرطوبه");
													button1.setText("التحميص");
													button2.setText("الاختزال");
													button3.setText("التركيز");
													button4.setText("التلبيد");
													_reverse();
												}
												else {
													if (num1 == 52) {
														textview1.setText("خليط من غازي اول أكسيد الكربون والهيدروجين ويستخدم كعامل مختزل");
														button1.setText("الماء");
														button2.setText("الغاز المائي");
														button3.setText("الهواء");
														button4.setText("ثالث اكسيد الكبريت");
														_reverse();
													}
													else {
														if (num1 == 53) {
															textview1.setText("مركبات تمتص اللون الاحمر وتترك اللون المتمم لها الاخضر");
															button1.setText("مركبات النحاس");
															button2.setText("مركبات الكروم");
															button3.setText("مركبات الفضه");
															button4.setText("مركبات النيكل");
															_reverse();
														}
														else {
															if (num1 == 54) {
																textview1.setText("المادة التي تمتص جميع الوان الضوء المرئي تراها العين باللون");
																button1.setText("الاحمر");
																button2.setText("الابيض");
																button3.setText("الاسود");
																button4.setText("الازرق");
																_reverse();
															}
															else {
																if (num1 == 55) {
																	textview1.setText("يستخدم ثاني اكسيد المنجنيز كعامل حفاز عند انحلال ");
																	button1.setText("اكسيد حديد III");
																	button2.setText("الماء");
																	button3.setText("حمض الكبريتيك");
																	button4.setText("فوق اكسيد الهيدروجين");
																	_reverse();
																}
																else {
																	if (num1 == 56) {
																		textview1.setText("من عناصر السلسلة الانتقالية محدودة النشاط");
																		button1.setText("النحاس");
																		button2.setText("الحديد");
																		button3.setText("السكانديوم");
																		button4.setText("النيكل");
																		_reverse();
																	}
																	else {
																		if (num1 == 57) {
																			textview1.setText("المادة التي تتجاذب مع المجال المغناطيسي الخارجي نتيجة وجود الكترونات مفرده");
																			button1.setText("الديا مغناطيسيه");
																			button2.setText("البارا مغناطيسيه");
																			button3.setText("الماده المتذبذبه");
																			button4.setText("المواد الخامله");
																			_reverse();
																		}
																		else {
																			if (num1 == 58) {
																				textview1.setText("لون ينتج من امتصاص فوتونات الضوء والذي تراه العين علي الماده");
																				button1.setText("اللون الممتص");
																				button2.setText("اللون المختلط");
																				button3.setText("اللون المتمم");
																				button4.setText("اللون الاسود");
																				_reverse();
																			}
																			else {
																				if (num1 == 59) {
																					textview1.setText("المادة التي تمتص اللون البنفسجي يكون اللون المتمم لها");
																					button1.setText("البرتقالي");
																					button2.setText("الاخضر");
																					button3.setText("الاحمر");
																					button4.setText("الاصفر");
																					_reverse();
																				}
																				else {
																					if (num1 == 60) {
																						textview1.setText("للحصول علي سبيكة النحاس الاصفر لطلاء مقابض الابواب يتم اعتماد طريقة");
																						button1.setText("الصهر");
																						button2.setText("الترسيب الكهربي");
																						button3.setText("الاختزال");
																						button4.setText("التكسير");
																						_reverse();
																					}
																					else {
																						_que4();
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	

	private void _que4 () {
		if (num1 == 61) {
			textview1.setText("تحتوي المنطقة الوسطي في الجدول الدوري علي اكثر من.......... عنصر");
			button1.setText("40");
			button2.setText("50");
			button3.setText("60");
			button4.setText("70");
			_reverse();
		}
		else {
			if (num1 == 62) {
				textview1.setText("مجموعة تختلف عن باقي مجموعات B في ان عناصرها الافقيه اكثر تشابها من عناصرها الافقيه");
				button1.setText("VII");
				button2.setText("IB");
				button3.setText("III");
				button4.setText("VIII");
				_reverse();
			}
			else {
				if (num1 == 63) {
					textview1.setText("عنصران يستخدمان في صناعة مصابيح أبخرة الزئبق");
					button1.setText("سكانديوم وزئبق");
					button2.setText("تيتانيوم وزئبق");
					button3.setText("نحاس وزئبق");
					button4.setText("نيكل وكروم");
					_reverse();
				}
				else {
					if (num1 == 64) {
						textview1.setText("عنصر يتميز بشدة الصلابة كالصلب واقل كثافه منه ويدخل في زراعة الاسنان");
						button1.setText("التيتانيوم");
						button2.setText("الخارصين");
						button4.setText("الحديد");
						button3.setText("الفاناديوم");
						_reverse();
					}
					else {
						if (num1 == 65) {
							textview1.setText("عنصر انتقالي يدخل في صناعة مواسير البنادق والسكاكين والادوات الجراحيه");
							button1.setText("التيتانيوم");
							button2.setText("الحديد");
							button3.setText("الكوبلت");
							button4.setText("النحاس");
							_reverse();
						}
						else {
							if (num1 == 66) {
								textview1.setText("عناصر التركيب الخارجي لاوربيتالاتها الخارجية ممتلئة بالالكترونات حتي في حالة تأكسدها");
								button1.setText("المجموعة II");
								button2.setText("المجموعة IB");
								button3.setText("المجموعة IIB");
								button4.setText("المجموعة VIII");
								_reverse();
							}
							else {
								if (num1 == 67) {
									textview1.setText("المتوسط الحسابي للخمسة نظائر المستقره لعنصر النيكل");
									button1.setText("55.7");
									button2.setText("58.7");
									button3.setText("48");
									button4.setText("5.1");
									_reverse();
								}
								else {
									_que5_ch2();
								}
							}
						}
					}
				}
			}
		}
	}
	

	
	private void _btn1_wrong () {
		button1.setBackgroundResource(R.drawable.red);
		_false_();
	}
	
	
	private void _btn2_wrong () {
		button2.setBackgroundResource(R.drawable.red);
		_false_();
	}
	
	
	private void _btn3_wrong () {
		button3.setBackgroundResource(R.drawable.red);
		_false_();
	}
	
	
	private void _btn4_wrong () {
		button4.setBackgroundResource(R.drawable.red);
		_false_();
	}
	
	
	private void _get () {
		total_divide = total_true / 30;
		total_finish = total_divide * 100;
		if (getIntent().getStringExtra("cha").equals("cha1")) {
			if (String.valueOf(total_finish).length() > 3) {
				total.edit().putString("cha1", String.valueOf(total_finish).substring((int)(0), (int)(4))).commit();
				go.setClass(getApplicationContext(), ChapActivity.class);
				startActivity(go);
				finish();
			}
			else {
				total.edit().putString("cha1", String.valueOf((long)(total_finish))).commit();
				go.setClass(getApplicationContext(), ChapActivity.class);
				startActivity(go);
				finish();
			}
			if (total.getString("cha_high1", "").equals("")) {
				total.edit().putString("cha_high1", total.getString("cha1", "")).commit();
			}
			else {
				if (Double.parseDouble(total.getString("cha1", "")) > Double.parseDouble(total.getString("cha_high1", ""))) {
					total.edit().putString("cha_high1", total.getString("cha1", "")).commit();
				}
				else {
					
				}
			}
		}
		else {
			if (getIntent().getStringExtra("cha").equals("cha2")) {
				if (String.valueOf(total_finish).length() > 3) {
					total.edit().putString("cha2", String.valueOf(total_finish).substring((int)(0), (int)(4))).commit();
					go.setClass(getApplicationContext(), ChapActivity.class);
					startActivity(go);
					finish();
				}
				else {
					total.edit().putString("cha2", String.valueOf((long)(total_finish))).commit();
					go.setClass(getApplicationContext(), ChapActivity.class);
					startActivity(go);
					finish();
				}
				if (total.getString("cha_high2", "").equals("")) {
					total.edit().putString("cha_high2", total.getString("cha2", "")).commit();
				}
				else {
					if (Double.parseDouble(total.getString("cha2", "")) > Double.parseDouble(total.getString("cha_high2", ""))) {
						total.edit().putString("cha_high2", total.getString("cha2", "")).commit();
					}
					else {
						
					}
				}
			}
			else {
				if (getIntent().getStringExtra("cha").equals("cha3")) {
					if (String.valueOf(total_finish).length() > 3) {
						total.edit().putString("cha3", String.valueOf(total_finish).substring((int)(0), (int)(4))).commit();
						go.setClass(getApplicationContext(), ChapActivity.class);
						startActivity(go);
						finish();
					}
					else {
						total.edit().putString("cha3", String.valueOf((long)(total_finish))).commit();
						go.setClass(getApplicationContext(), ChapActivity.class);
						startActivity(go);
						finish();
					}
					if (total.getString("cha_high3", "").equals("")) {
						total.edit().putString("cha_high3", total.getString("cha3", "")).commit();
					}
					else {
						if (Double.parseDouble(total.getString("cha3", "")) > Double.parseDouble(total.getString("cha_high3", ""))) {
							total.edit().putString("cha_high3", total.getString("cha3", "")).commit();
						}
						else {
							
						}
					}
				}
				else {
					if (getIntent().getStringExtra("cha").equals("cha4")) {
						if (String.valueOf(total_finish).length() > 3) {
							total.edit().putString("cha4", String.valueOf(total_finish).substring((int)(0), (int)(4))).commit();
							go.setClass(getApplicationContext(), ChapActivity.class);
							startActivity(go);
							finish();
						}
						else {
							total.edit().putString("cha4", String.valueOf((long)(total_finish))).commit();
							go.setClass(getApplicationContext(), ChapActivity.class);
							startActivity(go);
							finish();
						}
						if (total.getString("cha_high4", "").equals("")) {
							total.edit().putString("cha_high4", total.getString("cha4", "")).commit();
						}
						else {
							if (Double.parseDouble(total.getString("cha4", "")) > Double.parseDouble(total.getString("cha_high4", ""))) {
								total.edit().putString("cha_high4", total.getString("cha4", "")).commit();
							}
							else {
								
							}
						}
					}
					else {
						if (getIntent().getStringExtra("cha").equals("cha5")) {
							if (String.valueOf(total_finish).length() > 3) {
								total.edit().putString("cha5", String.valueOf(total_finish).substring((int)(0), (int)(4))).commit();
								go.setClass(getApplicationContext(), ChapActivity.class);
								startActivity(go);
								finish();
							}
							else {
								total.edit().putString("cha5", String.valueOf((long)(total_finish))).commit();
								go.setClass(getApplicationContext(), ChapActivity.class);
								startActivity(go);
								finish();
							}
							if (total.getString("cha_high5", "").equals("")) {
								total.edit().putString("cha_high5", total.getString("cha5", "")).commit();
							}
							else {
								if (Double.parseDouble(total.getString("cha4", "")) > Double.parseDouble(total.getString("cha_high4", ""))) {
									total.edit().putString("cha_high5", total.getString("cha5", "")).commit();
								}
								else {
									
								}
							}
						}
						else {
							if (getIntent().getStringExtra("cha").equals("all")) {
								if (String.valueOf(total_finish).length() > 3) {
									total.edit().putString("all", String.valueOf(total_finish).substring((int)(0), (int)(4))).commit();
									go.setClass(getApplicationContext(), ChapActivity.class);
									startActivity(go);
									finish();
								}
								else {
									total.edit().putString("all", String.valueOf((long)(total_finish))).commit();
									go.setClass(getApplicationContext(), ChapActivity.class);
									startActivity(go);
									finish();
								}
								if (total.getString("cha_all", "").equals("")) {
									total.edit().putString("cha_all", total.getString("all", "")).commit();
								}
								else {
									if (Double.parseDouble(total.getString("all", "")) > Double.parseDouble(total.getString("cha_all", ""))) {
										total.edit().putString("cha_all", total.getString("all", "")).commit();
									}
									else {
										
									}
								}
							}
							else {
								
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _reverse () {
		if (rev.contains(String.valueOf((long)(num1)))) {
			_que1();
		}
		else {
			rev.add(String.valueOf((long)(num1)));
		}
	}
	
	
	private void _que5_ch2 () {
		if (num1 == 68) {
			textview1.setText("يعتبر حمض الهيدروكلوريك كاشفا لأنيون");
			button1.setText("اليوديد");
			button2.setText("النترات");
			button3.setText("النيتريت");
			button4.setText("البروميد");
			_reverse();
		}
		else {
			if (num1 == 69) {
				textview1.setText("جميع املاح ..........  قابلة للذوبان في الماء");
				button1.setText("بيكربونات");
				button2.setText("كربونات");
				button3.setText("كبريتيت");
				button4.setText("كلوريدات");
				_reverse();
			}
			else {
				if (num1 == 70) {
					textview1.setText("عند اضافة حمض Hcl الي ملح........  يتصاعد غاز له رائحة كريهة");
					button1.setText("كربونات");
					button2.setText("كبريتيد");
					button3.setText("ثيوكبريتات");
					button4.setText("كبريتيت");
					_reverse();
				}
				else {
					if (num1 == 71) {
						textview1.setText("عند اضافة حمض الهيدروكلوريك المخفف الي محلول ثيوكبريتات الصوديوم يتكون معلق أصفر من الكبريت مصحوبا بتصاعد غاز....... ");
						button1.setText("ثالث اكسيد الكبريت");
						button2.setText("الاكسجين");
						button3.setText("ثاني اكسيد الكبريت");
						button4.setText("ثاني أكسيد الكربون");
						_reverse();
					}
					else {
						if (num1 == 72) {
							textview1.setText("عند اضافة محلول اسيتات الرصاص II الي محلول ملح............ يتكون راسب أسود");
							button1.setText("كبريتات");
							button2.setText("نترات");
							button3.setText("فوسفات");
							button4.setText("كبريتيد");
							_reverse();
						}
						else {
							if (num1 == 73) {
								textview1.setText("اذا اضيف حمض الهيدروكلوريك المخفف الي أحد الاملاح وتصاعد غاز نفاذ الرائحة وتكون راسب اصفر فإن انيون الملح يكون");
								button1.setText("co3");
								button2.setText("so3");
								button3.setText("s");
								button4.setText("s2o3");
								_reverse();
							}
							else {
								if (num1 == 74) {
									textview1.setText("يخضر لون محلول ثاني كرومات البوتاسيوم المحمضة بحمض الكبريتيك عند إمرار غاز ");
									button1.setText("كلوريد الهيدروجين");
									button2.setText("كبريتيد الهيدروجين");
									button3.setText("ثاني اكسيد الكبريت");
									button4.setText("بروميد الهيدروجين");
									_reverse();
								}
								else {
									if (num1 == 75) {
										textview1.setText("المحلول الحامضي من Kmno4 يؤكسد مجموعة");
										button1.setText("النيتريت");
										button2.setText("الكربونات");
										button3.setText("النترات");
										button4.setText("الكبريتات");
										_reverse();
									}
									else {
										if (num1 == 76) {
											textview1.setText("يتكون راسب ابيض عند إضافة ايا من حمض الكبريتيك المركز او محلول نترات الفضة الي محلول ");
											button1.setText("كلوريد الماغنسيوم");
											button2.setText("كلوريد الباريوم");
											button3.setText("كبريتات الماغنسيوم");
											button4.setText("نترات الباريوم");
											_reverse();
										}
										else {
											if (num1 == 77) {
												textview1.setText("لا يذوب الراسب............ بإضافة محلول النشادر اليه");
												button1.setText("agcl");
												button2.setText("agi");
												button3.setText("ag3po4");
												button4.setText("ag2s");
												_reverse();
											}
											else {
												if (num1 == 78) {
													textview1.setText("عند تعريض ورقة النشا المبللة بالماء في أبخرة اليود البنفسجية تتلون باللون");
													button1.setText("الاصفر");
													button2.setText("الابيض المصفر");
													button3.setText("الازرق");
													button4.setText("الاسود");
													_reverse();
												}
												else {
													if (num1 == 79) {
														textview1.setText("عند إضافة حمض الكبريتيك المركز الي ملح.......... يتصاعد غاز عديم اللون يكون سحب بيضاء كثيفة مع ساق مبللة بمحلول النشادر");
														button1.setText("الكلوريد");
														button2.setText("البروميد");
														button3.setText("اليوديد");
														button4.setText("النترات");
														_reverse();
													}
													else {
														if (num1 == 80) {
															textview1.setText("أي المواد التالية يمكن استخدامها لتقليل أثر الرائحة النفاذة لغاز النشادر");
															button1.setText("h2s");
															button2.setText("co2");
															button3.setText("hcl");
															button4.setText("so2");
															_reverse();
														}
														else {
															if (num1 == 81) {
																textview1.setText("لا يمكن الكشف عن انيونات...............بإستخدام حمض الكبريتيك المركز او حمض الهيدروكلوريك المخفف");
																button1.setText("النترات");
																button2.setText("الفوسفات");
																button3.setText("الكبريتيدات");
																button4.setText("اليوديد");
																_reverse();
															}
															else {
																if (num1 == 82) {
																	textview1.setText("يستخدم محلول كلوريد الباريوم في الكشف عن انيون");
																	button1.setText("النترات");
																	button2.setText("الكبريتيد");
																	button3.setText("البيكربونات");
																	button4.setText("الكبريتات");
																	_reverse();
																}
																else {
																	if (num1 == 83) {
																		textview1.setText("عند إضافة محلول كلوريد الباريوم الي محلول كبريتات الصوديوم يتكون راسب");
																		button1.setText("أبيض");
																		button2.setText("أصفر");
																		button3.setText("أزرق");
																		button4.setText("بنفسجي");
																		_reverse();
																	}
																	else {
																		if (num1 == 84) {
																			textview1.setText("عند إضافة محلول اسيتات الرصاص II الي محلول كبريتات الصوديوم يتكون راسب لونه");
																			button1.setText("اسود");
																			button2.setText("ازرق");
																			button3.setText("اخضر");
																			button4.setText("ابيض");
																			_reverse();
																		}
																		else {
																			if (num1 == 85) {
																				textview1.setText("الكاتيون الذي يترسب علي هيئة كلوريد شحيح الذوبان في الماء هو");
																				button1.setText("الحديد الثنائي");
																				button2.setText("ايون الفضة");
																				button3.setText("الالومنيوم الثلاثي");
																				button4.setText("النحاس الثنائي");
																				_reverse();
																			}
																			else {
																				if (num1 == 86) {
																					textview1.setText("تترسب كاتيونات المجموعة التحليلية الثانية علي هيئة");
																					button1.setText("كربونات");
																					button2.setText("كبريتيدات");
																					button3.setText("كلوريدات");
																					button4.setText("هيدروكسيدات");
																					_reverse();
																				}
																				else {
																					if (num1 == 87) {
																						textview1.setText("تترسب أيونات.............. عند إمرار غاز H2S في محلول حامضي لأحد أملاحة");
																						button1.setText("ايون النحاس الثنائي");
																						button2.setText("ايون الحديد الثنائي");
																						button3.setText("ايون الحديد الثلاثي");
																						button4.setText("ايون الالومنيوم الثلاثي");
																						_reverse();
																					}
																					else {
																						if (num1 == 88) {
																							textview1.setText("عند إضافة محلول النشادر الي محلول..............يتكون راسب ابيض يذوب في حمض الهيدروكلوريك المخفف");
																							button1.setText("كلوريد الكالسيوم");
																							button2.setText("كبريتات الكالسيوم");
																							button3.setText("كبريتات الالومنيوم");
																							button4.setText("كلوريد الصوديوم");
																							_reverse();
																						}
																						else {
																							if (num1 == 89) {
																								textview1.setText("عند إضافة محلول هيدروكسيد الامونيوم الي محلول كبريتات الحديد الثلاثي يتكون راسب..............");
																								button1.setText("أبيض جيلاتيني");
																								button2.setText("ازرق");
																								button3.setText("بني محمر");
																								button4.setText("ابيض مخضر");
																								_reverse();
																							}
																							else {
																								if (num1 == 90) {
																									textview1.setText("عند إضافة محلول هيدروكسيد الصوديوم الي محلول كلوريد الحديد الثنائي يتكون راسب............ ");
																									button1.setText("بني محمر");
																									button2.setText("اسود");
																									button3.setText("ازرق");
																									button4.setText("ابيض مخضر");
																									_reverse();
																								}
																								else {
																									_que6_ch2();
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _check_cha () {
		if (getIntent().getStringExtra("cha").equals("cha1")) {
			num1 = SketchwareUtil.getRandom((int)(1), (int)(67));
		}
		else {
			if (getIntent().getStringExtra("cha").equals("cha2")) {
				num1 = SketchwareUtil.getRandom((int)(68), (int)(121));
			}
			else {
				if (getIntent().getStringExtra("cha").equals("cha3")) {
					textview3.setText("الباب الثالث");
				}
				else {
					if (getIntent().getStringExtra("cha").equals("cha4")) {
						
					}
					else {
						if (getIntent().getStringExtra("cha").equals("cha5")) {
							
						}
						else {
							if (getIntent().getStringExtra("cha").equals("all")) {
								num1 = SketchwareUtil.getRandom((int)(1), (int)(121));
								textview3.setText("مراجعة");
							}
							else {
								
							}
						}
					}
				}
			}
		}
		_all_false();
	}
	
	
	private void _ch5_corr () {
		if (num1 == 91) {
			button3.setBackgroundResource(R.drawable.truee);
		}
		else {
			if (num1 == 92) {
				button4.setBackgroundResource(R.drawable.truee);
			}
			else {
				if (num1 == 93) {
					button1.setBackgroundResource(R.drawable.truee);
				}
				else {
					if (num1 == 94) {
						button2.setBackgroundResource(R.drawable.truee);
					}
					else {
						if (num1 == 95) {
							button3.setBackgroundResource(R.drawable.truee);
						}
						else {
							if (num1 == 96) {
								button4.setBackgroundResource(R.drawable.truee);
							}
							else {
								if (num1 == 97) {
									button1.setBackgroundResource(R.drawable.truee);
								}
								else {
									if (num1 == 98) {
										button3.setBackgroundResource(R.drawable.truee);
									}
									else {
										if (num1 == 99) {
											button2.setBackgroundResource(R.drawable.truee);
										}
										else {
											if (num1 == 100) {
												button3.setBackgroundResource(R.drawable.truee);
											}
											else {
												if (num1 == 101) {
													button1.setBackgroundResource(R.drawable.truee);
												}
												else {
													if (num1 == 102) {
														button3.setBackgroundResource(R.drawable.truee);
													}
													else {
														if (num1 == 103) {
															button2.setBackgroundResource(R.drawable.truee);
														}
														else {
															if (num1 == 104) {
																button4.setBackgroundResource(R.drawable.truee);
															}
															else {
																if (num1 == 105) {
																	button4.setBackgroundResource(R.drawable.truee);
																}
																else {
																	if (num1 == 106) {
																		button1.setBackgroundResource(R.drawable.truee);
																	}
																	else {
																		if (num1 == 107) {
																			button2.setBackgroundResource(R.drawable.truee);
																		}
																		else {
																			if (num1 == 108) {
																				button3.setBackgroundResource(R.drawable.truee);
																			}
																			else {
																				if (num1 == 109) {
																					button3.setBackgroundResource(R.drawable.truee);
																				}
																				else {
																					if (num1 == 110) {
																						button4.setBackgroundResource(R.drawable.truee);
																					}
																					else {
																						if (num1 == 111) {
																							button3.setBackgroundResource(R.drawable.truee);
																						}
																						else {
																							if (num1 == 112) {
																								button4.setBackgroundResource(R.drawable.truee);
																							}
																							else {
																								if (num1 == 113) {
																									button1.setBackgroundResource(R.drawable.truee);
																								}
																								else {
																									if (num1 == 114) {
																										button1.setBackgroundResource(R.drawable.truee);
																									}
																									else {
																										if (num1 == 115) {
																											button2.setBackgroundResource(R.drawable.truee);
																										}
																										else {
																											if (num1 == 116) {
																												button2.setBackgroundResource(R.drawable.truee);
																											}
																											else {
																												_ch6_corr2();
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _btn1_que2 () {
		if (num1 == 79) {
			button1.setBackgroundResource(R.drawable.truee);
			_true_();
		}
		else {
			if (num1 == 83) {
				button1.setBackgroundResource(R.drawable.truee);
				_true_();
			}
			else {
				if (num1 == 87) {
					button1.setBackgroundResource(R.drawable.truee);
					_true_();
				}
				else {
					if (num1 == 93) {
						button1.setBackgroundResource(R.drawable.truee);
						_true_();
					}
					else {
						if (num1 == 97) {
							button1.setBackgroundResource(R.drawable.truee);
							_true_();
						}
						else {
							if (num1 == 101) {
								button1.setBackgroundResource(R.drawable.truee);
								_true_();
							}
							else {
								if (num1 == 106) {
									button1.setBackgroundResource(R.drawable.truee);
									_true_();
								}
								else {
									if (num1 == 113) {
										button1.setBackgroundResource(R.drawable.truee);
										_true_();
									}
									else {
										if (num1 == 114) {
											button1.setBackgroundResource(R.drawable.truee);
											_true_();
										}
										else {
											if (num1 == 117) {
												button1.setBackgroundResource(R.drawable.truee);
												_true_();
											}
											else {
												button1.setBackgroundResource(R.drawable.red);
												_false_();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _btn2_que2 () {
		if (num1 == 81) {
			button2.setBackgroundResource(R.drawable.truee);
			_true_();
		}
		else {
			if (num1 == 85) {
				button2.setBackgroundResource(R.drawable.truee);
				_true_();
			}
			else {
				if (num1 == 86) {
					button2.setBackgroundResource(R.drawable.truee);
					_true_();
				}
				else {
					if (num1 == 94) {
						button2.setBackgroundResource(R.drawable.truee);
						_true_();
					}
					else {
						if (num1 == 99) {
							button2.setBackgroundResource(R.drawable.truee);
							_true_();
						}
						else {
							if (num1 == 103) {
								button2.setBackgroundResource(R.drawable.truee);
								_true_();
							}
							else {
								if (num1 == 107) {
									button2.setBackgroundResource(R.drawable.truee);
									_true_();
								}
								else {
									if (num1 == 115) {
										button2.setBackgroundResource(R.drawable.truee);
										_true_();
									}
									else {
										if (num1 == 116) {
											button2.setBackgroundResource(R.drawable.truee);
											_true_();
										}
										else {
											if (num1 == 120) {
												button2.setBackgroundResource(R.drawable.truee);
												_true_();
											}
											else {
												button2.setBackgroundResource(R.drawable.red);
												_false_();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _btn3_que2 () {
		if (num1 == 80) {
			button3.setBackgroundResource(R.drawable.truee);
			_true_();
		}
		else {
			if (num1 == 88) {
				button3.setBackgroundResource(R.drawable.truee);
				_true_();
			}
			else {
				if (num1 == 89) {
					button3.setBackgroundResource(R.drawable.truee);
					_true_();
				}
				else {
					if (num1 == 91) {
						button3.setBackgroundResource(R.drawable.truee);
						_true_();
					}
					else {
						if (num1 == 95) {
							button3.setBackgroundResource(R.drawable.truee);
							_true_();
						}
						else {
							if (num1 == 98) {
								button3.setBackgroundResource(R.drawable.truee);
								_true_();
							}
							else {
								if (num1 == 100) {
									button3.setBackgroundResource(R.drawable.truee);
									_true_();
								}
								else {
									if (num1 == 102) {
										button3.setBackgroundResource(R.drawable.truee);
										_true_();
									}
									else {
										if (num1 == 108) {
											button3.setBackgroundResource(R.drawable.truee);
											_true_();
										}
										else {
											if (num1 == 109) {
												button3.setBackgroundResource(R.drawable.truee);
												_true_();
											}
											else {
												if (num1 == 111) {
													button3.setBackgroundResource(R.drawable.truee);
													_true_();
												}
												else {
													if (num1 == 121) {
														button3.setBackgroundResource(R.drawable.truee);
														_true_();
													}
													else {
														button3.setBackgroundResource(R.drawable.red);
														_false_();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _btn4_que2 () {
		if (num1 == 82) {
			button4.setBackgroundResource(R.drawable.truee);
			_true_();
		}
		else {
			if (num1 == 84) {
				button4.setBackgroundResource(R.drawable.truee);
				_true_();
			}
			else {
				if (num1 == 90) {
					button4.setBackgroundResource(R.drawable.truee);
					_true_();
				}
				else {
					if (num1 == 92) {
						button4.setBackgroundResource(R.drawable.truee);
						_true_();
					}
					else {
						if (num1 == 96) {
							button4.setBackgroundResource(R.drawable.truee);
							_true_();
						}
						else {
							if (num1 == 104) {
								button4.setBackgroundResource(R.drawable.truee);
								_true_();
							}
							else {
								if (num1 == 105) {
									button4.setBackgroundResource(R.drawable.truee);
									_true_();
								}
								else {
									if (num1 == 110) {
										button4.setBackgroundResource(R.drawable.truee);
										_true_();
									}
									else {
										if (num1 == 112) {
											button4.setBackgroundResource(R.drawable.truee);
											_true_();
										}
										else {
											if (num1 == 118) {
												button4.setBackgroundResource(R.drawable.truee);
												_true_();
											}
											else {
												if (num1 == 119) {
													button4.setBackgroundResource(R.drawable.truee);
													_true_();
												}
												else {
													button4.setBackgroundResource(R.drawable.red);
													_false_();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _que6_ch2 () {
		if (num1 == 91) {
			textview1.setText("عند إضافة محلول NaOH الي محلول ملح.............. يتكون راسب بني محمر");
			button1.setText("نحاس II");
			button2.setText("حديد II");
			button3.setText("حديد III");
			button4.setText("الومنيوم");
			_reverse();
		}
		else {
			if (num1 == 92) {
				textview1.setText("أضيفت مادة................. الي محلول كبريتات الحديد الثنائي وعندما أضيف الي الناتج محلول NaOH تكون راسب بني محمر");
				button1.setText("H2");
				button2.setText("Co");
				button3.setText("C");
				button4.setText("Kmno4");
				_reverse();
			}
			else {
				if (num1 == 93) {
					textview1.setText("عند إضافة محلول قلوي الي احد محاليل الحديد الثلاثي يترسب............ ");
					button1.setText("هيدروكسيد الحديد III");
					button2.setText("هيدروكسيد الحديد II");
					button3.setText("اكسيد الحديد III");
					button4.setText("اكسيد الحديد II");
					_reverse();
				}
				else {
					if (num1 == 94) {
						textview1.setText("عند إضافة محلول كربونات الامونيوم الي محلول كلوريد الكالسيوم يتكون راسب");
						button1.setText("احمر");
						button2.setText("ابيض");
						button3.setText("أزرق");
						button4.setText("اصفر كناري");
						_reverse();
					}
					else {
						if (num1 == 95) {
							textview1.setText("تترسب كاتيونات المجموعة التحليلية...............علي هيئة كربونات");
							button1.setText("الثالثة");
							button2.setText("الرابعة");
							button3.setText("الخامسة");
							button4.setText("الاولي");
							_reverse();
						}
						else {
							if (num1 == 96) {
								textview1.setText("تترسب كاتيونات المجموعة التحليلية............علي هيئة كبريتيدات في الوسط الحامضي");
								button1.setText("الثالثة");
								button2.setText("الرابعة");
								button3.setText("الاولي");
								button4.setText("الثانية");
								_reverse();
							}
							else {
								if (num1 == 97) {
									textview1.setText("يتكون راسب............ عند إضافة محلول كلوريد الباريوم الي محلول فوسفات الصوديوم");
									button1.setText("ابيض");
									button2.setText("احمر");
									button3.setText("اصفر");
									button4.setText("اسود");
									_reverse();
								}
								else {
									if (num1 == 98) {
										textview1.setText("عند إضافة محلول نترات الفضة الي محلول كلوريد الصوديوم يتكون راسب لونه");
										button1.setText("اصفر");
										button2.setText("اخضر");
										button3.setText("ابيض");
										button4.setText("عديم اللون");
										_reverse();
									}
									else {
										if (num1 == 99) {
											textview1.setText("عند إضافة محلول اليود الي محلول ثيوكبريتات الصوديوم يزول اللون");
											button1.setText("البنفسجي");
											button2.setText("البني");
											button3.setText("الابيض");
											button4.setText("الاسود");
											_reverse();
										}
										else {
											if (num1 == 100) {
												textview1.setText("غاز So2 ............ورقة مبللة بمحلول ثاني كرومات البوتاسيوم المحمض");
												button1.setText("يسود");
												button2.setText("يزرق");
												button3.setText("يخضر");
												button4.setText("يحمر");
												_reverse();
											}
											else {
												if (num1 == 101) {
													textview1.setText("إحدي طرق التحليل الكيميائي تستخدم لمعرفة نسبة وتركيز كل مكون");
													button1.setText("التحليل الكمي");
													button2.setText("التحليل الوصفي");
													button3.setText("التحليل الكيفي");
													button4.setText("الانحلال الحراري");
													_reverse();
												}
												else {
													if (num1 == 102) {
														textview1.setText("كاشف المجموعة التحليلية الخامسة ");
														button1.setText("حمض الهيدروكلوريك");
														button2.setText("كبريتيد الهيدروجين");
														button3.setText("كربونات الامونيوم");
														button4.setText("هيدروكسيد الامونيوم");
														_reverse();
													}
													else {
														if (num1 == 103) {
															textview1.setText("احد فروع علم الكيمياء لعب دورا كبيرا في تطور المجالات العلمية المختلفة كالزراعة والطب");
															button1.setText("تحليل التربة");
															button2.setText("التحليل الكيميائي");
															button3.setText("التحليل العضوي");
															button4.setText("التحليل الوصفي");
															_reverse();
														}
														else {
															if (num1 == 104) {
																textview1.setText("تحليل كيميائي يهدف إلي التعرف على مكونات المادة سواء كانت نقية او مخلوط");
																button1.setText("التحليل الكمي");
																button2.setText("التحليل الذري");
																button3.setText("التحليل الكيميائي");
																button4.setText("التحليل الوصفي");
																_reverse();
															}
															else {
																if (num1 == 105) {
																	textview1.setText("مجموعة تحليلية تعتمد علي كربونات الامونيوم ككاشف لها");
																	button1.setText("الاولي");
																	button2.setText("الثانية");
																	button3.setText("الثالثة");
																	button4.setText("الخامسة");
																	_reverse();
																}
																else {
																	if (num1 == 106) {
																		textview1.setText("محلول مائي لإحد كاتيونات الكالسيوم يتعكر عند إمرار غاز CO2 فيه لمدة قصيره");
																		button1.setText("Ca(OH)2");
																		button2.setText("CaCO3");
																		button3.setText("NH4OH");
																		button4.setText("CaCl2");
																		_reverse();
																	}
																	else {
																		if (num1 == 107) {
																			textview1.setText("الأنيون الذي تذوب جميع املاحه في الماء");
																			button1.setText("هيدروكسيدات");
																			button2.setText("بيكربونات");
																			button3.setText("كبريتيدات");
																			button4.setText("أكسيدات");
																			_reverse();
																		}
																		else {
																			if (num1 == 108) {
																				textview1.setText("غاز عديم اللون يكون سحب بيضاء مع غاز النشادر");
																				button1.setText("ثاني اكسيد الكبريت");
																				button2.setText("ثاني اكسيد الكربون");
																				button3.setText("كلوريد الهيدروجين");
																				button4.setText("كبريتيد الهيدروجين");
																				_reverse();
																			}
																			else {
																				if (num1 == 109) {
																					textview1.setText("غاز عديم اللون يتحول إلى اللون البني المحمر عند ملامسته للهواء الجوي");
																					button1.setText("SO2");
																					button2.setText("HCl");
																					button3.setText("No");
																					button4.setText("H2S");
																					_reverse();
																				}
																				else {
																					if (num1 == 110) {
																						textview1.setText("أبخرة بنية حمراء تنتج من التحلل الحراري لحمض النيتريك");
																						button1.setText("SO2");
																						button2.setText("HCl");
																						button4.setText("No2");
																						button3.setText("H2S");
																						_reverse();
																					}
																					else {
																						if (num1 == 111) {
																							textview1.setText("اللون الذي تكونة كاتيونات الكالسيوم في الكشف الجاف");
																							button1.setText("ابيض");
																							button2.setText("اسود");
																							button3.setText("احمر طوبي");
																							button4.setText("اصفر");
																							_reverse();
																						}
																						else {
																							if (num1 == 112) {
																								textview1.setText("اللون الناتج من تفاعل أسيتات الرصاص الثنائي مع ملح كبريتات");
																								button1.setText("اخضر");
																								button2.setText("اسود");
																								button3.setText("احمر");
																								button4.setText("ابيض");
																								_reverse();
																							}
																							else {
																								if (num1 == 113) {
																									textview1.setText("يتحد 0.1mol من المركب XCl2 مع 10.8g من الماء لتكوين XCl2.nH2o فتكون قيمة n...........");
																									button1.setText("6");
																									button2.setText("10");
																									button3.setText("4");
																									button4.setText("2");
																									_reverse();
																								}
																								else {
																									_ch7_2();
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _ch7_2 () {
		if (num1 == 114) {
			textview1.setText("أنيون ينتمي الي مجموعة حمض الهيدروكلوريك المخفف ");
			button1.setText("الكربونات");
			button2.setText("الكلوريد");
			button3.setText("الكبريتات");
			button4.setText("الفوسفات");
			_reverse();
		}
		else {
			if (num1 == 115) {
				textview1.setText("أنيون ينتمي الي مجموعة حمض الكبريتيك المركز");
				button1.setText("الكالسيوم");
				button2.setText("الكلوريد");
				button3.setText("الكبريتات");
				button4.setText("الفوسفات");
				_reverse();
			}
			else {
				if (num1 == 116) {
					textview1.setText("يلزم لمعايرة 10mL من محلول هيدروكسيد البوتاسيوم تركيزه 1M..............من حمض الكبريتيك تركيزه 1M");
					button1.setText("2mL");
					button2.setText("5mL");
					button3.setText("20mL");
					button4.setText("10mL");
					_reverse();
				}
				else {
					if (num1 == 117) {
						textview1.setText("اذا تعادل 30mL من حمض النيتريك مع 10mL من هيدروكسيد الماغنسيوم تركيزه 0.3M فإن تركيز حمض النيتريك يساوي");
						button1.setText("0.2M");
						button2.setText("0.1M");
						button3.setText("0.02M");
						button4.setText("0.01M");
						_reverse();
					}
					else {
						if (num1 == 118) {
							textview1.setText("اذا تعادل 30mL من محلول حمض الكبريتيك تركيزه 0.2M مع حجم معين V من محلول هيدروكسيد البوتاسيوم تركيزه 0.6M فإن قيمة V ");
							button1.setText("60mL");
							button2.setText("50mL");
							button3.setText("30mL");
							button4.setText("20mL");
							_reverse();
						}
						else {
							if (num1 == 119) {
								textview1.setText("يتعادل 41.32mL من محلول HCl تركيزه 0.1077M تماما مع 50mL من محلول NaOH  تركيزه");
								button1.setText("7.66M");
								button2.setText("0.222M");
								button3.setText("0.131M");
								button4.setText("0.089M");
								_reverse();
							}
							else {
								if (num1 == 120) {
									textview1.setText("عند خلط حجمين متساويين من محلولي NaOH, H2SO4 تركيز كل منهما 1M فإن المحلول الناتج يكون");
									button1.setText("pH=7");
									button2.setText("حامضي");
									button3.setText("قلوي");
									button4.setText("pH>7");
									_reverse();
								}
								else {
									if (num1 == 121) {
										textview1.setText("عند خلط حجمين متساويين من محلولي NaOH, HCl تركيز كل منهما 0.5M يكون المحلول الناتج");
										button1.setText("حمضي");
										button2.setText("قلوي");
										button3.setText("متعادل");
										button4.setText("متردد");
										_reverse();
									}
									else {
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	private void _ch6_corr2 () {
		if (num1 == 117) {
			button1.setBackgroundResource(R.drawable.truee);
		}
		else {
			if (num1 == 118) {
				button4.setBackgroundResource(R.drawable.truee);
			}
			else {
				if (num1 == 119) {
					button4.setBackgroundResource(R.drawable.truee);
				}
				else {
					if (num1 == 120) {
						button2.setBackgroundResource(R.drawable.truee);
					}
					else {
						if (num1 == 121) {
							button3.setBackgroundResource(R.drawable.truee);
						}
						else {
							
						}
					}
				}
			}
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
