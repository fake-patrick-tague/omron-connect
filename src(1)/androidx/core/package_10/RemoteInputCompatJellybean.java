package androidx.core.package_10;

import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

class RemoteInputCompatJellybean
{
  static void addResultsToIntent(Object paramObject, Intent paramIntent, Bundle paramBundle)
  {
    android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[])paramObject, paramIntent, paramBundle);
  }
  
  public static android.app.RemoteInput build(RemoteInput paramRemoteInput)
  {
    RemoteInput.Builder localBuilder = new RemoteInput.Builder(paramRemoteInput.getResultKey()).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras());
    if (Build.VERSION.SDK_INT >= 26)
    {
      Object localObject = paramRemoteInput.getKey();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          SchemaParser.build(localBuilder, (String)((Iterator)localObject).next(), true);
        }
      }
    }
    if (Build.VERSION.SDK_INT >= 29) {
      CustomTile.Builder.setLabel(localBuilder, paramRemoteInput.getInt());
    }
    return localBuilder.build();
  }
  
  static Bundle getResultsFromIntent(Intent paramIntent)
  {
    return android.app.RemoteInput.getResultsFromIntent(paramIntent);
  }
}
