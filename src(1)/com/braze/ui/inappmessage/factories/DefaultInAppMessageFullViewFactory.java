package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.Orientation;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageImmersiveBase;
import com.braze.models.inappmessage.InAppMessageWithImageBase;
import com.braze.ui.R.id;
import com.braze.ui.R.layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageBaseView.Companion;
import com.braze.ui.inappmessage.views.InAppMessageFullView;
import com.braze.ui.inappmessage.views.InAppMessageImageView;
import com.braze.ui.inappmessage.views.InAppMessageImmersiveBaseView;
import com.braze.ui.support.ViewUtils;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.x.d.i;

public class DefaultInAppMessageFullViewFactory
  implements IInAppMessageViewFactory
{
  public static final Companion Companion = new Companion(null);
  
  public DefaultInAppMessageFullViewFactory() {}
  
  private static final void createInAppMessageView$lambda-4(View paramView1, InAppMessageFullView paramInAppMessageFullView, InAppMessageFull paramInAppMessageFull, Context paramContext, View paramView2)
  {
    i.e(paramInAppMessageFullView, "$view");
    i.e(paramInAppMessageFull, "$inAppMessageFull");
    int k = paramView1.getHeight() / 2;
    paramView1 = paramInAppMessageFullView.findViewById(R.id.com_braze_inappmessage_full_text_and_button_content_parent).getLayoutParams();
    Objects.requireNonNull(paramView1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    paramView1 = (ViewGroup.MarginLayoutParams)paramView1;
    int j = bottomMargin + topMargin;
    int i = j;
    if ((paramInAppMessageFull.getMessageButtons().isEmpty() ^ true))
    {
      i.d(paramContext, "applicationContext");
      i = j + (int)ViewUtils.convertDpToPixels(paramContext, 64.0D);
    }
    i = Math.min(paramView2.getHeight(), k - i);
    i.d(paramView2, "scrollView");
    ViewUtils.setHeightOnViewLayoutParams(paramView2, i);
    paramView2.requestLayout();
    paramView1 = paramInAppMessageFullView.getMessageImageView();
    if (paramView1 != null) {
      paramView1.requestLayout();
    }
  }
  
  private final boolean resetLayoutParamsIfAppropriate(Activity paramActivity, IInAppMessage paramIInAppMessage, InAppMessageFullView paramInAppMessageFullView)
  {
    if (!ViewUtils.isRunningOnTablet(paramActivity)) {
      return false;
    }
    if (paramIInAppMessage.getOrientation() == Orientation.VERTICAL) {
      return false;
    }
    int i = paramInAppMessageFullView.getLongEdge();
    int j = paramInAppMessageFullView.getShortEdge();
    if ((i > 0) && (j > 0))
    {
      if (paramIInAppMessage.getOrientation() == Orientation.LANDSCAPE) {
        paramActivity = new RelativeLayout.LayoutParams(i, j);
      } else {
        paramActivity = new RelativeLayout.LayoutParams(j, i);
      }
      paramActivity.addRule(13, -1);
      paramIInAppMessage = paramInAppMessageFullView.getMessageBackgroundObject();
      if (paramIInAppMessage != null) {
        paramIInAppMessage.setLayoutParams(paramActivity);
      }
      return true;
    }
    return false;
  }
  
  public InAppMessageFullView createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage)
  {
    i.e(paramActivity, "activity");
    i.e(paramIInAppMessage, "inAppMessage");
    Context localContext = paramActivity.getApplicationContext();
    InAppMessageFull localInAppMessageFull = (InAppMessageFull)paramIInAppMessage;
    Object localObject1 = localInAppMessageFull.getImageStyle();
    Object localObject2 = ImageStyle.GRAPHIC;
    int i = 0;
    boolean bool;
    if (localObject1 == localObject2) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = getAppropriateFullView(paramActivity, bool);
    ((InAppMessageFullView)localObject1).createAppropriateViews(paramActivity, localInAppMessageFull, bool);
    localObject2 = InAppMessageBaseView.Companion.getAppropriateImageUrl(localInAppMessageFull);
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
      i = 1;
    }
    if (i == 0)
    {
      Object localObject3 = Braze.Companion;
      i.d(localContext, "applicationContext");
      localObject3 = ((Braze.Companion)localObject3).getInstance(localContext).getImageLoader();
      ImageView localImageView = ((InAppMessageFullView)localObject1).getMessageImageView();
      if (localImageView != null) {
        ((IBrazeImageLoader)localObject3).renderUrlIntoInAppMessageView(localContext, paramIInAppMessage, (String)localObject2, localImageView, BrazeViewBounds.NO_BOUNDS);
      }
    }
    paramIInAppMessage = ((InAppMessageFullView)localObject1).getFrameView();
    if (paramIInAppMessage != null) {
      paramIInAppMessage.setOnClickListener(null);
    }
    ((InAppMessageFullView)localObject1).setMessageBackgroundColor(localInAppMessageFull.getBackgroundColor());
    paramIInAppMessage = localInAppMessageFull.getFrameColor();
    if (paramIInAppMessage != null) {
      ((InAppMessageImmersiveBaseView)localObject1).setFrameColor(paramIInAppMessage.intValue());
    }
    ((InAppMessageImmersiveBaseView)localObject1).setMessageButtons(localInAppMessageFull.getMessageButtons());
    ((InAppMessageImmersiveBaseView)localObject1).setMessageCloseButtonColor(localInAppMessageFull.getCloseButtonColor());
    if (!bool)
    {
      paramIInAppMessage = localInAppMessageFull.getMessage();
      if (paramIInAppMessage != null) {
        ((InAppMessageBaseView)localObject1).setMessage(paramIInAppMessage);
      }
      ((InAppMessageBaseView)localObject1).setMessageTextColor(localInAppMessageFull.getMessageTextColor());
      paramIInAppMessage = localInAppMessageFull.getHeader();
      if (paramIInAppMessage != null) {
        ((InAppMessageImmersiveBaseView)localObject1).setMessageHeaderText(paramIInAppMessage);
      }
      ((InAppMessageImmersiveBaseView)localObject1).setMessageHeaderTextColor(localInAppMessageFull.getHeaderTextColor());
      ((InAppMessageImmersiveBaseView)localObject1).setMessageHeaderTextAlignment(localInAppMessageFull.getHeaderTextAlign());
      ((InAppMessageBaseView)localObject1).setMessageTextAlign(localInAppMessageFull.getMessageTextAlign());
      ((InAppMessageFullView)localObject1).resetMessageMargins(localInAppMessageFull.getImageDownloadSuccessful());
      paramIInAppMessage = ((InAppMessageFullView)localObject1).getMessageImageView();
      Objects.requireNonNull(paramIInAppMessage, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageImageView");
      ((InAppMessageImageView)paramIInAppMessage).setToHalfParentHeight(true);
    }
    ((InAppMessageImmersiveBaseView)localObject1).setLargerCloseButtonClickArea(((InAppMessageFullView)localObject1).getMessageCloseButtonView());
    resetLayoutParamsIfAppropriate(paramActivity, localInAppMessageFull, (InAppMessageFullView)localObject1);
    ((InAppMessageImmersiveBaseView)localObject1).setupDirectionalNavigation(localInAppMessageFull.getMessageButtons().size());
    paramActivity = ((View)localObject1).findViewById(R.id.com_braze_inappmessage_full_scrollview);
    if (paramActivity != null) {
      paramActivity.post(new a(((View)localObject1).findViewById(R.id.com_braze_inappmessage_full_all_content_parent), (InAppMessageFullView)localObject1, localInAppMessageFull, localContext, paramActivity));
    }
    return localObject1;
  }
  
  public final InAppMessageFullView getAppropriateFullView(Activity paramActivity, boolean paramBoolean)
  {
    i.e(paramActivity, "activity");
    if (paramBoolean)
    {
      paramActivity = paramActivity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_full_graphic, null);
      Objects.requireNonNull(paramActivity, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageFullView");
      return (InAppMessageFullView)paramActivity;
    }
    paramActivity = paramActivity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_full, null);
    Objects.requireNonNull(paramActivity, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageFullView");
    return (InAppMessageFullView)paramActivity;
  }
  
  public static final class Companion
  {
    private Companion() {}
  }
}
