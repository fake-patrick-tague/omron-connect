package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.DataPoint;

public abstract interface OnDataPointListener
{
  public abstract void onDataPoint(DataPoint paramDataPoint);
}
