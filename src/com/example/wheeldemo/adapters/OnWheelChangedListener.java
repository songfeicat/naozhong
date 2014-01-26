package com.example.wheeldemo.adapters;

import com.example.wheeldemo.adapters.WheelView;

public interface OnWheelChangedListener {
  void onChanged(WheelView wheel,int oldValue,int newValue);
}
