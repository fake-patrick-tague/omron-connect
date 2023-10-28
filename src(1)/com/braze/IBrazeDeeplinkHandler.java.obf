package com.braze;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.braze.enums.Channel;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;

public abstract interface IBrazeDeeplinkHandler
{
  public abstract UriAction createUriActionFromUri(Uri paramUri, Bundle paramBundle, boolean paramBoolean, Channel paramChannel);
  
  public abstract UriAction createUriActionFromUrlString(String paramString, Bundle paramBundle, boolean paramBoolean, Channel paramChannel);
  
  public abstract int getIntentFlags(IntentFlagPurpose paramIntentFlagPurpose);
  
  public abstract void gotoNewsFeed(Context paramContext, NewsfeedAction paramNewsfeedAction);
  
  public abstract void gotoUri(Context paramContext, UriAction paramUriAction);
  
  public static enum IntentFlagPurpose
  {
    static
    {
      URI_ACTION_OPEN_WITH_ACTION_VIEW = new IntentFlagPurpose("URI_ACTION_OPEN_WITH_ACTION_VIEW", 3);
      URI_ACTION_BACK_STACK_GET_ROOT_INTENT = new IntentFlagPurpose("URI_ACTION_BACK_STACK_GET_ROOT_INTENT", 4);
      URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT = new IntentFlagPurpose("URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT", 5);
      URI_UTILS_GET_MAIN_ACTIVITY_INTENT = new IntentFlagPurpose("URI_UTILS_GET_MAIN_ACTIVITY_INTENT", 6);
    }
  }
}
