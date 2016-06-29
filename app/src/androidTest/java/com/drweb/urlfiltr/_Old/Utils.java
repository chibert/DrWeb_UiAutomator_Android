package com.drweb.urlfiltr._Old;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

/**
 * Created by a.sviridenko on 20.01.2016.
 */
public class Utils {

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

            mDevice.wait(Until.hasObject(By.pkg(PLAY_PKG).depth(0)), 20000);

            mDevice.findObject(By.res(PLAY_PKG, "buy_button")).click();


            UiObject2 continue_button = mDevice.wait(Until.findObject(By.res(PLAY_PKG, "continue_button")), 20000);
            continue_button.click();


            //ждем окончания установки
            mDevice.wait(Until.findObject(By.res(PLAY_PKG, "launch_button")), 500000);

        }
    }
// просто открывает браузер
    static public void startMainActivityFromHomeScreen(String pkgName) throws InterruptedException {


        // Initialize UiDevice instance
        UiDevice  mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        Thread.sleep(5000);

        // Launch the blueprint app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(pkgName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(pkgName).depth(0)), 15000);


    }

   static public void unlockpatternlock() throws UiObjectNotFoundException, Exception {

       UiDevice  mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.wakeUp();
        mDevice.swipe(248,mDevice.getDisplayHeight()-10,248,10, 40);
    }


}
