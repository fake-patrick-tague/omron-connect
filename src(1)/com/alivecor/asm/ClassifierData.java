package com.alivecor.asm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alivecor.ai.r;
import com.google.gson.v.c;
import java.io.Serializable;

public class ClassifierData
  extends r<com.alivecor.ai.ClassifierData.b>
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<com.alivecor.ai.ClassifierData> CREATOR = new a();
  
  public ClassifierData() {}
  
  protected ClassifierData(Parcel paramParcel)
  {
    a = ((Serializable)paramParcel.readParcelable(com.alivecor.ai.ClassifierData.b.class.getClassLoader()));
    e = paramParcel.readString();
    d = paramParcel.readString();
    c = paramParcel.readString();
  }
  
  public ClassifierData(Priority paramPriority)
  {
    b localB = new b();
    a = localB;
    localB.setDetermination(paramPriority);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClassifierData{result=");
    localStringBuilder.append(a);
    localStringBuilder.append(", kardiaAiVersionMajor=");
    localStringBuilder.append(e);
    localStringBuilder.append(", kardiaAiVersionMinor=");
    localStringBuilder.append(d);
    localStringBuilder.append(", kardiaAiVersionRev=");
    localStringBuilder.append(c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable((Parcelable)a, paramInt);
    paramParcel.writeString(e);
    paramParcel.writeString(d);
    paramParcel.writeString(c);
  }
  
  class a
    implements Parcelable.Creator<com.alivecor.ai.ClassifierData>
  {
    a() {}
    
    public ClassifierData[] a(int paramInt)
    {
      return new ClassifierData[paramInt];
    }
    
    public ClassifierData readDate(Parcel paramParcel)
    {
      return new ClassifierData(paramParcel);
    }
  }
  
  public class b
    implements Parcelable, Serializable
  {
    public static final Parcelable.Creator<com.alivecor.ai.ClassifierData.b> CREATOR = new a();
    @c("value")
    private Priority op;
    
    public b() {}
    
    protected b()
    {
      int i = this$1.readInt();
      if (i >= 0) {
        op = Priority.values()[i];
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public Priority getDetermination()
    {
      return op;
    }
    
    public void setDetermination(Priority paramPriority)
    {
      op = paramPriority;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Result{determination=");
      localStringBuilder.append(op);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Priority localPriority = op;
      if (localPriority != null) {
        paramInt = localPriority.ordinal();
      } else {
        paramInt = -1;
      }
      paramParcel.writeInt(paramInt);
    }
    
    class a
      implements Parcelable.Creator<com.alivecor.ai.ClassifierData.b>
    {
      a() {}
      
      public ClassifierData.b[] a(int paramInt)
      {
        return new ClassifierData.b[paramInt];
      }
      
      public ClassifierData.b readDate(Parcel paramParcel)
      {
        return new ClassifierData.b(paramParcel);
      }
    }
  }
}
