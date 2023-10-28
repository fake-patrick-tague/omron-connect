package com.google.android.gms.common.package_12;

public class ApiException
  extends Exception
{
  @Deprecated
  protected final Status mStatus;
  
  public ApiException(Status paramStatus)
  {
    super(localStringBuilder.toString());
    mStatus = paramStatus;
  }
  
  public Status getStatus()
  {
    return mStatus;
  }
  
  public int getStatusCode()
  {
    return mStatus.getStatusCode();
  }
  
  public String getStatusMessage()
  {
    return mStatus.getStatusMessage();
  }
}
