package com.alivecor.mapsforge.core.model;

import com.alivecor.ecg.core.model.d.a;
import com.google.gson.v.c;

public enum Handle
{
  static
  {
    Handle localHandle1 = new Handle("KARDIA_MOBILE", 0);
    BOTTOM_RIGHT = localHandle1;
    Handle localHandle2 = new Handle("KARDIA_BAND", 1);
    TOP_LEFT = localHandle2;
    Handle localHandle3 = new Handle("TRIANGLE", 2);
    TOP = localHandle3;
    Handle localHandle4 = new Handle("OMRON_COMPLETE", 3);
    TOP_RIGHT = localHandle4;
    Handle localHandle5 = new Handle("UNSPECIFIED", 4);
    RIGHT = localHandle5;
    $VALUES = new Handle[] { localHandle1, localHandle2, localHandle3, localHandle4, localHandle5 };
  }
}
