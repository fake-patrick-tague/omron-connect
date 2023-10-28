package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
public final class TcpConnection
{
  static final CharSequence toString(Object paramObject, String paramString)
  {
    paramObject.getClass();
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
}
