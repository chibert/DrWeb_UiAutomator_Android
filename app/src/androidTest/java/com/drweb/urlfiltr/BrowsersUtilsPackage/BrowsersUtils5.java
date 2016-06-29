package com.drweb.urlfiltr.BrowsersUtilsPackage;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BrowsersUtils5 {
    //вбивает в адрес строку

    static UiDevice mDevice;
    //запускаем дрвеб и выставляем нужные галки
    final static String drWebPkg = "com.drweb.pro.market";

    static public void openURL(String pkgName,String url,boolean isNeedBlock) throws InterruptedException {


        //сначала пробуем поискать с ID от хрома
        UiObject2 editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_bar")), 1000);

        if(editText==null)
            //если нет, то от яндекса
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_common_omnibox_edit_text")), 1000);


        if(editText==null)
            //если нет, то от оперы
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_field")), 1000);

        if(editText==null)
            //если нет, то от яндекса поновее...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_omnibox_titlebar_title")), 1000);

        if(editText==null)
            //если нет, то от яндекса поновее...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_sentry_bar_input_edittext")), 1000);

        if(editText==null)
            //если нет, то от яндекса еще новее...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_sentry_bar_fake_text")), 1000);

        if(editText==null)
            //если нет, то от стандартного браузера...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url")), 1000);

        if(editText==null)
            //если нет, то лиса...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_bar_entry")), 1000);

        if(editText==null)
            //если нет, то оперы мини...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_field")), 1000);

        if(editText==null)
            //если нет, то Дельфина...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "title_design")), 1000);

        if(editText==null)
            //если нет, то BoatMini...
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "address_bar")), 1000);






        editText.click();
        Thread.sleep(1500);

        UiObject2 delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "delete_button")), 1000);
        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "bro_common_omnibox_stop_reload_clear_button")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "right_state_button")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "bro_omnibox_titlebar_button_reload")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "bro_sentry_bar_input_button")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "clear")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "edit_cancel")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "cancel")), 1000);

        if(delButton==null)
            delButton =   mDevice.wait(Until.findObject(By.res(pkgName, "address_bar")), 1000);



        if(delButton!=null)
            delButton.click();

        else
            Thread.sleep(1000);

        editText.setText(url);
        Thread.sleep(5000);

        mDevice.pressEnter();



        Thread.sleep(5000);


        editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_bar")), 1000);
        //editText = mDevice.wait(Until.findObject(By.res(pkgName, "bro_sentry_bar_input_edittext")), 1000);
        if(editText==null)

            //если нет, то от яндекса
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "bro_common_omnibox_edit_text")), 1000);

        if(editText==null)

            //если нет, то от оперы
            editText =  mDevice.wait(Until.findObject(By.res(pkgName, "url_field")), 1000);

        //если нет, то от яндекса поновее...
        if(editText==null)
            editText = mDevice.wait(Until.findObject(By.res(pkgName, "bro_sentry_bar_input_edittext")), 1000);

        //если нет, то от стандартного браузера...
        if(editText==null)
            editText = mDevice.wait(Until.findObject(By.res(pkgName, "url")), 1000);

        //если нет, то от лисы...
        if(editText==null)
            editText = mDevice.wait(Until.findObject(By.res(pkgName, "url_bar_translating_edge")), 1000);

        //если нет, то от лисы...
        if(editText==null)
            editText = mDevice.wait(Until.findObject(By.res(pkgName, "url_field")), 1000);

        //если нет, то от лисы...
        if(editText==null)
            editText = mDevice.wait(Until.findObject(By.res(pkgName, "search_input")), 1000);

        //если нет, то от BoatMini...
        if(editText==null)
            editText = mDevice.wait(Until.findObject(By.res(pkgName, "address_bar")), 1000);



        String strEditUrl = editText.getText();
        Thread.sleep(1000);
        if (strEditUrl.startsWith("Dr.Web") || strEditUrl.startsWith("file://") || strEditUrl.startsWith("content://")) {
            //если в строке url видим Dr.Web или file: или // Cloud(т.е сработала блокировка)

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



    public static void  setCategoryInCloudCheker(String category,boolean isCheck) throws InterruptedException {


        UiObject2 Box = mDevice.findObject(By.text(category));
        if (Box == null) {
            //не нашли категории, не влезла в экран, отскролим вниз
            mDevice.swipe(248, mDevice.getDisplayHeight() - 10, 248, 10, 40);
            Thread.sleep(1000);
            Box = mDevice.findObject(By.text(category));
            if (Box == null) {
                //опять не нашли отскролим вверх
                mDevice.swipe(248, 300, 248, mDevice.getDisplayHeight() - 100, 40);
                Thread.sleep(1000);
                Box = mDevice.findObject(By.text(category));

                //if (Box == null)
                //   assertTrue(false);
            }
        }

        if (Box != null)
            Box.click();

        //Thread.sleep(1500);
        String accessCategory;
        if (isCheck == true)
            accessCategory = "Ограничить доступ";
        else
            accessCategory = "Разрешить доступ";
        //UiObject2 Box1 = mDevice.findObject(By.text(accessCategory));
        UiObject2 Box1 =mDevice.wait(Until.findObject(By.text(accessCategory)), 2000);
        if (Box1 != null) {
            //Thread.sleep(500);
            //Box1.click();
            //Thread.sleep(500);
            mDevice.pressBack();
        }
        Box.click();
        Box1 =mDevice.wait(Until.findObject(By.text(accessCategory)), 2000);
        if (Box1 != null) {
            //Thread.sleep(500);
            Box1.click();
            Thread.sleep(500);
        }

        else if (Box1 == null)
            assertTrue(false);
    }



    static void  onCloudCheker(boolean isCheck) throws InterruptedException {



        UiObject2 onCheckBox = mDevice.findObject(By.clazz("android.widget.CheckBox"));
        /*if(onCheckBox==null)
        {
            //не нашли категории, не влезла в экран, отскролим вверх
            mDevice.swipe(248,mDevice.getDisplayHeight()-10,248,10, 40);
            Thread.sleep(1000);
            onCheckBox = mDevice.findObject(By.clazz("android.widget.CheckBox"));
            if(onCheckBox==null)
            {
                //опять не нашли отскролим вниз
                mDevice.swipe(248, 50, 248, mDevice.getDisplayHeight() - 50, 40);
                Thread.sleep(1000);
            }
        }*/
        if(onCheckBox.isChecked()!=isCheck) //если его состояние не совпадает с тем что нам надо
        {
            onCheckBox.click();
        }


    }



    //тест проверяет, что браузер в принципе поддерживает блокировку
    public static void testCaseSupportBrowser(String browserPKG) throws InterruptedException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

/*
        Utils.startMainActivityFromHomeScreen(drWebPkg);


        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils2.setCategoryInCloudCheker("Сайты для взрослых", true);
        BrowsersUtils2.setCategoryInCloudCheker("Социальные сети", true);


        //запускаем яндекс
        Utils.startMainActivityFromHomeScreen(browserPKG);


        BrowsersUtils2.openURL(browserPKG, "www.ya.ru", false); //не должно блокироваться
        BrowsersUtils2.openURL(browserPKG, "www.vk.com", true);  //должно блокироваться



    } */


    public static void testCategory(String browserPKG) throws InterruptedException {
/*
//проверим по какой категории заблочилось
        Thread.sleep(1500);
        UiObject2 text = mDevice.findObject(By.descContains("Сайты для взрослых"));
        assertNotNull(text);




//убираем галку Сайты для взрослых

        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils2.setCategoryInCloudCheker("Сайты для взрослых", false);

        //запускаем яндекс
        Utils.startMainActivityFromHomeScreen(browserPKG);

//запускаем контакт
        BrowsersUtils2.openURL(browserPKG, "www.vk.com", true);  //должно блокироваться
//должен заблочится по категории Социальные сети
        text = mDevice.findObject(By.descContains("Социальные сети"));
        assertNotNull(text);
        */


        Utils.startMainActivityFromHomeScreen(drWebPkg);
        //Thread.sleep(5000);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        //BrowsersUtils4.onCloudCheker(true);
        //mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Нерекомендуемые сайты", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Сайты для взрослых", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Насилие", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Оружие", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Азартные игры", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Наркотики", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Нецензурная лексика", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Чаты", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Терроризм", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Электронная почта", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Социальные сети", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("URL, добавленные по обращению правообладателя", false); // по обращению правообладателя

        Utils.startMainActivityFromHomeScreen(browserPKG);

        /*com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://justclick.ru", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://xvideos.com", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://twin-towers.net", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://guns.com", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://altaigames.com", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://tweaker.org", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://udaff.com", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://chat.ru", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.deadhouse.ru/gallery/terrorism/", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://e-mail.ru", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://vk.com", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://drweb-ru.com", false);*/

        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "www.yt118.com", true);


        Thread.sleep(5000);
        UiObject2 text2 = mDevice.findObject(By.descContains("Известные источники"));
        assertNotNull(text2);
    }



    //Нерекомендуемые сайты
    public static void testCategoryNotRecommended(String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Нерекомендуемые сайты", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://justclick.ru", true);
        Thread.sleep(1500);
        UiObject2 text3 = mDevice.findObject(By.descContains("Нерекомендуемые сайты"));
        assertNotNull(text3);
    }

    //Сайты для взрослых
    public static void testCategoryAdult(String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Нерекомендуемые сайты", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Сайты для взрослых", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://xvideos.com", true);
        Thread.sleep(1500);
        UiObject2 text4 = mDevice.findObject(By.descContains("Сайты для взрослых"));
        assertNotNull(text4);
    }

    //Насилие
    public static void testCategoryViolence( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Сайты для взрослых", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Насилие", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://twin-towers.net", true);
        Thread.sleep(1500);
        UiObject2 text5 = mDevice.findObject(By.descContains("Насилие"));
        assertNotNull(text5);
    }

    //Оружие
    public static void testCategoryWeapons( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Насилие", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Оружие", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://guns.com", true);
        Thread.sleep(1500);
        UiObject2 text6 = mDevice.findObject(By.descContains("Оружие"));
        assertNotNull(text6);
    }

    //Азартные игры
    public static void testCategoryGambling( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Оружие", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Азартные игры", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://altaigames.com", true);
        Thread.sleep(1500);
        UiObject2 text7 = mDevice.findObject(By.descContains("Азартные игры"));
        assertNotNull(text7);
    }

    //Наркотики
    public static void testCategoryDrugs( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Азартные игры", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Наркотики", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://tweaker.org", true);
        Thread.sleep(1500);
        UiObject2 text8 = mDevice.findObject(By.descContains("Наркотики"));
        assertNotNull(text8);
    }

    //Нецензурная лексика
    public static void testCategoryObsceneLanguage( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Наркотики", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Нецензурная лексика", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://udaff.com", true);
        Thread.sleep(1500);
        UiObject2 text9 = mDevice.findObject(By.descContains("Нецензурная лексика"));
        assertNotNull(text9);
    }

    //Чаты
    public static void testCategoryChats( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Нецензурная лексика", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Чаты", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://chat.ru", true);
        Thread.sleep(1500);
        UiObject2 text10 = mDevice.findObject(By.descContains("Чаты"));
        assertNotNull(text10);
    }

    //Терроризм
    public static void testCategoryTerrorism( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Чаты", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Терроризм", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://videosyiah.com", true);
        Thread.sleep(1500);
        UiObject2 text11 = mDevice.findObject(By.descContains("Терроризм"));
        assertNotNull(text11);
    }

    //Электронная почта
    public static void testCategoryEmail( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Терроризм", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Электронная почта", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://e-mail.ru", true);
        Thread.sleep(1500);
        UiObject2 text12 = mDevice.findObject(By.descContains("Электронная почта"));
        assertNotNull(text12);
    }

    //Социальные сети
    public static void testCategorySocialNetworks( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Электронная почта", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Социальные сети", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://vk.com", true);
        Thread.sleep(1500);
        UiObject2 text13 = mDevice.findObject(By.descContains("Социальные сети"));
        assertNotNull(text13);
    }

    //URL, добавленные по обращению правообладателя
    public static void testCategoryPiracy( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("Социальные сети", false);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.setCategoryInCloudCheker("URL, добавленные по обращению правообладателя", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://drweb-ru.com", true);
        Thread.sleep(1500);
        UiObject2 text14 = mDevice.findObject(By.descContains("правообладателя"));
        assertNotNull(text14);

    }

    public static void forBigStatistic( String browserPKG) throws InterruptedException {

        Utils.startMainActivityFromHomeScreen(browserPKG);
            for (int i = 0; i < 500; i++) {
                System.out.println(i);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://justclick.ru", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://xvideos.com", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://twin-towers.net", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://guns.com", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://altaigames.com", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://tweaker.org", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://udaff.com", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://chat.ru", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.deadhouse.ru/gallery/terrorism/", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://e-mail.ru", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://vk.com", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://drweb-ru.com", false);
            //Thread.sleep(500);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://ya.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://mail.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://ag.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://lenta.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://google.com", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.avito.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://alfabank.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.drweb.com", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.virustotal.com", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://developer.android.com/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://russian.wunderground.com", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://cheaptrip-spb.livejournal.com/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://concertinfo.ru/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://store.steampowered.com/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.gog.com", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.gismeteo.ru", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://togetho.ru/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://uberdeal.ru/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://groupb.ru/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://www.sp-studio.de/", false);
            com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.openURL(browserPKG, "http://http://4pda.ru/", false);

        }

    }


}
