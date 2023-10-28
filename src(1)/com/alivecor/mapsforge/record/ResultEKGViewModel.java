package com.alivecor.mapsforge.record;

import androidx.lifecycle.Label;
import androidx.lifecycle.StatusPreference;
import androidx.lifecycle.s;
import com.alivecor.mapsforge.core.model.c;
import java.util.Objects;
import l.a.a;

public class ResultEKGViewModel
  extends Label
{
  protected RecordingHelpUrls helpUrls;
  protected ResultDetail recordResult;
  protected s<com.alivecor.ecg.record.ResultEKGViewModel.ResultTask> resultTaskMutableLiveData = new StatusPreference();
  
  public ResultEKGViewModel() {}
  
  public ResultDetail getRecordResult()
  {
    return recordResult;
  }
  
  public RecordingHelpUrls getRecordResultUrls()
  {
    return helpUrls;
  }
  
  public c getRecordingDevice()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Recording result : ");
    ((StringBuilder)localObject).append(recordResult);
    a.a(((StringBuilder)localObject).toString(), new Object[0]);
    localObject = recordResult.getHardwareType();
    int[] arrayOfInt = 1.$SwitchMap$com$alivecor$ecg$core$model$RecordingDeviceData$Hardware;
    Objects.requireNonNull(localObject);
    int i = arrayOfInt[((com.alivecor.mapsforge.core.model.Handle)localObject).ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4)) {
          return c.b;
        }
        return c.b;
      }
      return c.t1;
    }
    return c.deviceList;
  }
  
  public void setRecordResult(ResultDetail paramResultDetail)
  {
    recordResult = paramResultDetail;
  }
  
  public void setRecordResultUrls(RecordingHelpUrls paramRecordingHelpUrls)
  {
    helpUrls = paramRecordingHelpUrls;
  }
  
  public enum ResultTask
  {
    static
    {
      ResultTask localResultTask1 = new ResultTask("ON_SUCCESS", 0);
      ON_SUCCESS = localResultTask1;
      ResultTask localResultTask2 = new ResultTask("ON_FAILURE", 1);
      ON_FAILURE = localResultTask2;
      $VALUES = new ResultTask[] { localResultTask1, localResultTask2 };
    }
  }
}
