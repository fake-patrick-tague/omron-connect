package com.braze.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.activities.BrazeFeedActivity;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class NewsfeedAction
  implements IAction
{
  private final Channel channel;
  private final Bundle extras;
  
  public NewsfeedAction(Bundle paramBundle, Channel paramChannel)
  {
    extras = paramBundle;
    channel = paramChannel;
  }
  
  public void execute(Context paramContext)
  {
    i.e(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, BrazeFeedActivity.class);
      Bundle localBundle = extras;
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramContext, execute.1.INSTANCE);
    }
  }
}
