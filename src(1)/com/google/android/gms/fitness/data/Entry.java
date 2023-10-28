package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@ShowFirstParty
@SafeParcelable.Class(creator="ApplicationCreator")
@SafeParcelable.Reserved({2, 3, 1000})
public final class Entry
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zza> CREATOR = new SpecialListsDueExistsProperty.1();
  public static final Entry zzlb = new Entry("com.google.android.gms");
  @SafeParcelable.Field(getter="getPackageName", id=1)
  private final String packageName;
  
  public Entry(String paramString)
  {
    packageName = ((String)Preconditions.checkNotNull(paramString));
  }
  
  public static Entry getEntry(String paramString)
  {
    if ("com.google.android.gms".equals(paramString)) {
      return zzlb;
    }
    return new Entry(paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Entry)) {
      return false;
    }
    paramObject = (Entry)paramObject;
    return packageName.equals(packageName);
  }
  
  public final String getPackageName()
  {
    return packageName;
  }
  
  public final int hashCode()
  {
    return packageName.hashCode();
  }
  
  public final String toString()
  {
    return String.format("Application{%s}", new Object[] { packageName });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, packageName, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
