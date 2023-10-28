package androidx.emoji2.text;

import java.util.Set;
import v7.v7.util.Log;

public abstract class Item
{
  final Attribute a;
  boolean b;
  boolean c;
  Set<g.e> children;
  boolean h;
  int i = 0;
  int j = -16711936;
  int[] k;
  g type = new k();
  
  protected Item(Attribute paramAttribute)
  {
    Log.get(paramAttribute, "metadataLoader cannot be null.");
    a = paramAttribute;
  }
  
  protected final Attribute a()
  {
    return a;
  }
  
  public Item a(int paramInt)
  {
    i = paramInt;
    return this;
  }
}
