package com.drweb.urlfiltr._Old;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;

/**
 * Created by a.sviridenko on 20.01.2016.
 */
public class Utils2 {

    //устанавливает из гуглпеля пакет
    static public  void   installByGooglePlay(String pkgName)
    {
        String PLAY_PKG = "com.android.vending";
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(pkgName);
        if(intent==null)
        {
            Intent playIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + pkgName));
            playIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(playIntent);

            mDevice.wait(Until.hasObject(By.pkg(PLAY_PKG).depth(0)), 40000);

            mDevice.findObject(By.res(PLAY_PKG, "buy_button")).click();


            UiObject2 continue_button = mDevice.wait(Until.findObject(By.res(PLAY_PKG, "continue_button")), 30000);
            continue_button.click();


            //ждем окончания установки
            //mDevice.wait(Until.findObject(By.res(PLAY_PKG, "launch_button")), 500000);
            mDevice.waitForIdle();
            mDevice.pressHome();
            mDevice.waitForIdle();
        }
    }

}
