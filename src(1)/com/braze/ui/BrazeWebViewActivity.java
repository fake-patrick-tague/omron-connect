package com.braze.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.ComponentActivity;
import androidx.fragment.package_11.FragmentActivity;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.enums.Channel;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.actions.IAction;
import com.braze.ui.support.ViewUtils;
import kotlin.x.c.a;
import kotlin.x.d.j;

public class BrazeWebViewActivity
  extends FragmentActivity
{
  public BrazeWebViewActivity() {}
  
  public WebChromeClient createWebChromeClient()
  {
    new WebChromeClient()
    {
      public Bitmap getDefaultVideoPoster()
      {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      }
      
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        kotlin.x.d.i.e(paramAnonymousConsoleMessage, "cm");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(paramAnonymousConsoleMessage)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Braze WebView Activity log. Line: ");
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
    };
  }
  
  public WebViewClient createWebViewClient()
  {
    new WebViewClient()
    {
      private final Boolean handleUrlOverride(Context paramAnonymousContext, String paramAnonymousString)
      {
        Object localObject1 = BrazeFileUtils.REMOTE_SCHEMES;
        try
        {
          boolean bool = kotlin.collections.i.o((Iterable)localObject1, Uri.parse(paramAnonymousString).getScheme());
          if (bool) {
            return null;
          }
          localObject1 = BrazeDeeplinkHandler.Companion;
          localObject1 = ((BrazeDeeplinkHandler.Companion)localObject1).getInstance();
          Object localObject2 = BrazeWebViewActivity.this;
          localObject2 = ((Activity)localObject2).getIntent().getExtras();
          Channel localChannel = Channel.UNKNOWN;
          localObject1 = ((IBrazeDeeplinkHandler)localObject1).createUriActionFromUrlString(paramAnonymousString, (Bundle)localObject2, false, localChannel);
          if (localObject1 != null)
          {
            ((IAction)localObject1).execute(paramAnonymousContext);
            paramAnonymousContext = BrazeWebViewActivity.this;
            paramAnonymousContext.finish();
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        catch (Exception paramAnonymousContext)
        {
          BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramAnonymousContext, new j(paramAnonymousString)
          {
            public final String invoke()
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unexpected exception while processing url ");
              localStringBuilder.append(BrazeWebViewActivity.createWebViewClient.1.this);
              localStringBuilder.append(". Passing url back to WebView.");
              return localStringBuilder.toString();
            }
          });
        }
        return null;
      }
      
      public boolean onRenderProcessGone(WebView paramAnonymousWebView, RenderProcessGoneDetail paramAnonymousRenderProcessGoneDetail)
      {
        kotlin.x.d.i.e(paramAnonymousWebView, "view");
        kotlin.x.d.i.e(paramAnonymousRenderProcessGoneDetail, "detail");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, onRenderProcessGone.1.INSTANCE, 2, null);
        return true;
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
      {
        kotlin.x.d.i.e(paramAnonymousWebView, "view");
        kotlin.x.d.i.e(paramAnonymousWebResourceRequest, "request");
        Object localObject = paramAnonymousWebView.getContext();
        kotlin.x.d.i.d(localObject, "view.context");
        String str = paramAnonymousWebResourceRequest.getUrl().toString();
        kotlin.x.d.i.d(str, "request.url.toString()");
        localObject = handleUrlOverride((Context)localObject, str);
        if (localObject != null) {
          return ((Boolean)localObject).booleanValue();
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        kotlin.x.d.i.e(paramAnonymousWebView, "view");
        kotlin.x.d.i.e(paramAnonymousString, "url");
        Object localObject = paramAnonymousWebView.getContext();
        kotlin.x.d.i.d(localObject, "view.context");
        localObject = handleUrlOverride((Context)localObject, paramAnonymousString);
        if (localObject != null) {
          return ((Boolean)localObject).booleanValue();
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
      }
    };
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    setContentView(R.layout.com_braze_webview_activity);
    paramBundle = (WebView)findViewById(R.id.com_braze_webview_activity_webview);
    paramBundle.setLayerType(2, null);
    Object localObject = paramBundle.getSettings();
    kotlin.x.d.i.d(localObject, "webView.settings");
    ((WebSettings)localObject).setAllowFileAccess(false);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setDisplayZoomControls(false);
    ((WebSettings)localObject).setDomStorageEnabled(true);
    Context localContext = getApplicationContext();
    kotlin.x.d.i.d(localContext, "this.applicationContext");
    if (ViewUtils.isDeviceInNightMode(localContext))
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 33) {
        ((WebSettings)localObject).setAlgorithmicDarkeningAllowed(true);
      } else if (i >= 29) {
        ((WebSettings)localObject).setForceDark(2);
      }
    }
    paramBundle.setWebChromeClient(createWebChromeClient());
    paramBundle.setWebViewClient(createWebViewClient());
    localObject = getIntent().getExtras();
    if (localObject != null)
    {
      localObject = ((BaseBundle)localObject).getString("url");
      if (localObject != null) {
        paramBundle.loadUrl((String)localObject);
      }
    }
  }
}
