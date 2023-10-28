package androidx.transition;

import android.view.View;
import android.view.WindowId;

class Tag
  implements Node
{
  private final WindowId _type;
  
  Tag(View paramView)
  {
    _type = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Tag)) && (_type.equals(_type));
  }
  
  public int hashCode()
  {
    return _type.hashCode();
  }
}
