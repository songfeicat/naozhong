package com.example.wheeldemo.adapters;

import com.example.wheeldemo.adapters.WheelView;

public interface OnWheelScrollListener {
  void onScrollingStarted(WheelView wheel);
  void onScrollingFinished(WheelView wheel);
}
