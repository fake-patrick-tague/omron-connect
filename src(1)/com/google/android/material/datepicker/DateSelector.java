package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

public abstract interface DateSelector<S>
  extends Parcelable
{
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, CalendarConstraints paramCalendarConstraints, p paramP);
  
  public abstract Object a();
  
  public abstract int add(Context paramContext);
  
  public abstract boolean booleanValue();
  
  public abstract Collection equals();
  
  public abstract Collection getText();
  
  public abstract String toString(Context paramContext);
  
  public abstract void trim(long paramLong);
}
