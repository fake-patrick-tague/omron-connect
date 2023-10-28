package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

public final class Item
{
  public static final Item c = new Item(0, 0, 0, 0);
  public final int b;
  public final int left;
  public final int right;
  public final int y;
  
  private Item(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y = paramInt1;
    b = paramInt2;
    left = paramInt3;
    right = paramInt4;
  }
  
  public static Item a(Insets paramInsets)
  {
    return set(left, top, right, bottom);
  }
  
  public static Item a(Item paramItem1, Item paramItem2)
  {
    return set(Math.max(y, y), Math.max(b, b), Math.max(left, left), Math.max(right, right));
  }
  
  public static Item set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)) {
      return c;
    }
    return new Item(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Item toString(Rect paramRect)
  {
    return set(left, top, right, bottom);
  }
  
  public Insets a()
  {
    return ByteVector.add(y, b, left, right);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (b.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Item)paramObject;
      if (right != right) {
        return false;
      }
      if (y != y) {
        return false;
      }
      if (left != left) {
        return false;
      }
      return b == b;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((y * 31 + b) * 31 + left) * 31 + right;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Insets{left=");
    localStringBuilder.append(y);
    localStringBuilder.append(", top=");
    localStringBuilder.append(b);
    localStringBuilder.append(", right=");
    localStringBuilder.append(left);
    localStringBuilder.append(", bottom=");
    localStringBuilder.append(right);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
