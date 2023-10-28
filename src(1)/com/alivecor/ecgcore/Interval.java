package com.alivecor.ecgcore;

public class Interval
{
  private int length;
  private int start;
  
  public Interval(int paramInt1, int paramInt2)
  {
    start = paramInt1;
    length = paramInt2;
  }
  
  public boolean contains(int paramInt)
  {
    return (paramInt >= start()) && (paramInt <= get());
  }
  
  public int get()
  {
    return start + length;
  }
  
  public int length()
  {
    return length;
  }
  
  public int midpoint()
  {
    return start + length / 2;
  }
  
  public boolean overlaps(Interval paramInterval)
  {
    return (contains(paramInterval.start())) || (contains(paramInterval.get())) || (paramInterval.contains(start())) || (paramInterval.contains(get()));
  }
  
  public int start()
  {
    return start;
  }
  
  public Interval union(Interval paramInterval)
  {
    int i = Math.min(start(), paramInterval.start());
    return new Interval(i, Math.max(get(), paramInterval.get()) - i);
  }
}
