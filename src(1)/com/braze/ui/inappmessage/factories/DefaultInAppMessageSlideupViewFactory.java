package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.models.inappmessage.InAppMessageWithImageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.R.layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageBaseView.Companion;
import com.braze.ui.inappmessage.views.InAppMessageSlideupView;
import com.braze.ui.support.ViewUtils;
import java.util.Objects;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class DefaultInAppMessageSlideupViewFactory
  implements IInAppMessageViewFactory
{
  public DefaultInAppMessageSlideupViewFactory() {}
  
  public InAppMessageSlideupView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    i.e(paramActivity, "activity");
    i.e(paramIInAppMessage, "inAppMessage");
    Object localObject1 = paramActivity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_slideup, null);
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageSlideupView");
    localObject1 = (InAppMessageSlideupView)localObject1;
    if (ViewUtils.isDeviceNotInTouchMode((View)localObject1))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, createInAppMessageView.1.INSTANCE, 2, null);
      return null;
    }
    InAppMessageSlideup localInAppMessageSlideup = (InAppMessageSlideup)paramIInAppMessage;
    paramActivity = paramActivity.getApplicationContext();
    ((InAppMessageSlideupView)localObject1).applyInAppMessageParameters(paramIInAppMessage);
    String str = InAppMessageBaseView.Companion.getAppropriateImageUrl(localInAppMessageSlideup);
    int i;
    if ((str != null) && (str.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      Object localObject2 = Braze.Companion;
      i.d(paramActivity, "applicationContext");
      localObject2 = ((Braze.Companion)localObject2).getInstance(paramActivity).getImageLoader();
      ImageView localImageView = ((InAppMessageSlideupView)localObject1).getMessageImageView();
      if (localImageView != null) {
        ((IBrazeImageLoader)localObject2).renderUrlIntoInAppMessageView(paramActivity, paramIInAppMessage, str, localImageView, BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP);
      }
    }
    ((InAppMessageSlideupView)localObject1).setMessageBackgroundColor(localInAppMessageSlideup.getBackgroundColor());
    paramActivity = localInAppMessageSlideup.getMessage();
    if (paramActivity != null) {
      ((InAppMessageBaseView)localObject1).setMessage(paramActivity);
    }
    ((InAppMessageBaseView)localObject1).setMessageTextColor(localInAppMessageSlideup.getMessageTextColor());
    ((InAppMessageBaseView)localObject1).setMessageTextAlign(localInAppMessageSlideup.getMessageTextAlign());
    paramActivity = localInAppMessageSlideup.getIcon();
    if (paramActivity != null) {
      ((InAppMessageBaseView)localObject1).setMessageIcon(paramActivity, localInAppMessageSlideup.getIconColor(), localInAppMessageSlideup.getIconBackgroundColor());
    }
    ((InAppMessageSlideupView)localObject1).setMessageChevron(localInAppMessageSlideup.getChevronColor(), localInAppMessageSlideup.getClickAction());
    ((InAppMessageSlideupView)localObject1).resetMessageMargins(localInAppMessageSlideup.getImageDownloadSuccessful());
    return localObject1;
  }
}
