package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator="GoogleCertificatesLookupQueryCreator")
public final class ModuleInformation
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzo> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(getter="getIsChimeraPackage", id=5)
  private final boolean isVisible;
  @SafeParcelable.Field(getter="getCallingContextBinder", id=4, type="android.os.IBinder")
  private final Context mCommands;
  @SafeParcelable.Field(getter="getCallingPackage", id=1)
  private final String mHelp;
  @SafeParcelable.Field(defaultValue="false", getter="getIgnoreTestKeysOverride", id=3)
  private final boolean mModuleName;
  @SafeParcelable.Field(getter="getAllowTestKeys", id=2)
  private final boolean mModulePackage;
  
  ModuleInformation(String paramString, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder, boolean paramBoolean3)
  {
    mHelp = paramString;
    mModulePackage = paramBoolean1;
    mModuleName = paramBoolean2;
    mCommands = ((Context)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder)));
    isVisible = paramBoolean3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, mHelp, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, mModulePackage);
    SafeParcelWriter.writeBoolean(paramParcel, 3, mModuleName);
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)ObjectWrapper.wrap(mCommands), false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isVisible);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
