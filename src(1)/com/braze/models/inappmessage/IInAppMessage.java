package com.braze.models.inappmessage;

import android.net.Uri;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.models.IPutIntoJson;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract interface IInAppMessage
  extends IPutIntoJson<JSONObject>
{
  public abstract boolean getAnimateIn();
  
  public abstract boolean getAnimateOut();
  
  public abstract int getBackgroundColor();
  
  public abstract ClickAction getClickAction();
  
  public abstract CropType getCropType();
  
  public abstract DismissType getDismissType();
  
  public abstract int getDurationInMilliseconds();
  
  public abstract long getExpirationTimestamp();
  
  public abstract Map getExtras();
  
  public abstract String getIcon();
  
  public abstract int getIconBackgroundColor();
  
  public abstract int getIconColor();
  
  public abstract String getMessage();
  
  public abstract int getMessageTextColor();
  
  public abstract MessageType getMessageType();
  
  public abstract boolean getOpenUriInWebView();
  
  public abstract Orientation getOrientation();
  
  public abstract List getRemoteAssetPathsForPrefetch();
  
  public abstract Uri getUri();
  
  public abstract boolean isControl();
  
  public abstract boolean logClick();
  
  public abstract boolean logDisplayFailure(InAppMessageFailureType paramInAppMessageFailureType);
  
  public abstract boolean logImpression();
  
  public abstract void onAfterClosed();
  
  public abstract void setAnimateIn(boolean paramBoolean);
  
  public abstract void setAnimateOut(boolean paramBoolean);
  
  public abstract void setExpirationTimestamp(long paramLong);
  
  public abstract void setLocalPrefetchedAssetPaths(Map paramMap);
}
