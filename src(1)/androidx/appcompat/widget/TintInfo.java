package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public class TintInfo
{
  public boolean mHasTintList;
  public boolean mHasTintMode;
  public ColorStateList mTintList;
  public PorterDuff.Mode mTintMode;
  
  public TintInfo() {}
  
  void clear()
  {
    mTintList = null;
    mHasTintList = false;
    mTintMode = null;
    mHasTintMode = false;
  }
}
