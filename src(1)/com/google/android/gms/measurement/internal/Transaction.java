package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Set;

public final class Transaction
{
  private final zzfy this$0;
  
  public Transaction(zzfy paramZzfy)
  {
    this$0 = paramZzfy;
  }
  
  final void doInBackground()
  {
    this$0.zzaz().append();
    if (!isEmpty()) {
      return;
    }
    Object localObject;
    if (verify())
    {
      this$0.put().resources.put(null);
      localObject = new Bundle();
      ((BaseBundle)localObject).putString("source", "(not set)");
      ((BaseBundle)localObject).putString("medium", "(not set)");
      ((BaseBundle)localObject).putString("_cis", "intent");
      ((BaseBundle)localObject).putLong("_cc", 1L);
      this$0.add().put("auto", "_cmpx", (Bundle)localObject);
    }
    else
    {
      localObject = this$0.put().resources.getValue();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this$0.zzay().getText().append("Cache still valid but referrer not found");
      }
      else
      {
        long l = this$0.put().this$0.get() / 3600000L;
        localObject = Uri.parse((String)localObject);
        Bundle localBundle = new Bundle();
        Pair localPair = new Pair(((Uri)localObject).getPath(), localBundle);
        Iterator localIterator = ((Uri)localObject).getQueryParameterNames().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, ((Uri)localObject).getQueryParameter(str));
        }
        ((Bundle)second).putLong("_cc", (l - 1L) * 3600000L);
        localObject = first;
        if (localObject == null) {
          localObject = "app";
        } else {
          localObject = (String)localObject;
        }
        this$0.add().put((String)localObject, "_cmp", (Bundle)second);
      }
      this$0.put().resources.put(null);
    }
    this$0.put().this$0.put(0L);
  }
  
  final boolean isEmpty()
  {
    return this$0.put().this$0.get() > 0L;
  }
  
  final void load(String paramString, Bundle paramBundle)
  {
    this$0.zzaz().append();
    if (!this$0.size())
    {
      if (paramBundle.isEmpty())
      {
        paramString = null;
      }
      else
      {
        Object localObject = paramString;
        if (true == paramString.isEmpty()) {
          localObject = "auto";
        }
        paramString = new Uri.Builder();
        paramString.path((String)localObject);
        localObject = paramBundle.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString.appendQueryParameter(str, paramBundle.getString(str));
        }
        paramString = paramString.build().toString();
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this$0.put().resources.put(paramString);
        this$0.put().this$0.put(this$0.zzav().currentTimeMillis());
      }
    }
  }
  
  final void parse()
  {
    if ((isEmpty()) && (verify())) {
      this$0.put().resources.put(null);
    }
  }
  
  final boolean verify()
  {
    if (!isEmpty()) {
      return false;
    }
    return this$0.zzav().currentTimeMillis() - this$0.put().this$0.get() > this$0.append().put(null, zzeb.version);
  }
}
