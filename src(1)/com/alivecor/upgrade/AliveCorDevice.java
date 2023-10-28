package com.alivecor.upgrade;

import com.google.gson.v.c;

public enum AliveCorDevice
{
  static
  {
    AliveCorDevice localAliveCorDevice1 = new AliveCorDevice("KARDIA_MOBILE", 0);
    KARDIA_MOBILE = localAliveCorDevice1;
    AliveCorDevice localAliveCorDevice2 = new AliveCorDevice("KARDIA_BAND", 1);
    KARDIA_BAND = localAliveCorDevice2;
    AliveCorDevice localAliveCorDevice3 = new AliveCorDevice("TRIANGLE", 2);
    TRIANGLE = localAliveCorDevice3;
    AliveCorDevice localAliveCorDevice4 = new AliveCorDevice("OMRON_COMPLETE", 3);
    OMRON_COMPLETE = localAliveCorDevice4;
    AliveCorDevice localAliveCorDevice5 = new AliveCorDevice("UNSPECIFIED", 4);
    UNSPECIFIED = localAliveCorDevice5;
    $VALUES = new AliveCorDevice[] { localAliveCorDevice1, localAliveCorDevice2, localAliveCorDevice3, localAliveCorDevice4, localAliveCorDevice5 };
  }
}
