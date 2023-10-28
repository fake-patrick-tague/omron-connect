package com.alivecor.mapsforge.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.c;
import java.util.Objects;

public final class RecordingConfig
  implements Parcelable
{
  public static final Parcelable.Creator<com.alivecor.ecg.record.RecordingConfig> CREATOR = new Parcelable.Creator()
  {
    public RecordingConfig createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RecordingConfig(paramAnonymousParcel);
    }
    
    public RecordingConfig[] newArray(int paramAnonymousInt)
    {
      return new RecordingConfig[paramAnonymousInt];
    }
  };
  public final Direction deviceLeads;
  public final boolean restrictTriangleConnection = false;
  public final c selectedDevice;
  
  protected RecordingConfig(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i >= 0) {
      selectedDevice = c.values()[i];
    } else {
      selectedDevice = null;
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      deviceLeads = Direction.values()[i];
      return;
    }
    deviceLeads = null;
  }
  
  public RecordingConfig(c paramC, Direction paramDirection, boolean paramBoolean)
  {
    selectedDevice = paramC;
    deviceLeads = paramDirection;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (com.alivecor.ecg.record.RecordingConfig.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (RecordingConfig)paramObject;
      if ((selectedDevice == selectedDevice) && (deviceLeads == deviceLeads)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { selectedDevice, deviceLeads, Boolean.FALSE });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordingConfig{selectedDevice=");
    localStringBuilder.append(selectedDevice);
    localStringBuilder.append(", deviceLeads=");
    localStringBuilder.append(deviceLeads);
    localStringBuilder.append(", restrictTriangleConnection=");
    localStringBuilder.append(false);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte((byte)0);
    Object localObject = selectedDevice;
    if (localObject != null) {
      paramParcel.writeInt(((Enum)localObject).ordinal());
    } else {
      paramParcel.writeInt(-1);
    }
    localObject = deviceLeads;
    if (localObject != null)
    {
      paramParcel.writeInt(((Enum)localObject).ordinal());
      return;
    }
    paramParcel.writeInt(-1);
  }
}
