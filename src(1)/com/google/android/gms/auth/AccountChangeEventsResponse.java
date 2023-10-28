package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@SafeParcelable.Class(creator="AccountChangeEventsResponseCreator")
public class AccountChangeEventsResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.VersionField(id=1)
  private final int mInputType;
  @SafeParcelable.Field(id=2)
  private final List<AccountChangeEvent> mMenuItems;
  
  AccountChangeEventsResponse(int paramInt, List paramList)
  {
    mInputType = paramInt;
    mMenuItems = ((List)Preconditions.checkNotNull(paramList));
  }
  
  public AccountChangeEventsResponse(List paramList)
  {
    mInputType = 1;
    mMenuItems = ((List)Preconditions.checkNotNull(paramList));
  }
  
  public List getEvents()
  {
    return mMenuItems;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mInputType);
    SafeParcelWriter.writeTypedList(paramParcel, 2, mMenuItems, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
