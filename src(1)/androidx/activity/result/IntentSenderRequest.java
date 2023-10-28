package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class IntentSenderRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();
  private final Intent intent;
  private final IntentSender mIcon;
  private final int rssi;
  private final int txPower;
  
  IntentSenderRequest(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2)
  {
    mIcon = paramIntentSender;
    intent = paramIntent;
    txPower = paramInt1;
    rssi = paramInt2;
  }
  
  IntentSenderRequest(Parcel paramParcel)
  {
    mIcon = ((IntentSender)paramParcel.readParcelable(IntentSender.class.getClassLoader()));
    intent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    txPower = paramParcel.readInt();
    rssi = paramParcel.readInt();
  }
  
  public int b()
  {
    return rssi;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IntentSender getIcon()
  {
    return mIcon;
  }
  
  public Intent getIntent()
  {
    return intent;
  }
  
  public int getString()
  {
    return txPower;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(mIcon, paramInt);
    paramParcel.writeParcelable(intent, paramInt);
    paramParcel.writeInt(txPower);
    paramParcel.writeInt(rssi);
  }
  
  class a
    implements Parcelable.Creator<IntentSenderRequest>
  {
    a() {}
    
    public IntentSenderRequest[] a(int paramInt)
    {
      return new IntentSenderRequest[paramInt];
    }
    
    public IntentSenderRequest readDate(Parcel paramParcel)
    {
      return new IntentSenderRequest(paramParcel);
    }
  }
  
  public static final class b
  {
    private IntentSender d;
    private Intent f;
    private int j;
    private int l;
    
    public b(IntentSender paramIntentSender)
    {
      d = paramIntentSender;
    }
    
    public b a(int paramInt1, int paramInt2)
    {
      l = paramInt1;
      j = paramInt2;
      return this;
    }
    
    public b a(Intent paramIntent)
    {
      f = paramIntent;
      return this;
    }
    
    public IntentSenderRequest e()
    {
      return new IntentSenderRequest(d, f, j, l);
    }
  }
}
