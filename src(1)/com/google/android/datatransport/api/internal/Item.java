package com.google.android.datatransport.api.internal;

import com.google.firebase.common.ByteVector;
import com.google.firebase.common.ui.d;
import java.util.List;

public abstract class Item
{
  public Item() {}
  
  public static Item a(List paramList)
  {
    return new GOST3410Parameters(paramList);
  }
  
  public static ByteVector a()
  {
    return new d().a(Frame.i).a(true).b();
  }
  
  public abstract List getQ();
}
