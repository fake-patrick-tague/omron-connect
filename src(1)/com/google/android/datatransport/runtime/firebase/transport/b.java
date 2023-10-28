package com.google.android.datatransport.runtime.firebase.transport;

public final class b
{
  private static final b c = new NumberPicker.TwoDigitFormatter().format();
  private final ClassWriter a;
  
  b(ClassWriter paramClassWriter)
  {
    a = paramClassWriter;
  }
  
  public static NumberPicker.TwoDigitFormatter create()
  {
    return new NumberPicker.TwoDigitFormatter();
  }
  
  public ClassWriter a()
  {
    return a;
  }
}
