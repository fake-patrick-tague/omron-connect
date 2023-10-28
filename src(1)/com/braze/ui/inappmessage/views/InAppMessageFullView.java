package com.braze.ui.inappmessage.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.support.BrazeLogger;
import com.braze.ui.R.id;
import com.braze.ui.inappmessage.config.BrazeInAppMessageParams;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import v7.v7.package_13.f;

public class InAppMessageFullView
  extends InAppMessageImmersiveBaseView
{
  private InAppMessageImageView inAppMessageImageView;
  private boolean isGraphic;
  
  public InAppMessageFullView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void applyDisplayCutoutMarginsToCloseButton(f paramF, View paramView)
  {
    if ((paramView.getLayoutParams() != null) && ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramView = paramView.getLayoutParams();
      Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      paramView = (ViewGroup.MarginLayoutParams)paramView;
      paramView.setMargins(ViewUtils.getMaxSafeLeftInset(paramF) + leftMargin, ViewUtils.getMaxSafeTopInset(paramF) + topMargin, ViewUtils.getMaxSafeRightInset(paramF) + rightMargin, ViewUtils.getMaxSafeBottomInset(paramF) + bottomMargin);
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, applyDisplayCutoutMarginsToCloseButton.1.INSTANCE, 3, null);
  }
  
  private final void applyDisplayCutoutMarginsToContentArea(f paramF, View paramView)
  {
    if (!(paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, applyDisplayCutoutMarginsToContentArea.1.INSTANCE, 3, null);
      return;
    }
    paramView = paramView.getLayoutParams();
    Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    paramView.setMargins(ViewUtils.getMaxSafeLeftInset(paramF) + leftMargin, topMargin, ViewUtils.getMaxSafeRightInset(paramF) + rightMargin, ViewUtils.getMaxSafeBottomInset(paramF) + bottomMargin);
  }
  
  private static final void resetMessageMargins$lambda-2$lambda-1(InAppMessageFullView paramInAppMessageFullView, View paramView1, View paramView2)
  {
    i.e(paramInAppMessageFullView, "this$0");
    i.e(paramView1, "$msgClickableView");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramInAppMessageFullView, null, null, resetMessageMargins.1.1.1.INSTANCE, 3, null);
    paramView1.performClick();
  }
  
  private final void setInAppMessageImageViewAttributes(Activity paramActivity, IInAppMessageImmersive paramIInAppMessageImmersive, IInAppMessageImageView paramIInAppMessageImageView)
  {
    paramIInAppMessageImageView.setInAppMessageImageCropType(paramIInAppMessageImmersive.getCropType());
    if (ViewUtils.isRunningOnTablet(paramActivity))
    {
      float f = (float)ViewUtils.convertDpToPixels(paramActivity, BrazeInAppMessageParams.getModalizedImageRadiusDp());
      if (paramIInAppMessageImmersive.getImageStyle() == ImageStyle.GRAPHIC)
      {
        paramIInAppMessageImageView.setCornersRadiusPx(f);
        return;
      }
      paramIInAppMessageImageView.setCornersRadiiPx(f, f, 0.0F, 0.0F);
      return;
    }
    paramIInAppMessageImageView.setCornersRadiusPx(0.0F);
  }
  
  public void applyWindowInsets(f paramF)
  {
    i.e(paramF, "insets");
    super.applyWindowInsets(paramF);
    View localView = getMessageCloseButtonView();
    if (localView != null) {
      applyDisplayCutoutMarginsToCloseButton(paramF, localView);
    }
    if (isGraphic)
    {
      localView = findViewById(R.id.com_braze_inappmessage_full_button_layout_single);
      int j = 1;
      int i;
      if ((localView != null) && (localView.getVisibility() == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i.d(localView, "singleButtonParent");
        applyDisplayCutoutMarginsToContentArea(paramF, localView);
        return;
      }
      localView = findViewById(R.id.com_braze_inappmessage_full_button_layout_dual);
      if ((localView != null) && (localView.getVisibility() == 0)) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i.d(localView, "dualButtonParent");
        applyDisplayCutoutMarginsToContentArea(paramF, localView);
      }
    }
    else
    {
      localView = findViewById(R.id.com_braze_inappmessage_full_text_and_button_content_parent);
      if (localView != null) {
        applyDisplayCutoutMarginsToContentArea(paramF, localView);
      }
    }
  }
  
  public void createAppropriateViews(Activity paramActivity, IInAppMessageImmersive paramIInAppMessageImmersive, boolean paramBoolean)
  {
    i.e(paramActivity, "activity");
    i.e(paramIInAppMessageImmersive, "inAppMessage");
    InAppMessageImageView localInAppMessageImageView = (InAppMessageImageView)findViewById(R.id.com_braze_inappmessage_full_imageview);
    inAppMessageImageView = localInAppMessageImageView;
    if (localInAppMessageImageView != null) {
      setInAppMessageImageViewAttributes(paramActivity, paramIInAppMessageImmersive, localInAppMessageImageView);
    }
    isGraphic = paramBoolean;
  }
  
  public View getFrameView()
  {
    return findViewById(R.id.com_braze_inappmessage_full_frame);
  }
  
  public int getLongEdge()
  {
    return findViewByIdcom_braze_inappmessage_fullgetLayoutParamsheight;
  }
  
  public View getMessageBackgroundObject()
  {
    return findViewById(R.id.com_braze_inappmessage_full);
  }
  
  public List getMessageButtonViews(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    View localView1;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return localArrayList;
      }
      localView1 = findViewById(R.id.com_braze_inappmessage_full_button_layout_dual);
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
      localView1 = findViewById(R.id.com_braze_inappmessage_full_button_dual_one);
      View localView2 = findViewById(R.id.com_braze_inappmessage_full_button_dual_two);
      if (localView1 != null) {
        localArrayList.add(localView1);
      }
      if (localView2 != null)
      {
        localArrayList.add(localView2);
        return localArrayList;
      }
    }
    else
    {
      localView1 = findViewById(R.id.com_braze_inappmessage_full_button_layout_single);
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
      localView1 = findViewById(R.id.com_braze_inappmessage_full_button_single_one);
      if (localView1 != null) {
        localArrayList.add(localView1);
      }
    }
    return localArrayList;
  }
  
  public View getMessageClickableView()
  {
    return findViewById(R.id.com_braze_inappmessage_full);
  }
  
  public View getMessageCloseButtonView()
  {
    return findViewById(R.id.com_braze_inappmessage_full_close_button);
  }
  
  public TextView getMessageHeaderTextView()
  {
    View localView = findViewById(R.id.com_braze_inappmessage_full_header_text);
    i.d(localView, "findViewById(R.id.com_br?message_full_header_text)");
    return (TextView)localView;
  }
  
  public TextView getMessageIconView()
  {
    return null;
  }
  
  public ImageView getMessageImageView()
  {
    return inAppMessageImageView;
  }
  
  public TextView getMessageTextView()
  {
    View localView = findViewById(R.id.com_braze_inappmessage_full_message);
    i.d(localView, "findViewById(R.id.com_br?nappmessage_full_message)");
    return (TextView)localView;
  }
  
  public int getShortEdge()
  {
    return findViewByIdcom_braze_inappmessage_fullgetLayoutParamswidth;
  }
  
  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    View localView = getMessageClickableView();
    if (localView != null) {
      findViewById(R.id.com_braze_inappmessage_full_text_layout).setOnClickListener(new h(this, localView));
    }
  }
  
  public void setMessageBackgroundColor(int paramInt)
  {
    View localView = getMessageBackgroundObject();
    if (localView != null) {
      localObject = localView.getBackground();
    } else {
      localObject = null;
    }
    if ((localObject instanceof GradientDrawable))
    {
      InAppMessageViewUtils.setViewBackgroundColorFilter(localView, paramInt);
      return;
    }
    if (isGraphic)
    {
      super.setMessageBackgroundColor(paramInt);
      return;
    }
    Object localObject = findViewById(R.id.com_braze_inappmessage_full_all_content_parent);
    i.d(localObject, "findViewById(R.id.com_br?_full_all_content_parent)");
    InAppMessageViewUtils.setViewBackgroundColor((View)localObject, paramInt);
    localObject = findViewById(R.id.com_braze_inappmessage_full_text_and_button_content_parent);
    i.d(localObject, "findViewById(R.id.com_br?nd_button_content_parent)");
    InAppMessageViewUtils.setViewBackgroundColor((View)localObject, paramInt);
  }
}
