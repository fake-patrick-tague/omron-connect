package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@Deprecated
@KeepForSdk
@SafeParcelable.Class(creator="WakeLockEventCreator")
public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new VerticalProgressBar.SavedState.1();
  private long index;
  @SafeParcelable.Field(getter="getCallingPackages", id=6)
  private final List mArgs;
  @SafeParcelable.Field(getter="getAcquiredWithTimeout", id=18)
  private final boolean mAuthor;
  @SafeParcelable.Field(getter="getWakeLockName", id=4)
  private final String mId;
  @SafeParcelable.Field(getter="getHostPackage", id=13)
  private final String mKey;
  @SafeParcelable.Field(getter="getElapsedRealtime", id=8)
  private final long mLength;
  @SafeParcelable.Field(getter="getEventType", id=11)
  private int mLocalPath;
  @SafeParcelable.Field(getter="getWakeLockType", id=5)
  private final int mMessage;
  @SafeParcelable.Field(getter="getEventKey", id=12)
  private final String mMimeType;
  @SafeParcelable.Field(getter="getTimeMillis", id=2)
  private final long mPath;
  @SafeParcelable.VersionField(id=1)
  final int mStorageId;
  @SafeParcelable.Field(getter="getTimeout", id=16)
  private final long mTime;
  @SafeParcelable.Field(getter="getCodePackage", id=17)
  private final String mTitle;
  @SafeParcelable.Field(getter="getDeviceState", id=14)
  private int mType;
  @SafeParcelable.Field(getter="getSecondaryWakeLockName", id=10)
  private final String mValue;
  @SafeParcelable.Field(getter="getBeginPowerPercentage", id=15)
  private final float this$0;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean)
  {
    mStorageId = paramInt1;
    mPath = paramLong1;
    mLocalPath = paramInt2;
    mId = paramString1;
    mValue = paramString3;
    mTitle = paramString5;
    mMessage = paramInt3;
    index = -1L;
    mArgs = paramList;
    mMimeType = paramString2;
    mLength = paramLong2;
    mType = paramInt4;
    mKey = paramString4;
    this$0 = paramFloat;
    mTime = paramLong3;
    mAuthor = paramBoolean;
  }
  
  public final int getPath()
  {
    return mLocalPath;
  }
  
  public final String getString()
  {
    Object localObject1 = mArgs;
    String str = mId;
    int i = mMessage;
    Object localObject4 = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = TextUtils.join(",", (Iterable)localObject1);
    }
    int j = mType;
    Object localObject3 = mValue;
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject5 = mKey;
    localObject3 = localObject5;
    if (localObject5 == null) {
      localObject3 = "";
    }
    float f = this$0;
    localObject5 = mTitle;
    if (localObject5 != null) {
      localObject4 = localObject5;
    }
    boolean bool = mAuthor;
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(str);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(i);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(j);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(f);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject4);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(bool);
    return ((StringBuilder)localObject5).toString();
  }
  
  public final long getTokenIndex()
  {
    return index;
  }
  
  public final long path()
  {
    return mPath;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mStorageId);
    SafeParcelWriter.writeLong(paramParcel, 2, mPath);
    SafeParcelWriter.writeString(paramParcel, 4, mId, false);
    SafeParcelWriter.writeInt(paramParcel, 5, mMessage);
    SafeParcelWriter.writeStringList(paramParcel, 6, mArgs, false);
    SafeParcelWriter.writeLong(paramParcel, 8, mLength);
    SafeParcelWriter.writeString(paramParcel, 10, mValue, false);
    SafeParcelWriter.writeInt(paramParcel, 11, mLocalPath);
    SafeParcelWriter.writeString(paramParcel, 12, mMimeType, false);
    SafeParcelWriter.writeString(paramParcel, 13, mKey, false);
    SafeParcelWriter.writeInt(paramParcel, 14, mType);
    SafeParcelWriter.writeFloat(paramParcel, 15, this$0);
    SafeParcelWriter.writeLong(paramParcel, 16, mTime);
    SafeParcelWriter.writeString(paramParcel, 17, mTitle, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, mAuthor);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
