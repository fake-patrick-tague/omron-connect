package com.google.android.gms.fitness.result;

import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class DataReadResponse
  extends com.google.android.gms.common.api.Response<DataReadResult>
{
  public DataReadResponse() {}
  
  public List getBuckets()
  {
    return ((DataReadResult)getResult()).getBuckets();
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    return ((DataReadResult)getResult()).getDataSet(paramDataSource);
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    return ((DataReadResult)getResult()).getDataSet(paramDataType);
  }
  
  public List getDataSets()
  {
    return ((DataReadResult)getResult()).getDataSets();
  }
  
  public Status getStatus()
  {
    return ((DataReadResult)getResult()).getStatus();
  }
}
