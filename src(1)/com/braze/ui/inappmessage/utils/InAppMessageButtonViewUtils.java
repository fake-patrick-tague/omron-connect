package com.braze.ui.inappmessage.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.R.dimen;
import com.braze.ui.R.drawable;
import com.braze.ui.R.id;
import java.util.List;
import java.util.Objects;
import kotlin.x.d.i;

public final class InAppMessageButtonViewUtils
{
  public static final InAppMessageButtonViewUtils INSTANCE = new InAppMessageButtonViewUtils();
  
  private InAppMessageButtonViewUtils() {}
  
  public static final Drawable getButtonDrawable(Context paramContext, MessageButton paramMessageButton, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    i.e(paramContext, "context");
    i.e(paramMessageButton, "messageButton");
    Drawable localDrawable = getDrawable(paramContext, R.drawable.com_braze_inappmessage_button_background);
    localDrawable.mutate();
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = ((RippleDrawable)localDrawable).findDrawableByLayerId(R.id.com_braze_inappmessage_button_background_ripple_internal_gradient);
      Objects.requireNonNull(paramContext, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
      paramContext = (GradientDrawable)paramContext;
    }
    else
    {
      paramContext = (GradientDrawable)localDrawable;
    }
    if (paramBoolean) {
      paramInt1 = paramInt2;
    }
    paramContext.setStroke(paramInt1, paramMessageButton.getBorderColor());
    paramContext.setColor(paramMessageButton.getBackgroundColor());
    return localDrawable;
  }
  
  public static final Drawable getDrawable(Context paramContext, int paramInt)
  {
    i.e(paramContext, "context");
    paramContext = paramContext.getResources().getDrawable(paramInt);
    i.d(paramContext, "context.resources.getDrawable(drawableId)");
    return paramContext;
  }
  
  public static final void setButton(Button paramButton, MessageButton paramMessageButton, int paramInt1, int paramInt2)
  {
    i.e(paramButton, "button");
    i.e(paramMessageButton, "messageButton");
    paramButton.setText(paramMessageButton.getText());
    paramButton.setContentDescription(paramMessageButton.getText());
    InAppMessageViewUtils.setTextViewColor(paramButton, paramMessageButton.getTextColor());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (Build.VERSION.SDK_INT >= 21) {
      paramButton.setStateListAnimator(null);
    }
    Object localObject = paramButton.getContext();
    i.d(localObject, "button.context");
    localObject = getButtonDrawable((Context)localObject, paramMessageButton, paramInt1, paramInt2, false);
    Context localContext = paramButton.getContext();
    i.d(localContext, "button.context");
    paramMessageButton = getButtonDrawable(localContext, paramMessageButton, paramInt1, paramInt2, true);
    localStateListDrawable.addState(new int[] { 16842908 }, paramMessageButton);
    localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
    paramButton.setBackground(localStateListDrawable);
  }
  
  public static final void setButtons(List paramList1, List paramList2)
  {
    i.e(paramList1, "buttonViews");
    i.e(paramList2, "messageButtons");
    int j = paramList1.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramList1.get(i);
      MessageButton localMessageButton = (MessageButton)paramList2.get(i);
      int k = localView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_button_border_stroke);
      int m = localView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_button_border_stroke_focused);
      if (paramList2.size() <= i) {
        localView.setVisibility(8);
      } else if ((localView instanceof Button)) {
        setButton((Button)localView, localMessageButton, k, m);
      }
      i += 1;
    }
  }
}
