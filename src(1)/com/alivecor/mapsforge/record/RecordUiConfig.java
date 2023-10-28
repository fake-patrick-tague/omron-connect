package com.alivecor.mapsforge.record;

import java.io.Serializable;

public class RecordUiConfig
  implements Serializable
{
  private int batteryDepleted;
  private int getTriangleBottomLeadsOn;
  private boolean omronCompleteVideo;
  private int triangleBottomLeadsOff;
  private int triangleTopLeadsOff;
  private int triangleTopLeadsOn;
  
  public RecordUiConfig() {}
  
  public int getBatteryDepleted()
  {
    return batteryDepleted;
  }
  
  public int getGetTriangleBottomLeadsOn()
  {
    return getTriangleBottomLeadsOn;
  }
  
  public int getTriangleBottomLeadsOff()
  {
    return triangleBottomLeadsOff;
  }
  
  public int getTriangleTopLeadsOff()
  {
    return triangleTopLeadsOff;
  }
  
  public int getTriangleTopLeadsOn()
  {
    return triangleTopLeadsOn;
  }
  
  public boolean isOmronCompleteVideo()
  {
    return omronCompleteVideo;
  }
  
  public void setBatteryDepleted(int paramInt)
  {
    batteryDepleted = paramInt;
  }
  
  public void setGetTriangleBottomLeadsOn(int paramInt)
  {
    getTriangleBottomLeadsOn = paramInt;
  }
  
  public void setOmronCompleteVideo(boolean paramBoolean)
  {
    omronCompleteVideo = paramBoolean;
  }
  
  public void setTriangleBottomLeadsOff(int paramInt)
  {
    triangleBottomLeadsOff = paramInt;
  }
  
  public void setTriangleTopLeadsOff(int paramInt)
  {
    triangleTopLeadsOff = paramInt;
  }
  
  public void setTriangleTopLeadsOn(int paramInt)
  {
    triangleTopLeadsOn = paramInt;
  }
}
