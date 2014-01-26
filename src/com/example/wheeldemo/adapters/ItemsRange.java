package com.example.wheeldemo.adapters;

public class ItemsRange {
  private int first;
  private int count;
  public ItemsRange(){
	  this(0,0);
  }
public ItemsRange(int i, int j) {
	// TODO Auto-generated constructor stub
	this.first=i;
	this.count=j;
}

public int getFirst(){
	return first;
}

public int getLast(){
	return getFirst()+getCount()-1;
}

public int getCount(){
	return count;
}

public boolean contains(int index){
	return index>=getFirst()&&index<=getLast();
}
}
