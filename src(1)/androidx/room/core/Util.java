package androidx.room.core;

public class Util
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  
  public static void format(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("?");
      if (i < paramInt - 1) {
        paramStringBuilder.append(",");
      }
      i += 1;
    }
  }
  
  public static StringBuilder split()
  {
    return new StringBuilder();
  }
}
