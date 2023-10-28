package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class Label<S>
  extends Fragment
{
  protected final LinkedHashSet<j<S>> f = new LinkedHashSet();
  
  Label() {}
  
  boolean a(p paramP)
  {
    return f.add(paramP);
  }
  
  void b()
  {
    f.clear();
  }
}
