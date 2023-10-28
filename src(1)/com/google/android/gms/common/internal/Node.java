package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;

public final class Node
{
  private static final Uri url = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
  private final int data;
  private final ComponentName key;
  private final String name;
  private final boolean next;
  private final String value;
  
  public Node(ComponentName paramComponentName, int paramInt)
  {
    name = null;
    value = null;
    Preconditions.checkNotNull(paramComponentName);
    key = paramComponentName;
    data = paramInt;
    next = false;
  }
  
  public Node(String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, "com.google.android.gms", paramInt, false);
  }
  
  public Node(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    name = paramString1;
    Preconditions.checkNotEmpty(paramString2);
    value = paramString2;
    key = null;
    data = paramInt;
    next = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Node)) {
      return false;
    }
    paramObject = (Node)paramObject;
    return (Objects.equal(name, name)) && (Objects.equal(value, value)) && (Objects.equal(key, key)) && (data == data) && (next == next);
  }
  
  public final Intent execute(Context paramContext)
  {
    if (name != null)
    {
      boolean bool = next;
      Object localObject1 = null;
      Object localObject2 = null;
      if (bool)
      {
        localObject1 = new Bundle();
        ((BaseBundle)localObject1).putString("serviceActionBundleKey", name);
        try
        {
          paramContext = paramContext.getContentResolver();
          Uri localUri = url;
          paramContext = paramContext.call(localUri, "serviceIntentCall", null, (Bundle)localObject1);
        }
        catch (IllegalArgumentException paramContext)
        {
          Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(paramContext.toString()));
          paramContext = null;
        }
        if (paramContext == null) {
          paramContext = localObject2;
        } else {
          paramContext = (Intent)paramContext.getParcelable("serviceResponseIntentKey");
        }
        localObject1 = paramContext;
        if (paramContext == null)
        {
          Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(name)));
          localObject1 = paramContext;
        }
      }
      if (localObject1 != null) {
        return localObject1;
      }
      return new Intent(name).setPackage(value);
    }
    return new Intent().setComponent(key);
  }
  
  public final int getType()
  {
    return data;
  }
  
  public final String getValue()
  {
    return value;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { name, value, key, Integer.valueOf(data), Boolean.valueOf(next) });
  }
  
  public final ComponentName remove()
  {
    return key;
  }
  
  public final String toString()
  {
    String str2 = name;
    String str1 = str2;
    if (str2 == null)
    {
      Preconditions.checkNotNull(key);
      str1 = key.flattenToString();
    }
    return str1;
  }
}
