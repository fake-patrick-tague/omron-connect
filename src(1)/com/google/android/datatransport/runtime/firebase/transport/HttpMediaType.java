package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HttpMediaType
{
  private List<LogEventDropped> parameters = new ArrayList();
  private String type = "";
  
  HttpMediaType() {}
  
  public Label build()
  {
    return new Label(type, Collections.unmodifiableList(parameters));
  }
  
  public HttpMediaType setType(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public HttpMediaType setType(List paramList)
  {
    parameters = paramList;
    return this;
  }
}
