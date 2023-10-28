package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class Name
{
  public final Uri value;
  
  public Name(Uri paramUri)
  {
    value = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Name)) {
      return false;
    }
    return Objects.equal(value, value);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { value });
  }
}
