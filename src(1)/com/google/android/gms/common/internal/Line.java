package com.google.android.gms.common.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

public final class Line
  extends RemoteCreator<zam>
{
  private static final Line previous = new Line();
  
  private Line()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View get(Context paramContext, int paramInt1, int paramInt2)
    throws RemoteCreator.RemoteCreatorException
  {
    Line localLine = previous;
    try
    {
      localObject = new Contact(1, paramInt1, paramInt2, null);
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      paramContext = localLine.getRemoteCreatorInstance(paramContext);
      paramContext = (RealmObject)paramContext;
      paramContext = ObjectWrapper.unwrap(paramContext.getChat(localIObjectWrapper, (Contact)localObject));
      return (View)paramContext;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder(64);
      ((StringBuilder)localObject).append("Could not get button with size ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" and color ");
      ((StringBuilder)localObject).append(paramInt2);
      throw new RemoteCreator.RemoteCreatorException(((StringBuilder)localObject).toString(), paramContext);
    }
  }
}
