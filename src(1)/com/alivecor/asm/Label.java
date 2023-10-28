package com.alivecor.asm;

import com.google.gson.v.c;
import java.io.Serializable;

public abstract class Label<Result extends Serializable>
  implements Serializable
{
  @c("result")
  protected Result a;
  @c("version_revision")
  protected String c;
  @c("version_minor")
  protected String d;
  @c("version_major")
  protected String e;
  
  public Label() {}
  
  public String a()
  {
    return d;
  }
  
  public void a(String paramString)
  {
    c = paramString;
  }
  
  public String b()
  {
    return e;
  }
  
  public void b(Serializable paramSerializable)
  {
    a = paramSerializable;
  }
  
  public void b(String paramString)
  {
    e = paramString;
  }
  
  public String c()
  {
    return c;
  }
  
  public void e(String paramString)
  {
    d = paramString;
  }
  
  public Serializable newUTF8()
  {
    return a;
  }
}
