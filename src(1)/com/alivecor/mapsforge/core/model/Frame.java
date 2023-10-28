package com.alivecor.mapsforge.core.model;

import com.google.gson.v.c;
import java.io.Serializable;

public class Frame
  implements Serializable
{
  @c("hardware_revision")
  private String b;
  @c("firmware_revision")
  private String c;
  @c("hardware_type")
  private Handle e;
  @c("battery_level")
  private Float g;
  @c("serial_number")
  private String h;
  
  public Frame() {}
  
  public Frame(Frame paramFrame)
  {
    e = e;
    b = b;
    c = c;
    h = h;
    g = g;
  }
  
  public String a()
  {
    return c;
  }
  
  public void a(Handle paramHandle)
  {
    e = paramHandle;
  }
  
  public void a(String paramString)
  {
    h = paramString;
  }
  
  public Float b()
  {
    return g;
  }
  
  public void b(String paramString)
  {
    b = paramString;
  }
  
  public String c()
  {
    return b;
  }
  
  public void c(String paramString)
  {
    c = paramString;
  }
  
  public String d()
  {
    return h;
  }
  
  public Handle init()
  {
    return e;
  }
  
  public void set(Float paramFloat)
  {
    g = paramFloat;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordingDeviceData{hardwareType=");
    localStringBuilder.append(e);
    localStringBuilder.append(", hardwareRevision='");
    localStringBuilder.append(b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", firmwareRevision='");
    localStringBuilder.append(c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serialNumber='");
    localStringBuilder.append(h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", batteryLevel=");
    localStringBuilder.append(g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
