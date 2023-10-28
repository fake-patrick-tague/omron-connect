package androidx.emoji2.text.asm;

public abstract class ClassWriter
{
  private static ClassWriter index;
  
  public ClassWriter() {}
  
  public static ClassWriter newUTF8()
  {
    if (index == null) {
      index = new ByteVector();
    }
    return index;
  }
}
