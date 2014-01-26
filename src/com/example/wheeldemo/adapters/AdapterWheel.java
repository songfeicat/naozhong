package com.example.wheeldemo.adapters;

import android.content.Context;

public class AdapterWheel extends AbstractWheelTextAdapter{
	private WheelAdapter adapter;
	
	public AdapterWheel(Context context, WheelAdapter adapter) {
        super(context);
        this.adapter = adapter;
	}
	public WheelAdapter getAdapter() {
        return adapter;
    }
	
	@Override
	public int getItemsCount() {
		// TODO Auto-generated method stub
		return adapter.getItemsCount();
	}

	@Override
	protected CharSequence getItemText(int index) {
		// TODO Auto-generated method stub
		return adapter.getItem(index);
	}
}