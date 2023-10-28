package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;
import com.braze.ui.inappmessage.InAppMessageManagerBase;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.support.ViewUtils;
import java.util.Objects;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import v7.curve.b;
import v7.curve.c;
import v7.v7.package_13.f;

public abstract class InAppMessageHtmlBaseView
  extends RelativeLayout
  implements IInAppMessageView
{
  public static final Companion Companion = new Companion(null);
  private WebView configuredMessageWebView;
  private boolean hasAppliedWindowInsets;
  private InAppMessageWebViewClient inAppMessageWebViewClient;
  private boolean isFinished;
  
  public InAppMessageHtmlBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void applyWindowInsets(f paramF)
  {
    i.e(paramF, "insets");
    setHasAppliedWindowInsets(true);
    Object localObject = getContext();
    i.d(localObject, "this.context");
    if (!new BrazeConfigurationProvider((Context)localObject).isHtmlInAppMessageApplyWindowInsetsEnabled()) {
      return;
    }
    if (getLayoutParams() != null)
    {
      if (!(getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        return;
      }
      localObject = getLayoutParams();
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(ViewUtils.getMaxSafeLeftInset(paramF) + leftMargin, ViewUtils.getMaxSafeTopInset(paramF) + topMargin, ViewUtils.getMaxSafeRightInset(paramF) + rightMargin, ViewUtils.getMaxSafeBottomInset(paramF) + bottomMargin);
    }
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
  
  public void finishWebViewDisplay()
  {
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, finishWebViewDisplay.1.INSTANCE, 3, null);
    isFinished = true;
    WebView localWebView = configuredMessageWebView;
    if (localWebView != null)
    {
      localWebView.loadUrl("about:blank");
      localWebView.onPause();
      localWebView.removeAllViews();
      configuredMessageWebView = null;
    }
  }
  
  public boolean getHasAppliedWindowInsets()
  {
    return hasAppliedWindowInsets;
  }
  
  public View getMessageClickableView()
  {
    return this;
  }
  
  public WebView getMessageWebView()
  {
    if (isFinished)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, messageWebView.1.INSTANCE, 2, null);
      return null;
    }
    int i = getWebViewViewId();
    if (i == 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, messageWebView.2.INSTANCE, 3, null);
      return null;
    }
    WebView localWebView = configuredMessageWebView;
    if (localWebView != null) {
      return localWebView;
    }
    localWebView = (WebView)findViewById(i);
    if (localWebView == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(i)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("findViewById for ");
          localStringBuilder.append($webViewViewId);
          localStringBuilder.append(" returned null. Returning null for WebView.");
          return localStringBuilder.toString();
        }
      }, 3, null);
      return null;
    }
    WebSettings localWebSettings = localWebView.getSettings();
    i.d(localWebSettings, "webView.settings");
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAllowFileAccess(true);
    localWebView.setLayerType(2, null);
    localWebView.setBackgroundColor(0);
    try
    {
      boolean bool = c.a("FORCE_DARK");
      if (bool)
      {
        Context localContext = getContext();
        i.d(localContext, "context");
        bool = ViewUtils.isDeviceInNightMode(localContext);
        if (bool) {
          b.c(localWebSettings, 2);
        }
      }
      bool = c.a("FORCE_DARK_STRATEGY");
      if (bool) {
        b.a(localWebSettings, 1);
      }
    }
    catch (Throwable localThrowable)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localThrowable, messageWebView.4.INSTANCE);
    }
    localWebView.setWebChromeClient(new WebChromeClient()
    {
      public Bitmap getDefaultVideoPoster()
      {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      }
      
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        i.e(paramAnonymousConsoleMessage, "cm");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, InAppMessageHtmlBaseView.this, null, null, new j(paramAnonymousConsoleMessage)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Braze HTML In-app Message log. Line: ");
            localStringBuilder.append(lineNumber());
            localStringBuilder.append(". SourceId: ");
            localStringBuilder.append(sourceId());
            localStringBuilder.append(". Log Level: ");
            localStringBuilder.append(messageLevel());
            localStringBuilder.append(". Message: ");
            localStringBuilder.append(message());
            return localStringBuilder.toString();
          }
        }, 3, null);
        return true;
      }
    });
    configuredMessageWebView = localWebView;
    return localWebView;
  }
  
  public abstract int getWebViewViewId();
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    i.e(paramKeyEvent, "event");
    if ((paramInt == 4) && (BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()))
    {
      InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
      return true;
    }
    WebView localWebView = configuredMessageWebView;
    if (localWebView != null) {
      ViewUtils.setFocusableInTouchModeAndRequestFocus(localWebView);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setHasAppliedWindowInsets(boolean paramBoolean)
  {
    hasAppliedWindowInsets = paramBoolean;
  }
  
  public void setHtmlPageFinishedListener(IWebViewClientStateListener paramIWebViewClientStateListener)
  {
    InAppMessageWebViewClient localInAppMessageWebViewClient = inAppMessageWebViewClient;
    if (localInAppMessageWebViewClient != null) {
      localInAppMessageWebViewClient.setWebViewClientStateListener(paramIWebViewClientStateListener);
    }
  }
  
  public void setInAppMessageWebViewClient(InAppMessageWebViewClient paramInAppMessageWebViewClient)
  {
    i.e(paramInAppMessageWebViewClient, "inAppMessageWebViewClient");
    WebView localWebView = getMessageWebView();
    if (localWebView != null) {
      localWebView.setWebViewClient(paramInAppMessageWebViewClient);
    }
    inAppMessageWebViewClient = paramInAppMessageWebViewClient;
  }
  
  public final void setWebViewContent(String paramString)
  {
    setWebViewContent$default(this, paramString, null, 2, null);
  }
  
  public void setWebViewContent(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      WebView localWebView = getMessageWebView();
      if (localWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("file://");
        localStringBuilder.append(paramString2);
        localStringBuilder.append('/');
        localWebView.loadDataWithBaseURL(localStringBuilder.toString(), paramString1, "text/html", "utf-8", null);
      }
    }
    else
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, setWebViewContent.1.INSTANCE, 3, null);
    }
  }
  
  public static final class Companion
  {
    private Companion() {}
  }
}
