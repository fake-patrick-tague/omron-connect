package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="AccountChangeEventCreator")
public class AccountChangeEvent
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(id=2)
  private final long count;
  @SafeParcelable.VersionField(id=1)
  private final int level;
  @SafeParcelable.Field(id=3)
  private final String name;
  @SafeParcelable.Field(id=4)
  private final int priority;
  @SafeParcelable.Field(id=5)
  private final int tag;
  @SafeParcelable.Field(id=6)
  private final String text;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    level = paramInt1;
    count = paramLong;
    name = ((String)Preconditions.checkNotNull(paramString1));
    priority = paramInt2;
    tag = paramInt3;
    text = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    level = 1;
    count = paramLong;
    name = ((String)Preconditions.checkNotNull(paramString1));
    priority = paramInt1;
    tag = paramInt2;
    text = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof AccountChangeEvent))
    {
      paramObject = (AccountChangeEvent)paramObject;
      if ((level == level) && (count == count) && (Objects.equal(name, name)) && (priority == priority) && (tag == tag) && (Objects.equal(text, text))) {
        return true;
      }
    }
    return false;
  }
  
  public String getAccountName()
  {
    return name;
  }
  
  public String getChangeData()
  {
    return text;
  }
  
  public int getChangeType()
  {
    return priority;
  }
  
  public int getEventIndex()
  {
    return tag;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(level), Long.valueOf(count), name, Integer.valueOf(priority), Integer.valueOf(tag), text });
  }
  
  public String toString()
  {
    int i = priority;
    String str1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            str1 = "UNKNOWN";
          } else {
            str1 = "RENAMED_TO";
          }
        }
        else {
          str1 = "RENAMED_FROM";
        }
      }
      else {
        str1 = "REMOVED";
      }
    }
    else {
      str1 = "ADDED";
    }
    String str2 = name;
    String str3 = text;
    i = tag;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str2).length() + 91 + str1.length() + String.valueOf(str3).length());
    localStringBuilder.append("AccountChangeEvent {accountName = ");
    localStringBuilder.append(str2);
    localStringBuilder.append(", changeType = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", changeData = ");
    localStringBuilder.append(str3);
    localStringBuilder.append(", eventIndex = ");
    localStringBuilder.append(i);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, level);
    SafeParcelWriter.writeLong(paramParcel, 2, count);
    SafeParcelWriter.writeString(paramParcel, 3, name, false);
    SafeParcelWriter.writeInt(paramParcel, 4, priority);
    SafeParcelWriter.writeInt(paramParcel, 5, tag);
    SafeParcelWriter.writeString(paramParcel, 6, text, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
