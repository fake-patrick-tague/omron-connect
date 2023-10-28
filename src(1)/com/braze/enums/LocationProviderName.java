package com.braze.enums;

public enum LocationProviderName
{
  static
  {
    NETWORK = new LocationProviderName("NETWORK", 1);
    PASSIVE = new LocationProviderName("PASSIVE", 2);
  }
}
