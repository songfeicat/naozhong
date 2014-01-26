package com.example.wheeldemo.adapters;

import android.content.Context;


public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter {
	private T items[];
	public ArrayWheelAdapter(Context context, T items[]) {
        super(context);
        
        //setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        this.items = items;
    }
	@Override
	public int getItemsCount() {
		// TODO Auto-generated method stub
		return items.length;
	}
    
	@Override
	protected CharSequence getItemText(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < items.length) {
            T item = items[index];
            if (item instanceof CharSequence) {
                return (CharSequence) item;
            }
            return item.toString();
        }
        return null;
	}

}
