package androidx.cardview.widget;

class CardViewJellybeanMr1
  extends CardViewEclairMr1
{
  CardViewJellybeanMr1() {}
  
  public void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new CardViewJellybeanMr1.1(this);
  }
}
