package androidx.fragment.package_11;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<androidx.fragment.app.FragmentManagerState> CREATOR = new a();
  ArrayList<String> c;
  BackStackRecordState[] data;
  ArrayList<androidx.fragment.app.BackStackState> groups = new ArrayList();
  ArrayList<String> id;
  ArrayList<String> images = new ArrayList();
  ArrayList<androidx.fragment.app.FragmentManager.LaunchedFragmentInfo> tasks;
  String text = null;
  int value;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    c = paramParcel.createStringArrayList();
    id = paramParcel.createStringArrayList();
    data = ((BackStackRecordState[])paramParcel.createTypedArray(BackStackRecordState.CREATOR));
    value = paramParcel.readInt();
    text = paramParcel.readString();
    images = paramParcel.createStringArrayList();
    groups = paramParcel.createTypedArrayList(BackStackState.CREATOR);
    tasks = paramParcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(c);
    paramParcel.writeStringList(id);
    paramParcel.writeTypedArray(data, paramInt);
    paramParcel.writeInt(value);
    paramParcel.writeString(text);
    paramParcel.writeStringList(images);
    paramParcel.writeTypedList(groups);
    paramParcel.writeTypedList(tasks);
  }
  
  class a
    implements Parcelable.Creator<androidx.fragment.app.FragmentManagerState>
  {
    a() {}
    
    public FragmentManagerState[] a(int paramInt)
    {
      return new FragmentManagerState[paramInt];
    }
    
    public FragmentManagerState readDate(Parcel paramParcel)
    {
      return new FragmentManagerState(paramParcel);
    }
  }
}
