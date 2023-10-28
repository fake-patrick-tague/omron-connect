package androidx.viewpager2.adapter;

import android.os.Parcelable;

public abstract interface Fragment
{
  public abstract void a(Parcelable paramParcelable);
  
  public abstract Parcelable saveState();
}
