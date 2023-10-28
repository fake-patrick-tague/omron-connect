package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@SafeParcelable.Class(creator="AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20})
public final class Item
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzq> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(id=8)
  public final String address;
  @SafeParcelable.Field(id=12)
  public final String body;
  @SafeParcelable.Field(id=18)
  public final boolean c;
  @SafeParcelable.Field(id=27)
  public final String content;
  @SafeParcelable.Field(id=22)
  public final long count;
  @SafeParcelable.Field(id=21)
  public final Boolean current;
  @SafeParcelable.Field(id=7)
  public final long data;
  @SafeParcelable.Field(id=10)
  public final boolean enabled;
  @SafeParcelable.Field(id=19)
  public final String id;
  @SafeParcelable.Field(id=15)
  public final int index;
  @SafeParcelable.Field(id=3)
  public final String key;
  @Deprecated
  @SafeParcelable.Field(id=13)
  public final long lastModified;
  @SafeParcelable.Field(id=2)
  public final String name;
  @SafeParcelable.Field(defaultValue="", id=26)
  public final String path;
  @SafeParcelable.Field(id=14)
  public final long size;
  @SafeParcelable.Field(id=4)
  public final String source;
  @SafeParcelable.Field(id=24)
  public final String status;
  @SafeParcelable.Field(id=23)
  public final List tags;
  @SafeParcelable.Field(defaultValue="true", id=16)
  public final boolean text;
  @SafeParcelable.Field(defaultValueUnchecked="Integer.MIN_VALUE", id=11)
  public final long timestamp;
  @SafeParcelable.Field(id=5)
  public final String title;
  @SafeParcelable.Field(defaultValue="true", id=9)
  public final boolean type;
  @SafeParcelable.Field(defaultValue="", id=25)
  public final String url;
  @SafeParcelable.Field(id=6)
  public final long value;
  
  Item(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, String paramString7, Boolean paramBoolean, long paramLong6, List paramList, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    Preconditions.checkNotEmpty(paramString1);
    name = paramString1;
    if (true == TextUtils.isEmpty(paramString2)) {
      paramString2 = null;
    }
    key = paramString2;
    source = paramString3;
    timestamp = paramLong1;
    title = paramString4;
    value = paramLong2;
    data = paramLong3;
    address = paramString5;
    type = paramBoolean1;
    enabled = paramBoolean2;
    body = paramString6;
    lastModified = 0L;
    size = paramLong5;
    index = paramInt;
    text = paramBoolean3;
    c = paramBoolean4;
    id = paramString7;
    current = paramBoolean;
    count = paramLong6;
    tags = paramList;
    status = null;
    url = paramString9;
    path = paramString10;
    content = paramString11;
  }
  
  Item(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, String paramString7, Boolean paramBoolean, long paramLong6, List paramList, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    name = paramString1;
    key = paramString2;
    source = paramString3;
    timestamp = paramLong3;
    title = paramString4;
    value = paramLong1;
    data = paramLong2;
    address = paramString5;
    type = paramBoolean1;
    enabled = paramBoolean2;
    body = paramString6;
    lastModified = paramLong4;
    size = paramLong5;
    index = paramInt;
    text = paramBoolean3;
    c = paramBoolean4;
    id = paramString7;
    current = paramBoolean;
    count = paramLong6;
    tags = paramList;
    status = paramString8;
    url = paramString9;
    path = paramString10;
    content = paramString11;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, name, false);
    SafeParcelWriter.writeString(paramParcel, 3, key, false);
    SafeParcelWriter.writeString(paramParcel, 4, source, false);
    SafeParcelWriter.writeString(paramParcel, 5, title, false);
    SafeParcelWriter.writeLong(paramParcel, 6, value);
    SafeParcelWriter.writeLong(paramParcel, 7, data);
    SafeParcelWriter.writeString(paramParcel, 8, address, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, type);
    SafeParcelWriter.writeBoolean(paramParcel, 10, enabled);
    SafeParcelWriter.writeLong(paramParcel, 11, timestamp);
    SafeParcelWriter.writeString(paramParcel, 12, body, false);
    SafeParcelWriter.writeLong(paramParcel, 13, lastModified);
    SafeParcelWriter.writeLong(paramParcel, 14, size);
    SafeParcelWriter.writeInt(paramParcel, 15, index);
    SafeParcelWriter.writeBoolean(paramParcel, 16, text);
    SafeParcelWriter.writeBoolean(paramParcel, 18, c);
    SafeParcelWriter.writeString(paramParcel, 19, id, false);
    SafeParcelWriter.writeBooleanObject(paramParcel, 21, current, false);
    SafeParcelWriter.writeLong(paramParcel, 22, count);
    SafeParcelWriter.writeStringList(paramParcel, 23, tags, false);
    SafeParcelWriter.writeString(paramParcel, 24, status, false);
    SafeParcelWriter.writeString(paramParcel, 25, url, false);
    SafeParcelWriter.writeString(paramParcel, 26, path, false);
    SafeParcelWriter.writeString(paramParcel, 27, content, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
