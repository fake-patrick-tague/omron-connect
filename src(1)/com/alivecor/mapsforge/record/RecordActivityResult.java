package com.alivecor.mapsforge.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alivecor.upgrade.AliveCorEcg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecordActivityResult
  implements Parcelable
{
  public static final Parcelable.Creator<com.alivecor.ecg.record.RecordActivityResult> CREATOR = new Parcelable.Creator()
  {
    public RecordActivityResult createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RecordActivityResult(paramAnonymousParcel);
    }
    
    public RecordActivityResult[] newArray(int paramAnonymousInt)
    {
      return new RecordActivityResult[paramAnonymousInt];
    }
  };
  private List<com.alivecor.ecg.record.RecordingError> errors;
  private AliveCorEcg successfulResult;
  
  protected RecordActivityResult(Parcel paramParcel)
  {
    successfulResult = ((AliveCorEcg)paramParcel.readSerializable());
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    paramParcel.readStringList(localArrayList2);
    paramParcel = localArrayList2.iterator();
    while (paramParcel.hasNext()) {
      localArrayList1.add(RecordingError.fromValue((String)paramParcel.next()));
    }
    errors = Collections.unmodifiableList(localArrayList1);
  }
  
  public RecordActivityResult(AliveCorEcg paramAliveCorEcg, List paramList)
  {
    successfulResult = paramAliveCorEcg;
    errors = Collections.unmodifiableList(paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List getErrors()
  {
    return errors;
  }
  
  public AliveCorEcg getSuccessfulResult()
  {
    return successfulResult;
  }
  
  public boolean isSuccessfu()
  {
    return successfulResult != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordActivityResult{successfulResult=");
    localStringBuilder.append(successfulResult);
    localStringBuilder.append(", errors=");
    localStringBuilder.append(errors);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(successfulResult);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = errors.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((RecordingError)localIterator.next()).name());
    }
    paramParcel.writeStringList(localArrayList);
  }
}
