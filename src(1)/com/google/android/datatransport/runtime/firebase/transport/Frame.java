package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Frame
{
  private Marker b = null;
  private b c = null;
  private List<c> e = new ArrayList();
  private String g = "";
  
  Frame() {}
  
  public Frame a(b paramB)
  {
    c = paramB;
    return this;
  }
  
  public h c()
  {
    return new h(b, Collections.unmodifiableList(e), c, g);
  }
  
  public Frame init(Label paramLabel)
  {
    e.add(paramLabel);
    return this;
  }
  
  public Frame init(Marker paramMarker)
  {
    b = paramMarker;
    return this;
  }
  
  public Frame init(String paramString)
  {
    g = paramString;
    return this;
  }
}
