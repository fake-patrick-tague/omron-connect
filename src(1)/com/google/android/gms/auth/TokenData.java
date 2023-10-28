package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@SafeParcelable.Class(creator="TokenDataCreator")
public class TokenData
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<TokenData> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getExpirationTimeSecs", id=3)
  private final Long data;
  @SafeParcelable.VersionField(id=1)
  private final int id;
  @SafeParcelable.Field(getter="isSnowballed", id=5)
  private final boolean isVisible;
  @SafeParcelable.Field(getter="getToken", id=2)
  private final String mimeType;
  @SafeParcelable.Field(getter="isCached", id=4)
  private final boolean text;
  @SafeParcelable.Field(getter="getGrantedScopes", id=6)
  private final List<String> zzaa;
  @SafeParcelable.Field(getter="getScopeData", id=7)
  private final String zzab;
  
  TokenData(int paramInt, String paramString1, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List paramList, String paramString2)
  {
    id = paramInt;
    mimeType = Preconditions.checkNotEmpty(paramString1);
    data = paramLong;
    text = paramBoolean1;
    isVisible = paramBoolean2;
    zzaa = paramList;
    zzab = paramString2;
  }
  
  public static TokenData load(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    return (TokenData)paramBundle.getParcelable("TokenData");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData)) {
      return false;
    }
    paramObject = (TokenData)paramObject;
    return (TextUtils.equals(mimeType, mimeType)) && (Objects.equal(data, data)) && (text == text) && (isVisible == isVisible) && (Objects.equal(zzaa, zzaa)) && (Objects.equal(zzab, zzab));
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { mimeType, data, Boolean.valueOf(text), Boolean.valueOf(isVisible), zzaa, zzab });
  }
  
  public final String mimeType()
  {
    return mimeType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, id);
    SafeParcelWriter.writeString(paramParcel, 2, mimeType, false);
    SafeParcelWriter.writeLongObject(paramParcel, 3, data, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, text);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isVisible);
    SafeParcelWriter.writeStringList(paramParcel, 6, zzaa, false);
    SafeParcelWriter.writeString(paramParcel, 7, zzab, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
