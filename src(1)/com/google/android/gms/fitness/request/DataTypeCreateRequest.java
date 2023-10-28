package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.fitness.zzbi;
import com.google.android.gms.internal.fitness.zzbl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
@SafeParcelable.Class(creator="DataTypeCreateRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public class DataTypeCreateRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new SpecialListsProgressProperty.1();
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @SafeParcelable.Field(getter="getFields", id=2)
  private final List<Field> zzlz;
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzbi zzrj;
  
  private DataTypeCreateRequest(Builder paramBuilder)
  {
    this(Builder.getAttributeName(paramBuilder), Builder.getSoundPath(paramBuilder), null);
  }
  
  public DataTypeCreateRequest(DataTypeCreateRequest paramDataTypeCreateRequest, zzbi paramZzbi)
  {
    this(name, zzlz, paramZzbi);
  }
  
  DataTypeCreateRequest(String paramString, List paramList, IBinder paramIBinder)
  {
    name = paramString;
    zzlz = Collections.unmodifiableList(paramList);
    if (paramIBinder == null) {
      paramString = null;
    } else {
      paramString = zzbl.asInterface(paramIBinder);
    }
    zzrj = paramString;
  }
  
  private DataTypeCreateRequest(String paramString, List paramList, zzbi paramZzbi)
  {
    name = paramString;
    zzlz = Collections.unmodifiableList(paramList);
    zzrj = paramZzbi;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataTypeCreateRequest)) {
      return false;
    }
    paramObject = (DataTypeCreateRequest)paramObject;
    return (Objects.equal(name, name)) && (Objects.equal(zzlz, zzlz));
  }
  
  public List getFields()
  {
    return zzlz;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { name, zzlz });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("name", name).name("fields", zzlz).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getFields(), false);
    Object localObject = zzrj;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String name;
    private final List<Field> zzlz = new ArrayList();
    
    public Builder() {}
    
    public Builder addField(Field paramField)
    {
      if (!zzlz.contains(paramField)) {
        zzlz.add(paramField);
      }
      return this;
    }
    
    public Builder addField(String paramString, int paramInt)
    {
      boolean bool;
      if ((paramString != null) && (!paramString.isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid name specified");
      return addField(new Field(paramString, paramInt));
    }
    
    public DataTypeCreateRequest build()
    {
      boolean bool;
      if (name != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Must set the name");
      Preconditions.checkState(zzlz.isEmpty() ^ true, "Must specify the data fields");
      return new DataTypeCreateRequest(this, null);
    }
    
    public Builder setName(String paramString)
    {
      name = paramString;
      return this;
    }
  }
}
