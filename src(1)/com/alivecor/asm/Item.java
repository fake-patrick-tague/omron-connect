package com.alivecor.asm;

public class Item
{
  public final Rule a;
  public final ClassifierData b;
  public final int c;
  public final String d;
  
  public Item(ClassifierData paramClassifierData, Rule paramRule, int paramInt)
  {
    b = paramClassifierData;
    c = paramInt;
    d = null;
    a = paramRule;
  }
  
  public Item(String paramString)
  {
    d = paramString;
    c = 0;
    b = null;
    a = null;
  }
  
  public boolean a()
  {
    return d == null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RunResult{result=");
    localStringBuilder.append(b);
    localStringBuilder.append(", hr=");
    localStringBuilder.append(c);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
