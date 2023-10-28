package com.google.android.gms.common.package_12;

public class Response<T extends com.google.android.gms.common.api.Result>
{
  private Result result;
  
  public Response() {}
  
  protected Response(Result paramResult)
  {
    result = paramResult;
  }
  
  protected Result getResult()
  {
    return result;
  }
  
  public void setResult(Result paramResult)
  {
    result = paramResult;
  }
}
