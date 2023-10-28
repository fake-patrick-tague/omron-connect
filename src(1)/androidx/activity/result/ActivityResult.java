package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ActivityResult
  implements Parcelable
{
  public static final Parcelable.Creator<ActivityResult> CREATOR = new a();
  private final int b;
  private final Intent items;
  
  public ActivityResult(int paramInt, Intent paramIntent)
  {
    b = paramInt;
    items = paramIntent;
  }
  
  ActivityResult(Parcel paramParcel)
  {
    b = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      paramParcel = null;
    } else {
      paramParcel = (Intent)Intent.CREATOR.createFromParcel(paramParcel);
    }
    items = paramParcel;
  }
  
  public static String print(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0) {
        return String.valueOf(paramInt);
      }
      return "RESULT_CANCELED";
    }
    return "RESULT_OK";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Intent get()
  {
    return items;
  }
  
  public int getValue()
  {
    return b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActivityResult{resultCode=");
    localStringBuilder.append(print(b));
    localStringBuilder.append(", data=");
    localStringBuilder.append(items);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(b);
    int i;
    if (items == null) {
      i = 0;
    } else {
      i = 1;
    }
    paramParcel.writeInt(i);
    Intent localIntent = items;
    if (localIntent != null) {
      localIntent.writeToParcel(paramParcel, paramInt);
    }
  }
  
  class a
    implements Parcelable.Creator<ActivityResult>
  {
    a() {}
    
    public ActivityResult[] a(int paramInt)
    {
      return new ActivityResult[paramInt];
    }
    
    public ActivityResult readDate(Parcel paramParcel)
    {
      return new ActivityResult(paramParcel);
    }
  }
}
