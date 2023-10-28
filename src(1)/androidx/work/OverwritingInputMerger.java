package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class OverwritingInputMerger
  extends Attribute
{
  public OverwritingInputMerger() {}
  
  public Label a(List paramList)
  {
    Item localItem = new Item();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashMap.putAll(((Label)paramList.next()).build());
    }
    localItem.add(localHashMap);
    return localItem.a();
  }
}
