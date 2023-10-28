package com.google.android.gms.common.server.response;

import java.io.BufferedReader;
import java.io.IOException;

abstract interface Object<O>
{
  public abstract java.lang.Object deserialize(FastParser paramFastParser, BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException;
}
