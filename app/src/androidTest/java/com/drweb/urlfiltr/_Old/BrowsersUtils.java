package com.drweb.urlfiltr._Old;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by a.sviridenko on 20.01.2016.
 */
public class BrowsersUtils {
    //вбивает в в адрес строку

    static UiDevice mDevice;
    //запускаем дрвеб и выставляем нужные галки
    final static String drWebPkg = "com.drweb.pro.market";

    static public void openURL(String pkgName,String url,boolean isNeedBlock) throws InterruptedException {


        //сначала пробуем поискать с ID от хрома
        UiObject2 editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_bar")), 1000);
        if(editText==null)
        {
            //если нет, то от яндекса
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_common_omnibox_edit_text")), 1000);

            if(editText==null)
            {
                //если нет, то от оперы
                editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_field")), 1000);
            }

        }

        editText.click();
        Thread.sleep(2000);

        UiObject2 delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "delete_button")), 1000);
        if(delButton==null)
        {
             delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "bro_common_omnibox_stop_reload_clear_button")), 1000);

        }
        if(delButton!=null) {
            delButton.click();
        }

        editText.setText(url);
        Thread.sleep(5000);

        mDevice.pressEnter();



        Thread.sleep(5000);


        editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_bar")), 1000);
        if(editText==null)
        {
            //если нет, то от яндекса
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_common_omnibox_edit_text")), 1000);

            if(editText==null)
            {
                //если нет, то от оперы
                editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_field")), 1000);
            }

        }
        String strEditUrl = editText.getText();
        if (strEditUrl.startsWith("Dr.Web") || strEditUrl.startsWith("file://")) {
            //если в строке url видим Dr.Web или file:// (т.е сработала блокировка)

            if (!isNeedBlock) {//если мы не ждали блокировки
                {
                    assertTrue(false); //прерываем тест
                }
            }
        }
        else //страница открылась не заблокированная
        {

            if (isNeedBlock) {//если мы  ждали блокировки
                {
                    assertTrue(false); //прерываем тест
                }
            }

        }

    }



    static void  setCategoryInCloudCheker(String category,boolean isCheck) throws InterruptedException {



        UiObject2 checkBox = mDevice.findObject(By.text(category));
        if(checkBox==null)
        {
            //не нашли категории, не влезла в экран, отскролим вверх
            mDevice.swipe(248,mDevice.getDisplayHeight()-10,248,10, 40);
            Thread.sleep(1000);
            checkBox = mDevice.findObject(By.text(category));
            if(checkBox==null)
            {
                //опять не нашли отскролим вниз
                mDevice.swipe(248,50,248,mDevice.getDisplayHeight()-50, 40);
                Thread.sleep(1000);
            }

        }
        if(checkBox.isChecked()!=isCheck) //если его состояние не совпадает с тем что нам надо
        {
            checkBox.click();
        }


    }

//тест проверяет, что браузер в принцыпе поддерживает блокировку
    static void testCaseSupportBrowser(String browserPKG) throws InterruptedException {
         mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());


        Utils.startMainActivityFromHomeScreen(drWebPkg);


        mDevice.findObject(By.text("Cloud Checker")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils.setCategoryInCloudCheker("Сайты для взрослых", true);
        BrowsersUtils.setCategoryInCloudCheker("Социальные сети", true);


        //запускаем яндекс
        Utils.startMainActivityFromHomeScreen(browserPKG);


        BrowsersUtils.openURL(browserPKG, "www.ya.ru", false); //не должно блокироваться
        BrowsersUtils.openURL(browserPKG, "www.vk.com", true);  //должно блокироваться



    }


    static void testCategory( String browserPKG) throws InterruptedException {

//проверим по какой категории заблочилось
        Thread.sleep(1000);
        UiObject2 text = mDevice.findObject(By.descContains("Сайты для взрослых"));
        assertNotNull(text);




//убираем галку Сайты для взрослых

        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("Cloud Checker")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils.setCategoryInCloudCheker("Сайты для взрослых", false);

        //запускаем яндекс
        Utils.startMainActivityFromHomeScreen(browserPKG);

//запускаем контакт
        BrowsersUtils.openURL(browserPKG, "www.vk.com", true);  //должно блокироваться
//должен заблочится по категории Социальные сети
        text = mDevice.findObject(By.descContains("Социальные сети"));
        assertNotNull(text);

    }


}
