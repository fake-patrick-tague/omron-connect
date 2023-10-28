package com.google.android.gms.fitness.result;

import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class SessionReadResponse
  extends com.google.android.gms.common.api.Response<SessionReadResult>
{
  public SessionReadResponse() {}
  
  public List getDataSet(Session paramSession)
  {
    return ((SessionReadResult)getResult()).getDataSet(paramSession);
  }
  
  public List getDataSet(Session paramSession, DataType paramDataType)
  {
    return ((SessionReadResult)getResult()).getDataSet(paramSession, paramDataType);
  }
  
  public List getSessions()
  {
    return ((SessionReadResult)getResult()).getSessions();
  }
  
  public Status getStatus()
  {
    return ((SessionReadResult)getResult()).getStatus();
  }
}
