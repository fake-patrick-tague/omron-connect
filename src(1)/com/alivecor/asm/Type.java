package com.alivecor.asm;

import android.util.Log;
import com.alivecor.neuralsuite.NeuralSuite.InversionResult;

public class Type
{
  public final Series a;
  public final String c;
  public final int d;
  
  public Type(NeuralSuite.InversionResult paramInversionResult)
  {
    Log.e(f.TAG, "Inside InversionRunner RunResult");
    int i = status;
    d = i;
    if (i == 0)
    {
      paramInversionResult = new Series(paramInversionResult);
      a = paramInversionResult;
      paramInversionResult.b("1");
      paramInversionResult.e("0");
      paramInversionResult.a("0");
      c = null;
      return;
    }
    a = null;
    c = errorMsg;
  }
  
  public boolean a()
  {
    return d == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RunResult{result=");
    localStringBuilder.append(a);
    localStringBuilder.append(", status=");
    localStringBuilder.append(d);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
