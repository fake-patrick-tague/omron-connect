package androidx.core.package_10;

import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.MessagingStyle;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7.v7.text.BidiFormatter;

public class Label
  extends ByteVector
{
  private final List<androidx.core.app.m.g.a> a = new ArrayList();
  private Boolean b;
  private h c;
  private final List<androidx.core.app.m.g.a> f = new ArrayList();
  private CharSequence k;
  
  public Label(h paramH)
  {
    if (!TextUtils.isEmpty(paramH.get()))
    {
      c = paramH;
      return;
    }
    throw new IllegalArgumentException("User's name must not be empty.");
  }
  
  private boolean b()
  {
    int i = a.size() - 1;
    while (i >= 0)
    {
      m.g.a localA = (m.g.a)a.get(i);
      if ((localA.get() != null) && (localA.get().get() == null)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private m.g.a d()
  {
    int i = a.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (m.g.a)a.get(i);
      if ((((m.g.a)localObject).get() != null) && (!TextUtils.isEmpty(((m.g.a)localObject).get().get()))) {
        return localObject;
      }
      i -= 1;
    }
    if (!a.isEmpty())
    {
      localObject = a;
      return (m.g.a)((List)localObject).get(((List)localObject).size() - 1);
    }
    return null;
  }
  
  private CharSequence get(m.g.a paramA)
  {
    BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j;
    if (Build.VERSION.SDK_INT >= 21) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (j != 0) {
      i = -16777216;
    } else {
      i = -1;
    }
    Object localObject1 = paramA.get();
    String str = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = paramA.get().get();
    }
    int m = i;
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = c.get();
      m = i;
      localObject2 = localObject1;
      if (j != 0)
      {
        m = i;
        localObject2 = localObject1;
        if (mBuilder.a() != 0)
        {
          m = mBuilder.a();
          localObject2 = localObject1;
        }
      }
    }
    localObject1 = localBidiFormatter.unicodeWrap((CharSequence)localObject2);
    localSpannableStringBuilder.append((CharSequence)localObject1);
    localSpannableStringBuilder.setSpan(getColor(m), localSpannableStringBuilder.length() - ((CharSequence)localObject1).length(), localSpannableStringBuilder.length(), 33);
    if (paramA.getValue() == null) {
      paramA = str;
    } else {
      paramA = paramA.getValue();
    }
    localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap((CharSequence)paramA));
    return localSpannableStringBuilder;
  }
  
  private TextAppearanceSpan getColor(int paramInt)
  {
    return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
  }
  
  public Label a(m.g.a paramA)
  {
    if (paramA != null)
    {
      a.add(paramA);
      if (a.size() > 25) {
        a.remove(0);
      }
    }
    return this;
  }
  
  public Label a(CharSequence paramCharSequence, long paramLong, h paramH)
  {
    a(new m.g.a(paramCharSequence, paramLong, paramH));
    return this;
  }
  
  public Label a(boolean paramBoolean)
  {
    b = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public boolean a()
  {
    Object localObject = mBuilder;
    if ((localObject != null) && (mContext.getApplicationInfo().targetSdkVersion < 28) && (b == null))
    {
      if (k != null) {
        return true;
      }
    }
    else
    {
      localObject = b;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    return false;
  }
  
  public void addCompatExtras(Bundle paramBundle)
  {
    super.addCompatExtras(paramBundle);
    paramBundle.putCharSequence("android.selfDisplayName", c.get());
    paramBundle.putBundle("android.messagingStyleUser", c.onSaveInstanceState());
    paramBundle.putCharSequence("android.hiddenConversationTitle", k);
    if ((k != null) && (b.booleanValue())) {
      paramBundle.putCharSequence("android.conversationTitle", k);
    }
    if (!a.isEmpty()) {
      paramBundle.putParcelableArray("android.messages", m.g.a.a(a));
    }
    if (!f.isEmpty()) {
      paramBundle.putParcelableArray("android.messages.historic", m.g.a.a(f));
    }
    Boolean localBoolean = b;
    if (localBoolean != null) {
      paramBundle.putBoolean("android.isGroupConversation", localBoolean.booleanValue());
    }
  }
  
  public void apply(Duration paramDuration)
  {
    a(a());
    int i = Build.VERSION.SDK_INT;
    Object localObject2;
    if (i >= 24)
    {
      if (i >= 28) {
        localObject1 = new Notification.MessagingStyle(c.getText());
      } else {
        localObject1 = new Notification.MessagingStyle(c.get());
      }
      localObject2 = a.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Notification.MessagingStyle)localObject1).addMessage(((m.g.a)((Iterator)localObject2).next()).apply());
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject2 = f.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Notification.MessagingStyle)localObject1).addHistoricMessage(((m.g.a)((Iterator)localObject2).next()).apply());
        }
      }
      if ((b.booleanValue()) || (Build.VERSION.SDK_INT >= 28)) {
        ((Notification.MessagingStyle)localObject1).setConversationTitle(k);
      }
      if (Build.VERSION.SDK_INT >= 28) {
        ((Notification.MessagingStyle)localObject1).setGroupConversation(b.booleanValue());
      }
      ((Notification.MessagingStyle)localObject1).setBuilder(paramDuration.getValue());
      return;
    }
    Object localObject1 = d();
    if ((k != null) && (b.booleanValue()))
    {
      paramDuration.getValue().setContentTitle(k);
    }
    else if (localObject1 != null)
    {
      paramDuration.getValue().setContentTitle("");
      if (((m.g.a)localObject1).get() != null) {
        paramDuration.getValue().setContentTitle(((m.g.a)localObject1).get().get());
      }
    }
    if (localObject1 != null)
    {
      localObject2 = paramDuration.getValue();
      if (k != null) {
        localObject1 = get((m.g.a)localObject1);
      } else {
        localObject1 = ((m.g.a)localObject1).getValue();
      }
      ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
    }
    if (i >= 16)
    {
      localObject2 = new SpannableStringBuilder();
      if ((k == null) && (!b())) {
        i = 0;
      } else {
        i = 1;
      }
      int j = a.size() - 1;
      while (j >= 0)
      {
        localObject1 = (m.g.a)a.get(j);
        if (i != 0) {
          localObject1 = get((m.g.a)localObject1);
        } else {
          localObject1 = ((m.g.a)localObject1).getValue();
        }
        if (j != a.size() - 1) {
          ((SpannableStringBuilder)localObject2).insert(0, "\n");
        }
        ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
        j -= 1;
      }
      new Notification.BigTextStyle(paramDuration.getValue()).setBigContentTitle(null).bigText((CharSequence)localObject2);
    }
  }
  
  protected String getClassName()
  {
    return "androidx.core.app.NotificationCompat$MessagingStyle";
  }
}
