package com.braze.ui.inappmessage.views;

import com.braze.enums.inappmessage.CropType;

public abstract interface IInAppMessageImageView
{
  public abstract void setCornersRadiiPx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void setCornersRadiusPx(float paramFloat);
  
  public abstract void setInAppMessageImageCropType(CropType paramCropType);
}
