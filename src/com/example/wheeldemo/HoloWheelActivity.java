package com.example.wheeldemo;

import com.example.wheeldemo.adapters.AbstractWheelTextAdapter;
import com.example.wheeldemo.adapters.WheelView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HoloWheelActivity extends Activity implements OnClickListener {
	private WheelView cities,nao2,nao3,nao4;
	private AlarmManagerBroadcastReceiver alarm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.cities_holo_layout);
        
		cities = (WheelView) findViewById(R.id.city);
		cities.setVisibleItems(5); // Number of items
		cities.setWheelBackground(R.drawable.tiao);
		cities.setWheelForeground(R.drawable.wheel_val_holo);
		cities.setShadowColor(0xFFb58942, 0x88b58942, 0x00b58942);
		cities.setViewAdapter(new CityAdapter(this));
		cities.setCurrentItem(3);
		nao2 = (WheelView) findViewById(R.id.city2);
		nao2.setVisibleItems(5); // Number of items
		nao2.setWheelBackground(R.drawable.tiao);
		nao2.setWheelForeground(R.drawable.wheel_val_holo);
		nao2.setShadowColor(0xFFb58942, 0x88b58942, 0x00b58942);
		nao2.setViewAdapter(new CityAdapter(this));
		nao2.setCurrentItem(3);
		nao3 = (WheelView) findViewById(R.id.city3);
		nao3.setVisibleItems(5); // Number of items
		nao3.setWheelBackground(R.drawable.tiao);
		nao3.setWheelForeground(R.drawable.wheel_val_holo);
		nao3.setShadowColor(0xFFb58942, 0x88b58942, 0x00b58942);
		nao3.setViewAdapter(new CityAdapter(this));
		nao3.setCurrentItem(3);
		nao4 = (WheelView) findViewById(R.id.city4);
		nao4.setVisibleItems(5); // Number of items
		nao4.setWheelBackground(R.drawable.tiao);
		nao4.setWheelForeground(R.drawable.wheel_val_holo);
		nao4.setShadowColor(0xFFb58942, 0x88b58942, 0x00b58942);
		nao4.setViewAdapter(new CityAdapter(this));
		nao4.setCurrentItem(3);
		alarm = new AlarmManagerBroadcastReceiver();
		Button btn = (Button) findViewById(R.id.btn);
		Button btn2=(Button)findViewById(R.id.btn2);
		Button btn3=(Button)findViewById(R.id.btn3);
		Button btn4=(Button)findViewById(R.id.btn4);
		btn.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
	}

	private class CityAdapter extends AbstractWheelTextAdapter {
		final String cities[] = new String[] { "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37",
				"38", "39", "40", "41", "42", "43", "44", "45", "46", "47",
				"48", "49", "50", "51", "52", "53", "54", "55", "56", "57",
				"58", "59", "60" };

		protected CityAdapter(Context context) {
			super(context, R.layout.city_holo_layout, NO_RESOURCE);

			setItemTextResource(R.id.city_name);
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			return view;
		}

		public int getItemsCount() {
			return cities.length;
		}

		protected CharSequence getItemText(int index) {
			return cities[index];
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int i = cities.getCurrentItem() + 1;
		alarm.SetAlarm(HoloWheelActivity.this, i);
		Toast.makeText(HoloWheelActivity.this, "value of i is what",
				Toast.LENGTH_SHORT).show();
	}
}
