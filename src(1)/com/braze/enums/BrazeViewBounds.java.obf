package com.braze.enums;

public enum BrazeViewBounds
{
  private final int heightDp;
  private final int widthDp;
  
  static
  {
    BASE_CARD_VIEW = new BrazeViewBounds("BASE_CARD_VIEW", 4, 512, 512);
    IN_APP_MESSAGE_MODAL = new BrazeViewBounds("IN_APP_MESSAGE_MODAL", 5, 580, 580);
    IN_APP_MESSAGE_SLIDEUP = new BrazeViewBounds("IN_APP_MESSAGE_SLIDEUP", 6, 100, 100);
    NO_BOUNDS = new BrazeViewBounds("NO_BOUNDS", 7, 0, 0);
  }
  
  private BrazeViewBounds(int paramInt1, int paramInt2)
  {
    widthDp = paramInt1;
    heightDp = paramInt2;
  }
  
  public final int getHeightDp()
  {
    return heightDp;
  }
  
  public final int getWidthDp()
  {
    return widthDp;
  }
}
