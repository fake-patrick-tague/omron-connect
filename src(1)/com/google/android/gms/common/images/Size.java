package com.google.android.gms.common.images;

public final class Size
{
  private final int height;
  private final int width;
  
  public Size(int paramInt1, int paramInt2)
  {
    width = paramInt1;
    height = paramInt2;
  }
  
  private static NumberFormatException parseLong(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 16);
    localStringBuilder.append("Invalid Size: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.indexOf('*');
      i = j;
      if (j < 0) {
        i = paramString.indexOf('x');
      }
      if (i < 0) {}
    }
    try
    {
      j = Integer.parseInt(paramString.substring(0, i));
      Size localSize = new Size(j, Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw parseLong(paramString);
    throw parseLong(paramString);
    throw new IllegalArgumentException("string must not be null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Size))
    {
      paramObject = (Size)paramObject;
      if ((width == width) && (height == height)) {
        return true;
      }
    }
    return false;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public int hashCode()
  {
    int i = height;
    int j = width;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public String toString()
  {
    int i = width;
    int j = height;
    StringBuilder localStringBuilder = new StringBuilder(23);
    localStringBuilder.append(i);
    localStringBuilder.append("x");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
}
