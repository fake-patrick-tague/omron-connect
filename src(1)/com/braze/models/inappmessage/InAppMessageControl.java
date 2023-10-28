package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x.c.a;
import kotlin.x.d.j;
import org.json.JSONObject;
import protect.package_9.ClassWriter;
import protect.package_9.MethodWriter;
import protect.package_9.c;
import protect.package_9.p;

public class InAppMessageControl
  extends InAppMessageBase
{
  private final AtomicBoolean controlImpressionLogged = new AtomicBoolean(false);
  
  public InAppMessageControl(JSONObject paramJSONObject, c paramC)
  {
    super(paramJSONObject, paramC, false, false, 12, null);
  }
  
  public MessageType getMessageType()
  {
    return MessageType.CONTROL;
  }
  
  public boolean logImpression()
  {
    if (controlImpressionLogged.get())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, a.components, 2, null);
      return false;
    }
    Object localObject = getTriggerId();
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, b.PLAYING, 2, null);
      return false;
    }
    if (getBrazeManager() == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, c.PLAYING, 2, null);
      return false;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, d.C, 2, null);
    localObject = getTriggerId();
    if (localObject != null) {
      localObject = ClassWriter.o.add((String)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      c localC = getBrazeManager();
      if (localC != null) {
        localC.a((p)localObject);
      }
      controlImpressionLogged.set(true);
    }
    return true;
  }
  
  static final class a
    extends j
    implements a<String>
  {
    public static final a components = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Control impression already logged for this in-app message. Ignoring.";
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b PLAYING = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Trigger Id not found (this is expected for test sends). Not logging in-app message control impression.";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    public static final c PLAYING = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot log an in-app message control impression because the BrazeManager is null.";
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d C = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Logging control in-app message impression event";
    }
  }
}
