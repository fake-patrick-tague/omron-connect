package com.google.android.datatransport.asm;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.ByteVector;

final class d
  implements x
{
  private Context a;
  
  private d() {}
  
  public i a()
  {
    ByteVector.add(a, Context.class);
    return new MethodWriter(a, null);
  }
  
  public d b(Context paramContext)
  {
    a = ((Context)ByteVector.get(paramContext));
    return this;
  }
}
