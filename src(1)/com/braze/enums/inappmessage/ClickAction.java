package com.braze.enums.inappmessage;

public enum ClickAction
{
  static
  {
    FUTURE = new ClickAction("URI", 1);
    NONE = new ClickAction("NONE", 2);
  }
}
