package com.google.android.datatransport.runtime.firebase.transport;

import java.util.List;

public final class h
{
  private static final h g = new Frame().c();
  private final Marker a;
  private final String b;
  private final b e;
  private final List<c> f;
  
  h(Marker paramMarker, List paramList, b paramB, String paramString)
  {
    a = paramMarker;
    f = paramList;
    e = paramB;
    b = paramString;
  }
  
  public static Frame e()
  {
    return new Frame();
  }
  
  public b a()
  {
    return e;
  }
  
  public String b()
  {
    return b;
  }
  
  public Marker c()
  {
    return a;
  }
  
  public byte[] d()
  {
    return com.google.android.datatransport.asm.Frame.a(this);
  }
  
  public List f()
  {
    return f;
  }
}
