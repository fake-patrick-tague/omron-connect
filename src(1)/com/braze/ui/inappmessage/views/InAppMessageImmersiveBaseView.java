package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.R.dimen;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;
import com.braze.ui.inappmessage.InAppMessageManagerBase;
import com.braze.ui.inappmessage.utils.InAppMessageButtonViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.List;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public abstract class InAppMessageImmersiveBaseView
  extends InAppMessageBaseView
  implements IInAppMessageImmersiveView
{
  public InAppMessageImmersiveBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static final void setLargerCloseButtonClickArea$lambda-5(View paramView, InAppMessageImmersiveBaseView paramInAppMessageImmersiveBaseView, ViewParent paramViewParent)
  {
    i.e(paramInAppMessageImmersiveBaseView, "this$0");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    int j = paramInAppMessageImmersiveBaseView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_close_button_click_area_width);
    int i = paramInAppMessageImmersiveBaseView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_close_button_click_area_height);
    j = (j - localRect.width()) / 2;
    i = (i - localRect.height()) / 2;
    top -= i;
    bottom += i;
    left -= j;
    right += j;
    paramView = new TouchDelegate(localRect, paramView);
    ((View)paramViewParent).setTouchDelegate(paramView);
  }
  
  private static final void setupDirectionalNavigation$lambda-0(View paramView)
  {
    paramView.requestFocus();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    i.e(paramKeyEvent, "event");
    if ((!isInTouchMode()) && (paramKeyEvent.getKeyCode() == 4) && (BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()))
    {
      InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public abstract View getFrameView();
  
  public abstract List getMessageButtonViews(int paramInt);
  
  public abstract TextView getMessageHeaderTextView();
  
  public abstract TextView getMessageTextView();
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    i.e(paramKeyEvent, "event");
    if ((paramInt == 4) && (BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()))
    {
      InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void resetMessageMargins(boolean paramBoolean)
  {
    super.resetMessageMargins(paramBoolean);
    Object localObject1 = getMessageTextView();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((TextView)localObject1).getText();
    } else {
      localObject1 = null;
    }
    if (g.o(String.valueOf(localObject1))) {
      ViewUtils.removeViewFromParent(getMessageTextView());
    }
    TextView localTextView = getMessageHeaderTextView();
    localObject1 = localObject2;
    if (localTextView != null) {
      localObject1 = localTextView.getText();
    }
    if (g.o(String.valueOf(localObject1))) {
      ViewUtils.removeViewFromParent(getMessageHeaderTextView());
    }
    InAppMessageViewUtils.resetMessageMarginsIfNecessary(getMessageTextView(), getMessageHeaderTextView());
  }
  
  public void setFrameColor(int paramInt)
  {
    View localView = getFrameView();
    if (localView != null) {
      InAppMessageViewUtils.setFrameColor(localView, Integer.valueOf(paramInt));
    }
  }
  
  public void setLargerCloseButtonClickArea(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View)) {
        ((View)localViewParent).post(new NumberPicker.BeginSoftInputOnLongPressCommand(paramView, this, localViewParent));
      }
    }
    else
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, setLargerCloseButtonClickArea.1.INSTANCE, 2, null);
    }
  }
  
  public void setMessageButtons(List paramList)
  {
    i.e(paramList, "messageButtons");
    InAppMessageButtonViewUtils.setButtons(getMessageButtonViews(paramList.size()), paramList);
  }
  
  public void setMessageCloseButtonColor(int paramInt)
  {
    View localView = getMessageCloseButtonView();
    if (localView != null) {
      InAppMessageViewUtils.setViewBackgroundColorFilter(localView, paramInt);
    }
  }
  
  public void setMessageHeaderText(String paramString)
  {
    i.e(paramString, "text");
    TextView localTextView = getMessageHeaderTextView();
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public void setMessageHeaderTextAlignment(TextAlign paramTextAlign)
  {
    i.e(paramTextAlign, "textAlign");
    TextView localTextView = getMessageHeaderTextView();
    if (localTextView != null) {
      InAppMessageViewUtils.setTextAlignment(localTextView, paramTextAlign);
    }
  }
  
  public void setMessageHeaderTextColor(int paramInt)
  {
    TextView localTextView = getMessageHeaderTextView();
    if (localTextView != null) {
      InAppMessageViewUtils.setTextViewColor(localTextView, paramInt);
    }
  }
  
  public void setupDirectionalNavigation(int paramInt)
  {
    Object localObject2 = getMessageButtonViews(paramInt);
    View localView2 = getMessageCloseButtonView();
    View localView1 = localView2;
    Object localObject1;
    if (localView2 != null) {
      localObject1 = Integer.valueOf(localView2.getId());
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, setupDirectionalNavigation.1.INSTANCE, 2, null);
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramInt)
          {
            public final String invoke()
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Cannot setup directional navigation. Got unsupported number of buttons: ");
              localStringBuilder.append($numButtons);
              return localStringBuilder.toString();
            }
          }, 2, null);
        }
        else
        {
          localView1 = (View)((List)localObject2).get(1);
          View localView3 = (View)((List)localObject2).get(0);
          localObject2 = Integer.valueOf(localView1.getId());
          Integer localInteger = Integer.valueOf(localView3.getId());
          localView1.setNextFocusLeftId(localInteger.intValue());
          localView1.setNextFocusRightId(localInteger.intValue());
          localView1.setNextFocusUpId(((Integer)localObject1).intValue());
          localView1.setNextFocusDownId(((Integer)localObject1).intValue());
          localView3.setNextFocusLeftId(((Integer)localObject2).intValue());
          localView3.setNextFocusRightId(((Integer)localObject2).intValue());
          localView3.setNextFocusUpId(((Integer)localObject1).intValue());
          localView3.setNextFocusDownId(((Integer)localObject1).intValue());
          localView2.setNextFocusUpId(((Integer)localObject2).intValue());
          localView2.setNextFocusDownId(((Integer)localObject2).intValue());
          localView2.setNextFocusRightId(((Integer)localObject2).intValue());
          localView2.setNextFocusLeftId(localInteger.intValue());
          localObject1 = localObject2;
        }
      }
      else
      {
        localView1 = (View)((List)localObject2).get(0);
        localObject2 = Integer.valueOf(localView1.getId());
        localView1.setNextFocusLeftId(((Integer)localObject1).intValue());
        localView1.setNextFocusRightId(((Integer)localObject1).intValue());
        localView1.setNextFocusUpId(((Integer)localObject1).intValue());
        localView1.setNextFocusDownId(((Integer)localObject1).intValue());
        localView2.setNextFocusUpId(((Integer)localObject2).intValue());
        localView2.setNextFocusDownId(((Integer)localObject2).intValue());
        localView2.setNextFocusRightId(((Integer)localObject2).intValue());
        localView2.setNextFocusLeftId(((Integer)localObject2).intValue());
        localObject1 = localObject2;
      }
    }
    else
    {
      localView2.setNextFocusUpId(((Integer)localObject1).intValue());
      localView2.setNextFocusDownId(((Integer)localObject1).intValue());
      localView2.setNextFocusRightId(((Integer)localObject1).intValue());
      localView2.setNextFocusLeftId(((Integer)localObject1).intValue());
    }
    setNextFocusUpId(((Integer)localObject1).intValue());
    setNextFocusDownId(((Integer)localObject1).intValue());
    setNextFocusRightId(((Integer)localObject1).intValue());
    setNextFocusLeftId(((Integer)localObject1).intValue());
    if ((Build.VERSION.SDK_INT >= 26) && (localView1 != null)) {
      localView1.setFocusedByDefault(true);
    }
    if (localView1 != null) {
      localView1.post(new InitiationListener.1(localView1));
    }
  }
}
