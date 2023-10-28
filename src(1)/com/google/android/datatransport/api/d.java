package com.google.android.datatransport.api;

import com.google.android.datatransport.api.internal.Item;
import java.net.URL;

final class d
{
  final Item g;
  final String q;
  final URL u;
  
  d(URL paramURL, Item paramItem, String paramString)
  {
    u = paramURL;
    g = paramItem;
    q = paramString;
  }
  
  d a(URL paramURL)
  {
    return new d(paramURL, g, q);
  }
}
