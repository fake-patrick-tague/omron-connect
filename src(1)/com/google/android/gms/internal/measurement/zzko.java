package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzko
  extends IOException
{
  public zzko(String paramString)
  {
    super(paramString);
  }
  
  static zzko g()
  {
    return new zzko("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzkn getEWAHIterator()
  {
    return new zzkn("Protocol message tag had invalid wire type.");
  }
  
  static zzko getSort()
  {
    return new zzko("Failed to parse the message.");
  }
  
  static zzko getStep()
  {
    return new zzko("Protocol message contained an invalid tag (zero).");
  }
  
  static zzko visitParameterAnnotation()
  {
    return new zzko("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzko write()
  {
    return new zzko("Protocol message had invalid UTF-8.");
  }
}
