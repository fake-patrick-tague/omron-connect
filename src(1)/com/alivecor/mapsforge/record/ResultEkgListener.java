package com.alivecor.mapsforge.record;

public abstract interface ResultEkgListener
{
  public abstract void onFailure(ResultError paramResultError);
  
  public abstract void onSuccess();
}
