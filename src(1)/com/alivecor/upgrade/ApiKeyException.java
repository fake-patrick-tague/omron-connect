package com.alivecor.upgrade;

import k.a.a.b;

public class ApiKeyException
  extends RuntimeException
{
  private static final String SALES_EMAIL = "sales@alivecor.com";
  
  private ApiKeyException(String paramString)
  {
    super(paramString);
  }
  
  static ApiKeyException expired(String paramString, b paramB)
  {
    return new ApiKeyException(String.format("The API Key [%s] expired on [%s].  For a new API key, please contact <%s>", new Object[] { paramString, paramB, "sales@alivecor.com" }));
  }
  
  static ApiKeyException invalidKey(String paramString)
  {
    return new ApiKeyException(String.format("The API Key [%s] was not valid.  For a valid API key, please contact <%s>", new Object[] { paramString, "sales@alivecor.com" }));
  }
}
