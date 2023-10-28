package com.google.android.datatransport.api.internal;

import android.util.SparseArray;

public enum QosTier
{
  private static final SparseArray<com.google.android.datatransport.cct.internal.QosTier> table;
  private final int nps;
  
  static
  {
    QosTier localQosTier1 = new QosTier("DEFAULT", 0, 0);
    e = localQosTier1;
    QosTier localQosTier2 = new QosTier("UNMETERED_ONLY", 1, 1);
    b = localQosTier2;
    QosTier localQosTier3 = new QosTier("UNMETERED_OR_DAILY", 2, 2);
    d = localQosTier3;
    QosTier localQosTier4 = new QosTier("FAST_IF_RADIO_AWAKE", 3, 3);
    c = localQosTier4;
    QosTier localQosTier5 = new QosTier("NEVER", 4, 4);
    alpha = localQosTier5;
    QosTier localQosTier6 = new QosTier("UNRECOGNIZED", 5, -1);
    context = localQosTier6;
    values = new QosTier[] { localQosTier1, localQosTier2, localQosTier3, localQosTier4, localQosTier5, localQosTier6 };
    SparseArray localSparseArray = new SparseArray();
    table = localSparseArray;
    localSparseArray.put(0, localQosTier1);
    localSparseArray.put(1, localQosTier2);
    localSparseArray.put(2, localQosTier3);
    localSparseArray.put(3, localQosTier4);
    localSparseArray.put(4, localQosTier5);
    localSparseArray.put(-1, localQosTier6);
  }
  
  private QosTier(int paramInt)
  {
    nps = paramInt;
  }
}
