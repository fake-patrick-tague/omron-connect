package androidx.fragment.package_11;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<androidx.fragment.app.BackStackState> CREATOR = new a();
  final List<androidx.fragment.app.BackStackRecordState> participants;
  final List<String> tags;
  
  BackStackState(Parcel paramParcel)
  {
    tags = paramParcel.createStringArrayList();
    participants = paramParcel.createTypedArrayList(BackStackRecordState.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(tags);
    paramParcel.writeTypedList(participants);
  }
  
  class a
    implements Parcelable.Creator<androidx.fragment.app.BackStackState>
  {
    a() {}
    
    public BackStackState[] a(int paramInt)
    {
      return new BackStackState[paramInt];
    }
    
    public BackStackState readDate(Parcel paramParcel)
    {
      return new BackStackState(paramParcel);
    }
  }
}
