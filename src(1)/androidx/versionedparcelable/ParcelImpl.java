package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
  private final Message message;
  
  protected ParcelImpl(Parcel paramParcel)
  {
    message = new b(paramParcel).add();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new b(paramParcel).add(message);
  }
  
  static final class a
    implements Parcelable.Creator<ParcelImpl>
  {
    a() {}
    
    public ParcelImpl[] a(int paramInt)
    {
      return new ParcelImpl[paramInt];
    }
    
    public ParcelImpl readDate(Parcel paramParcel)
    {
      return new ParcelImpl(paramParcel);
    }
  }
}
