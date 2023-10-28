package androidx.work;

public enum NetworkType
{
  static
  {
    NetworkType localNetworkType1 = new NetworkType("NOT_REQUIRED", 0);
    c = localNetworkType1;
    NetworkType localNetworkType2 = new NetworkType("CONNECTED", 1);
    g = localNetworkType2;
    NetworkType localNetworkType3 = new NetworkType("UNMETERED", 2);
    a = localNetworkType3;
    NetworkType localNetworkType4 = new NetworkType("NOT_ROAMING", 3);
    d = localNetworkType4;
    NetworkType localNetworkType5 = new NetworkType("METERED", 4);
    r = localNetworkType5;
    NetworkType localNetworkType6 = new NetworkType("TEMPORARILY_UNMETERED", 5);
    b = localNetworkType6;
    $VALUES = new NetworkType[] { localNetworkType1, localNetworkType2, localNetworkType3, localNetworkType4, localNetworkType5, localNetworkType6 };
  }
}
