package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.ImageStyle;
import java.util.List;

public abstract interface IInAppMessageImmersive
  extends IInAppMessage
{
  public abstract String getHeader();
  
  public abstract ImageStyle getImageStyle();
  
  public abstract List getMessageButtons();
  
  public abstract boolean logButtonClick(MessageButton paramMessageButton);
}
