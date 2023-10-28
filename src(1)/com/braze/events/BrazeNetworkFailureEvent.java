package com.braze.events;

import kotlin.x.d.i;
import protect.package_9.AnnotationVisitor;
import protect.package_9.XYPlotZoomPan;
import protect.package_9.ad;
import protect.package_9.e;

public final class BrazeNetworkFailureEvent
{
  private final e brazeRequest;
  private final String networkExceptionMessage;
  private final Exception originalException;
  private final Long requestInitiationTime;
  private final RequestType requestType;
  
  public BrazeNetworkFailureEvent(Exception paramException, e paramE)
  {
    originalException = paramException;
    brazeRequest = paramE;
    networkExceptionMessage = paramException.getMessage();
    requestInitiationTime = paramE.getId();
    if ((paramE instanceof ad))
    {
      paramException = RequestType.CONTENT_CARDS_SYNC;
    }
    else if ((paramE instanceof XYPlotZoomPan))
    {
      paramException = paramE.c();
      int i = 1;
      if ((paramException == null) || (paramException.visit() != true)) {
        i = 0;
      }
      if (i != 0) {
        paramException = RequestType.NEWS_FEED_SYNC;
      } else {
        paramException = RequestType.OTHER;
      }
    }
    else
    {
      paramException = RequestType.OTHER;
    }
    requestType = paramException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BrazeNetworkFailureEvent)) {
      return false;
    }
    paramObject = (BrazeNetworkFailureEvent)paramObject;
    if (!i.a(originalException, originalException)) {
      return false;
    }
    return i.a(brazeRequest, brazeRequest);
  }
  
  public int hashCode()
  {
    return originalException.hashCode() * 31 + brazeRequest.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BrazeNetworkFailureEvent(originalException=");
    localStringBuilder.append(originalException);
    localStringBuilder.append(", brazeRequest=");
    localStringBuilder.append(brazeRequest);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public static enum RequestType {}
}
