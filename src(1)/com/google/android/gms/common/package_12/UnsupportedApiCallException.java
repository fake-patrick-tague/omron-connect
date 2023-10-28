package com.google.android.gms.common.package_12;

import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException
  extends UnsupportedOperationException
{
  private final Feature lineNumber;
  
  public UnsupportedApiCallException(Feature paramFeature)
  {
    lineNumber = paramFeature;
  }
  
  public String getMessage()
  {
    return "Missing ".concat(String.valueOf(lineNumber));
  }
}
