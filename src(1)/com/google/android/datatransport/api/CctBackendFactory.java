package com.google.android.datatransport.api;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.Type;
import com.google.android.datatransport.runtime.backends.c;
import com.google.android.datatransport.runtime.backends.e;

@Keep
public class CctBackendFactory
  implements c
{
  public CctBackendFactory() {}
  
  public e create(Type paramType)
  {
    return new ClassWriter(paramType.getValue(), paramType.a(), paramType.getName());
  }
}
