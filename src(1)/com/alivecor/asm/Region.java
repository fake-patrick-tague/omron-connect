package com.alivecor.asm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alivecor.ai.u.b;
import com.google.gson.v.c;
import java.io.Serializable;

public class Region
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<u.b> CREATOR = new u.b.a();
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int WEEKS_BUFFER = 1;
  @c("inverted")
  private int mHeight;
  @c("inversion_probability")
  private float mWidth;
  
  public Region() {}
  
  protected Region(Parcel paramParcel)
  {
    mHeight = paramParcel.readInt();
    mWidth = paramParcel.readFloat();
  }
  
  public void add(float paramFloat)
  {
    mWidth = paramFloat;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getHeight()
  {
    return mHeight;
  }
  
  public float getWidth()
  {
    return mWidth;
  }
  
  public void setValue(int paramInt)
  {
    mHeight = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Result{inverted=");
    localStringBuilder.append(mHeight);
    localStringBuilder.append(", inversionProb=");
    localStringBuilder.append(mWidth);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mHeight);
    paramParcel.writeFloat(mWidth);
  }
}
