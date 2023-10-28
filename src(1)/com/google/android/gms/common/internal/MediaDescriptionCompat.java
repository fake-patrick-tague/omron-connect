package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="ConnectionInfoCreator")
public final class MediaDescriptionCompat
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzj> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(id=4)
  ConnectionTelemetryConfiguration added;
  @SafeParcelable.Field(defaultValue="0", id=3)
  int hasDueTime;
  @SafeParcelable.Field(id=1)
  Bundle mExtras;
  @SafeParcelable.Field(id=2)
  Feature[] mMediaUri;
  
  public MediaDescriptionCompat() {}
  
  MediaDescriptionCompat(Bundle paramBundle, Feature[] paramArrayOfFeature, int paramInt, ConnectionTelemetryConfiguration paramConnectionTelemetryConfiguration)
  {
    mExtras = paramBundle;
    mMediaUri = paramArrayOfFeature;
    hasDueTime = paramInt;
    added = paramConnectionTelemetryConfiguration;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, mExtras, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, mMediaUri, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, hasDueTime);
    SafeParcelWriter.writeParcelable(paramParcel, 4, added, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
