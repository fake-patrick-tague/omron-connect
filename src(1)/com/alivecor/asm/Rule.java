package com.alivecor.asm;

import com.alivecor.kardia_ai.AlgorithmDetermination;

public class Rule
{
  public final String action;
  public final boolean b;
  public final boolean id;
  public final boolean mode;
  public final int priority;
  
  public Rule(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AlgorithmDetermination paramAlgorithmDetermination, int paramInt)
  {
    mode = paramBoolean1;
    b = paramBoolean2;
    id = paramBoolean3;
    action = getAction(paramAlgorithmDetermination);
    priority = paramInt;
  }
  
  private String getAction(AlgorithmDetermination paramAlgorithmDetermination)
  {
    int i = Intents.OVERVIEW[paramAlgorithmDetermination.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 6)
            {
              if (i != 7) {
                return "undetermined";
              }
              return "afib";
            }
            return "normal";
          }
          return "too long";
        }
        return "too short";
      }
      return "noise";
    }
    return "none";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlgSuiteTestData{afib=");
    localStringBuilder.append(mode);
    localStringBuilder.append(", nsr=");
    localStringBuilder.append(b);
    localStringBuilder.append(", noise=");
    localStringBuilder.append(id);
    localStringBuilder.append(", endDetermination='");
    localStringBuilder.append(action);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
