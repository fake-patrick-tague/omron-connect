package androidx.webkit.internal;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public enum WebViewFeatureInternal
  implements a
{
  private final int c;
  private final String key;
  private final String s;
  
  static
  {
    WebViewFeatureInternal localWebViewFeatureInternal1 = new WebViewFeatureInternal("VISUAL_STATE_CALLBACK", 0, "VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK", 23);
    seed = localWebViewFeatureInternal1;
    WebViewFeatureInternal localWebViewFeatureInternal2 = new WebViewFeatureInternal("OFF_SCREEN_PRERASTER", 1, "OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER", 23);
    leaf = localWebViewFeatureInternal2;
    WebViewFeatureInternal localWebViewFeatureInternal3 = new WebViewFeatureInternal("SAFE_BROWSING_ENABLE", 2, "SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE", 26);
    i = localWebViewFeatureInternal3;
    WebViewFeatureInternal localWebViewFeatureInternal4 = new WebViewFeatureInternal("DISABLED_ACTION_MODE_MENU_ITEMS", 3, "DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS", 24);
    starts = localWebViewFeatureInternal4;
    WebViewFeatureInternal localWebViewFeatureInternal5 = new WebViewFeatureInternal("START_SAFE_BROWSING", 4, "START_SAFE_BROWSING", "START_SAFE_BROWSING", 27);
    generator = localWebViewFeatureInternal5;
    WebViewFeatureInternal localWebViewFeatureInternal6 = new WebViewFeatureInternal("SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_DEPRECATED", 5, "SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST", 27);
    alpha = localWebViewFeatureInternal6;
    WebViewFeatureInternal localWebViewFeatureInternal7 = new WebViewFeatureInternal("SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_PREFERRED", 6, "SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST", 27);
    y = localWebViewFeatureInternal7;
    WebViewFeatureInternal localWebViewFeatureInternal8 = new WebViewFeatureInternal("SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_DEPRECATED", 7, "SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST", 27);
    WIDTH = localWebViewFeatureInternal8;
    WebViewFeatureInternal localWebViewFeatureInternal9 = new WebViewFeatureInternal("SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_PREFERRED", 8, "SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST", 27);
    HEIGHT = localWebViewFeatureInternal9;
    WebViewFeatureInternal localWebViewFeatureInternal10 = new WebViewFeatureInternal("SAFE_BROWSING_PRIVACY_POLICY_URL", 9, "SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL", 27);
    GOAL = localWebViewFeatureInternal10;
    WebViewFeatureInternal localWebViewFeatureInternal11 = new WebViewFeatureInternal("SERVICE_WORKER_BASIC_USAGE", 10, "SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE", 24);
    METRIC = localWebViewFeatureInternal11;
    WebViewFeatureInternal localWebViewFeatureInternal12 = new WebViewFeatureInternal("SERVICE_WORKER_CACHE_MODE", 11, "SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE", 24);
    NAME = localWebViewFeatureInternal12;
    WebViewFeatureInternal localWebViewFeatureInternal13 = new WebViewFeatureInternal("SERVICE_WORKER_CONTENT_ACCESS", 12, "SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS", 24);
    WALL = localWebViewFeatureInternal13;
    WebViewFeatureInternal localWebViewFeatureInternal14 = new WebViewFeatureInternal("SERVICE_WORKER_FILE_ACCESS", 13, "SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS", 24);
    EMPTY = localWebViewFeatureInternal14;
    WebViewFeatureInternal localWebViewFeatureInternal15 = new WebViewFeatureInternal("SERVICE_WORKER_BLOCK_NETWORK_LOADS", 14, "SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS", 24);
    SCHEMA = localWebViewFeatureInternal15;
    WebViewFeatureInternal localWebViewFeatureInternal16 = new WebViewFeatureInternal("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", 15, "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", 24);
    TOOBIG = localWebViewFeatureInternal16;
    WebViewFeatureInternal localWebViewFeatureInternal17 = new WebViewFeatureInternal("RECEIVE_WEB_RESOURCE_ERROR", 16, "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR", 23);
    CONSTRAINT = localWebViewFeatureInternal17;
    WebViewFeatureInternal localWebViewFeatureInternal18 = new WebViewFeatureInternal("RECEIVE_HTTP_ERROR", 17, "RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR", 23);
    MISMATCH = localWebViewFeatureInternal18;
    WebViewFeatureInternal localWebViewFeatureInternal19 = new WebViewFeatureInternal("SHOULD_OVERRIDE_WITH_REDIRECTS", 18, "SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS", 24);
    DSB = localWebViewFeatureInternal19;
    WebViewFeatureInternal localWebViewFeatureInternal20 = new WebViewFeatureInternal("SAFE_BROWSING_HIT", 19, "SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT", 27);
    SE = localWebViewFeatureInternal20;
    WebViewFeatureInternal localWebViewFeatureInternal21 = new WebViewFeatureInternal("WEB_RESOURCE_REQUEST_IS_REDIRECT", 20, "WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT", 24);
    any = localWebViewFeatureInternal21;
    WebViewFeatureInternal localWebViewFeatureInternal22 = new WebViewFeatureInternal("WEB_RESOURCE_ERROR_GET_DESCRIPTION", 21, "WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION", 23);
    exact = localWebViewFeatureInternal22;
    WebViewFeatureInternal localWebViewFeatureInternal23 = new WebViewFeatureInternal("WEB_RESOURCE_ERROR_GET_CODE", 22, "WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE", 23);
    DEBUG = localWebViewFeatureInternal23;
    WebViewFeatureInternal localWebViewFeatureInternal24 = new WebViewFeatureInternal("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", 23, "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", 27);
    ZERO = localWebViewFeatureInternal24;
    WebViewFeatureInternal localWebViewFeatureInternal25 = new WebViewFeatureInternal("SAFE_BROWSING_RESPONSE_PROCEED", 24, "SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED", 27);
    PLUS_I = localWebViewFeatureInternal25;
    WebViewFeatureInternal localWebViewFeatureInternal26 = new WebViewFeatureInternal("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", 25, "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", 27);
    MINUS_I = localWebViewFeatureInternal26;
    WebViewFeatureInternal localWebViewFeatureInternal27 = new WebViewFeatureInternal("WEB_MESSAGE_PORT_POST_MESSAGE", 26, "WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE", 23);
    PLUS_J = localWebViewFeatureInternal27;
    WebViewFeatureInternal localWebViewFeatureInternal28 = new WebViewFeatureInternal("WEB_MESSAGE_PORT_CLOSE", 27, "WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE", 23);
    MINUS_J = localWebViewFeatureInternal28;
    WebViewFeatureInternal localWebViewFeatureInternal29 = new WebViewFeatureInternal("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", 28, "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", 23);
    PLUS_K = localWebViewFeatureInternal29;
    WebViewFeatureInternal localWebViewFeatureInternal30 = new WebViewFeatureInternal("CREATE_WEB_MESSAGE_CHANNEL", 29, "CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL", 23);
    MINUS_K = localWebViewFeatureInternal30;
    WebViewFeatureInternal localWebViewFeatureInternal31 = new WebViewFeatureInternal("POST_WEB_MESSAGE", 30, "POST_WEB_MESSAGE", "POST_WEB_MESSAGE", 23);
    NaN = localWebViewFeatureInternal31;
    WebViewFeatureInternal localWebViewFeatureInternal32 = new WebViewFeatureInternal("WEB_MESSAGE_CALLBACK_ON_MESSAGE", 31, "WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE", 23);
    POSITIVE_INFINITY = localWebViewFeatureInternal32;
    WebViewFeatureInternal localWebViewFeatureInternal33 = new WebViewFeatureInternal("GET_WEB_VIEW_CLIENT", 32, "GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT", 26);
    NEGATIVE_INFINITY = localWebViewFeatureInternal33;
    WebViewFeatureInternal localWebViewFeatureInternal34 = new WebViewFeatureInternal("GET_WEB_CHROME_CLIENT", 33, "GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT", 26);
    sell = localWebViewFeatureInternal34;
    WebViewFeatureInternal localWebViewFeatureInternal35 = new WebViewFeatureInternal("GET_WEB_VIEW_RENDERER", 34, "GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER", 29);
    updated = localWebViewFeatureInternal35;
    WebViewFeatureInternal localWebViewFeatureInternal36 = new WebViewFeatureInternal("WEB_VIEW_RENDERER_TERMINATE", 35, "WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE", 29);
    conn = localWebViewFeatureInternal36;
    WebViewFeatureInternal localWebViewFeatureInternal37 = new WebViewFeatureInternal("TRACING_CONTROLLER_BASIC_USAGE", 36, "TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE", 28);
    created = localWebViewFeatureInternal37;
    WebViewFeatureInternal localWebViewFeatureInternal38 = new WebViewFeatureInternal("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", 37, "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", 29);
    destroyed = localWebViewFeatureInternal38;
    WebViewFeatureInternal localWebViewFeatureInternal39 = new WebViewFeatureInternal("PROXY_OVERRIDE", 38, "PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
    webView = localWebViewFeatureInternal39;
    WebViewFeatureInternal localWebViewFeatureInternal40 = new WebViewFeatureInternal("SUPPRESS_ERROR_PAGE", 39, "SUPPRESS_ERROR_PAGE", "SUPPRESS_ERROR_PAGE");
    relative = localWebViewFeatureInternal40;
    WebViewFeatureInternal localWebViewFeatureInternal41 = new WebViewFeatureInternal("MULTI_PROCESS", 40, "MULTI_PROCESS", "MULTI_PROCESS_QUERY");
    absolute = localWebViewFeatureInternal41;
    WebViewFeatureInternal localWebViewFeatureInternal42 = new WebViewFeatureInternal("FORCE_DARK", 41, "FORCE_DARK", "FORCE_DARK");
    o = localWebViewFeatureInternal42;
    WebViewFeatureInternal localWebViewFeatureInternal43 = new WebViewFeatureInternal("FORCE_DARK_STRATEGY", 42, "FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
    d = localWebViewFeatureInternal43;
    WebViewFeatureInternal localWebViewFeatureInternal44 = new WebViewFeatureInternal("WEB_MESSAGE_LISTENER", 43, "WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
    tx = localWebViewFeatureInternal44;
    WebViewFeatureInternal localWebViewFeatureInternal45 = new WebViewFeatureInternal("DOCUMENT_START_SCRIPT", 44, "DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
    colours = localWebViewFeatureInternal45;
    values = new WebViewFeatureInternal[] { localWebViewFeatureInternal1, localWebViewFeatureInternal2, localWebViewFeatureInternal3, localWebViewFeatureInternal4, localWebViewFeatureInternal5, localWebViewFeatureInternal6, localWebViewFeatureInternal7, localWebViewFeatureInternal8, localWebViewFeatureInternal9, localWebViewFeatureInternal10, localWebViewFeatureInternal11, localWebViewFeatureInternal12, localWebViewFeatureInternal13, localWebViewFeatureInternal14, localWebViewFeatureInternal15, localWebViewFeatureInternal16, localWebViewFeatureInternal17, localWebViewFeatureInternal18, localWebViewFeatureInternal19, localWebViewFeatureInternal20, localWebViewFeatureInternal21, localWebViewFeatureInternal22, localWebViewFeatureInternal23, localWebViewFeatureInternal24, localWebViewFeatureInternal25, localWebViewFeatureInternal26, localWebViewFeatureInternal27, localWebViewFeatureInternal28, localWebViewFeatureInternal29, localWebViewFeatureInternal30, localWebViewFeatureInternal31, localWebViewFeatureInternal32, localWebViewFeatureInternal33, localWebViewFeatureInternal34, localWebViewFeatureInternal35, localWebViewFeatureInternal36, localWebViewFeatureInternal37, localWebViewFeatureInternal38, localWebViewFeatureInternal39, localWebViewFeatureInternal40, localWebViewFeatureInternal41, localWebViewFeatureInternal42, localWebViewFeatureInternal43, localWebViewFeatureInternal44, localWebViewFeatureInternal45 };
  }
  
  private WebViewFeatureInternal(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, -1);
  }
  
  private WebViewFeatureInternal(String paramString1, String paramString2, int paramInt)
  {
    key = paramString1;
    s = paramString2;
    c = paramInt;
  }
  
  public static boolean add(String paramString, Collection paramCollection)
  {
    HashSet localHashSet = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Music localMusic = (Music)paramCollection.next();
      if (localMusic.get().equals(paramString)) {
        localHashSet.add(localMusic);
      }
    }
    if (!localHashSet.isEmpty())
    {
      paramString = localHashSet.iterator();
      while (paramString.hasNext()) {
        if (((Music)paramString.next()).add()) {
          return true;
        }
      }
      return false;
    }
    paramCollection = new StringBuilder();
    paramCollection.append("Unknown feature ");
    paramCollection.append(paramString);
    throw new RuntimeException(paramCollection.toString());
  }
  
  public static UnsupportedOperationException c()
  {
    return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
  }
  
  public static boolean getValue(String paramString)
  {
    HashSet localHashSet = new HashSet();
    WebViewFeatureInternal[] arrayOfWebViewFeatureInternal = values();
    int k = arrayOfWebViewFeatureInternal.length;
    int j = 0;
    while (j < k)
    {
      localHashSet.add(arrayOfWebViewFeatureInternal[j]);
      j += 1;
    }
    return add(paramString, localHashSet);
  }
  
  public boolean a()
  {
    int j = c;
    if (j == -1) {
      return false;
    }
    return Build.VERSION.SDK_INT >= j;
  }
  
  public boolean add()
  {
    return (a()) || (d());
  }
  
  public boolean d()
  {
    return org.chromium.support_lib_boundary.a.a.b(a.s, s);
  }
  
  public String get()
  {
    return key;
  }
  
  private static class a
  {
    static final Set<String> s = new HashSet(Arrays.asList(h.i().get()));
  }
}
