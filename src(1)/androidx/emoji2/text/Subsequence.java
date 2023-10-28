package androidx.emoji2.text;

class Subsequence
{
  private final long base;
  private final long size;
  
  Subsequence(long paramLong1, long paramLong2)
  {
    size = paramLong1;
    base = paramLong2;
  }
  
  long size()
  {
    return size;
  }
}
