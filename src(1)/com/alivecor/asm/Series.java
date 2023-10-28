package com.alivecor.asm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alivecor.ai.r;
import com.alivecor.ai.u;
import com.alivecor.ai.u.b;
import com.alivecor.neuralsuite.NeuralSuite.InversionResult;
import java.io.Serializable;

public class Series
  extends r<u.b>
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<u> CREATOR = new AppCompatDelegateImplV7.PanelFeatureState.SavedState.1();
  
  public Series() {}
  
  protected Series(Parcel paramParcel)
  {
    e = paramParcel.readString();
    d = paramParcel.readString();
    c = paramParcel.readString();
    a = ((Serializable)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public Series(NeuralSuite.InversionResult paramInversionResult)
  {
    if (status == 0)
    {
      Region localRegion = new Region();
      a = localRegion;
      Region.set(localRegion, probability);
      localRegion = (Region)a;
      int i;
      if (inverted) {
        i = 1;
      } else {
        i = 2;
      }
      Region.set(localRegion, i);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InversionData{result=");
    localStringBuilder.append(a);
    localStringBuilder.append(", kardiaAiVersionMajor='");
    localStringBuilder.append(e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", kardiaAiVersionMinor='");
    localStringBuilder.append(d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", kardiaAiVersionRev='");
    localStringBuilder.append(c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(e);
    paramParcel.writeString(d);
    paramParcel.writeString(c);
    paramParcel.writeParcelable((Parcelable)a, paramInt);
  }
}
