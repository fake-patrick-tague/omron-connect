package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzaq
  extends zzgs
{
  private String data;
  private long date;
  private Boolean directory;
  private AccountManager instance;
  private long value;
  
  zzaq(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  final boolean doInBackground()
  {
    append();
    long l = this$0.zzav().currentTimeMillis();
    if (l - date > 86400000L) {
      directory = null;
    }
    Object localObject = directory;
    if (localObject == null)
    {
      if (ContextCompat.checkSelfPermission(this$0.zzau(), "android.permission.GET_ACCOUNTS") != 0)
      {
        this$0.zzay().getHtml().append("Permission error checking for dasher/unicorn accounts");
        date = l;
        directory = Boolean.FALSE;
        return false;
      }
      if (instance == null) {
        instance = AccountManager.get(this$0.zzau());
      }
      localObject = instance;
      try
      {
        localObject = ((AccountManager)localObject).getAccountsByTypeAndFeatures("com.google", new String[] { "service_HOSTED" }, null, null).getResult();
        localObject = (Account[])localObject;
        if ((localObject != null) && (localObject.length > 0))
        {
          directory = Boolean.TRUE;
          date = l;
          return true;
        }
        localObject = instance;
        localObject = ((AccountManager)localObject).getAccountsByTypeAndFeatures("com.google", new String[] { "service_uca" }, null, null).getResult();
        localObject = (Account[])localObject;
        if ((localObject == null) || (localObject.length <= 0)) {
          break label246;
        }
        directory = Boolean.TRUE;
        date = l;
        return true;
      }
      catch (OperationCanceledException localOperationCanceledException) {}catch (IOException localIOException) {}catch (AuthenticatorException localAuthenticatorException) {}
      this$0.zzay().getText().append("Exception checking account types", localAuthenticatorException);
      label246:
      date = l;
      directory = Boolean.FALSE;
      return false;
    }
    return localAuthenticatorException.booleanValue();
  }
  
  public final String elementAt()
  {
    size();
    return data;
  }
  
  final long getDateTime()
  {
    append();
    return date;
  }
  
  public final long getValue()
  {
    size();
    return value;
  }
  
  protected final boolean parse()
  {
    Object localObject1 = Calendar.getInstance();
    value = TimeUnit.MINUTES.convert(((Calendar)localObject1).get(15) + ((Calendar)localObject1).get(16), TimeUnit.MILLISECONDS);
    Object localObject2 = Locale.getDefault();
    localObject1 = ((Locale)localObject2).getLanguage();
    Object localObject3 = Locale.ENGLISH;
    localObject1 = ((String)localObject1).toLowerCase((Locale)localObject3);
    localObject2 = ((Locale)localObject2).getCountry().toLowerCase((Locale)localObject3);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append((String)localObject2);
    data = ((StringBuilder)localObject3).toString();
    return false;
  }
  
  final void trim()
  {
    append();
    directory = null;
    date = 0L;
  }
}
