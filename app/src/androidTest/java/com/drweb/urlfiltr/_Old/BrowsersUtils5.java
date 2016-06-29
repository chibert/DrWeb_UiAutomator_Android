package com.drweb.urlfiltr._Old;

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
        Thread.sleep(2000);

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



    static void  setCategoryInCloudCheker(String category, boolean isCheck) throws InterruptedException {


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

            Thread.sleep(1500);
            String accessCategory;
            if (isCheck == true)
                accessCategory = "Ограничить доступ";
            else
                accessCategory = "Разрешить доступ";
            UiObject2 Box1 = mDevice.findObject(By.text(accessCategory));
            if (Box1 != null) {
                Box1.click();
                Thread.sleep(1000);
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
    static void testCaseSupportBrowser(String browserPKG) throws InterruptedException {
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


    static void testCategory( String browserPKG) throws InterruptedException {
/*
//проверим по какой категории заблочилось
        Thread.sleep(2000);
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
        BrowsersUtils5.setCategoryInCloudCheker("Нерекомендуемые сайты", false);
        BrowsersUtils5.setCategoryInCloudCheker("Сайты для взрослых", false);
        BrowsersUtils5.setCategoryInCloudCheker("Насилие", false);
        BrowsersUtils5.setCategoryInCloudCheker("Оружие", false);
        BrowsersUtils5.setCategoryInCloudCheker("Азартные игры", false);
        BrowsersUtils5.setCategoryInCloudCheker("Наркотики", false);
        BrowsersUtils5.setCategoryInCloudCheker("Нецензурная лексика", false);
        BrowsersUtils5.setCategoryInCloudCheker("Чаты", false);
        BrowsersUtils5.setCategoryInCloudCheker("Терроризм", false);
        BrowsersUtils5.setCategoryInCloudCheker("Электронная почта", false);
        BrowsersUtils5.setCategoryInCloudCheker("Социальные сети", false);
        BrowsersUtils5.setCategoryInCloudCheker("URL, добавленные по обращению правообладателя", false); // по обращению правообладателя

        Utils.startMainActivityFromHomeScreen(browserPKG);

        /*BrowsersUtils4.openURL(browserPKG, "http://justclick.ru", false);
        BrowsersUtils4.openURL(browserPKG, "http://xvideos.com", false);
        BrowsersUtils4.openURL(browserPKG, "http://twin-towers.net", false);
        BrowsersUtils4.openURL(browserPKG, "http://guns.com", false);
        BrowsersUtils4.openURL(browserPKG, "http://altaigames.com", false);
        BrowsersUtils4.openURL(browserPKG, "http://tweaker.org", false);
        BrowsersUtils4.openURL(browserPKG, "http://udaff.com", false);
        BrowsersUtils4.openURL(browserPKG, "http://chat.ru", false);
        BrowsersUtils4.openURL(browserPKG, "http://www.deadhouse.ru/gallery/terrorism/", false);
        BrowsersUtils4.openURL(browserPKG, "http://e-mail.ru", false);
        BrowsersUtils4.openURL(browserPKG, "http://vk.com", false);
        BrowsersUtils4.openURL(browserPKG, "http://drweb-ru.com", false);
        //BrowsersUtils2.openURL(browserPKG, "", false);
        //BrowsersUtils2.openURL(browserPKG, "", false);
        //BrowsersUtils2.openURL(browserPKG, "", false);
        //BrowsersUtils2.openURL(browserPKG, "", false);*/

        BrowsersUtils5.openURL(browserPKG, "www.yt118.com", true);


        Thread.sleep(5000);
        UiObject2 text2 = mDevice.findObject(By.descContains("Известные источники"));
        assertNotNull(text2);
    }



        //Нерекомендуемые сайты
        static void testCategoryNotRecommended( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Нерекомендуемые сайты", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://justclick.ru", true);
        Thread.sleep(2000);
        UiObject2 text3 = mDevice.findObject(By.descContains("Нерекомендуемые сайты"));
        assertNotNull(text3);
    }

        //Сайты для взрослых
        static void testCategoryAdult( String browserPKG) throws InterruptedException {
            Utils.startMainActivityFromHomeScreen(drWebPkg);
            mDevice.findObject(By.text("URL-фильтр")).click();
            mDevice.waitForWindowUpdate(drWebPkg, 1000);
            BrowsersUtils5.setCategoryInCloudCheker("Нерекомендуемые сайты", false);
            BrowsersUtils5.setCategoryInCloudCheker("Сайты для взрослых", true);

            Utils.startMainActivityFromHomeScreen(browserPKG);
            BrowsersUtils5.openURL(browserPKG, "http://xvideos.com", true);
            Thread.sleep(2000);
            UiObject2 text4 = mDevice.findObject(By.descContains("Сайты для взрослых"));
            assertNotNull(text4);
        }

        //Насилие
        static void testCategoryViolence( String browserPKG) throws InterruptedException {
            Utils.startMainActivityFromHomeScreen(drWebPkg);
            mDevice.findObject(By.text("URL-фильтр")).click();
            mDevice.waitForWindowUpdate(drWebPkg, 1000);
            BrowsersUtils5.setCategoryInCloudCheker("Сайты для взрослых", false);
            BrowsersUtils5.setCategoryInCloudCheker("Насилие", true);

            Utils.startMainActivityFromHomeScreen(browserPKG);
            BrowsersUtils5.openURL(browserPKG, "http://twin-towers.net", true);
            Thread.sleep(2000);
            UiObject2 text5 = mDevice.findObject(By.descContains("Насилие"));
            assertNotNull(text5);
        }

        //Оружие
        static void testCategoryWeapons( String browserPKG) throws InterruptedException {
            Utils.startMainActivityFromHomeScreen(drWebPkg);
            mDevice.findObject(By.text("URL-фильтр")).click();
            mDevice.waitForWindowUpdate(drWebPkg, 1000);
            BrowsersUtils5.setCategoryInCloudCheker("Насилие", false);
            BrowsersUtils5.setCategoryInCloudCheker("Оружие", true);

            Utils.startMainActivityFromHomeScreen(browserPKG);
            BrowsersUtils5.openURL(browserPKG, "http://guns.com", true);
            Thread.sleep(2000);
            UiObject2 text6 = mDevice.findObject(By.descContains("Оружие"));
            assertNotNull(text6);
        }

        //Азартные игры
        static void testCategoryGambling( String browserPKG) throws InterruptedException {
            Utils.startMainActivityFromHomeScreen(drWebPkg);
            mDevice.findObject(By.text("URL-фильтр")).click();
            mDevice.waitForWindowUpdate(drWebPkg, 1000);
            BrowsersUtils5.setCategoryInCloudCheker("Оружие", false);
            BrowsersUtils5.setCategoryInCloudCheker("Азартные игры", true);

            Utils.startMainActivityFromHomeScreen(browserPKG);
            BrowsersUtils5.openURL(browserPKG, "http://altaigames.com", true);
            Thread.sleep(2000);
            UiObject2 text7 = mDevice.findObject(By.descContains("Азартные игры"));
            assertNotNull(text7);
        }

        //Наркотики
        static void testCategoryDrugs( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Азартные игры", false);
        BrowsersUtils5.setCategoryInCloudCheker("Наркотики", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://tweaker.org", true);
        Thread.sleep(2000);
        UiObject2 text8 = mDevice.findObject(By.descContains("Наркотики"));
        assertNotNull(text8);
    }

        //Нецензурная лексика
    static void testCategoryObsceneLanguage( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Наркотики", false);
        BrowsersUtils5.setCategoryInCloudCheker("Нецензурная лексика", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://udaff.com", true);
        Thread.sleep(2000);
        UiObject2 text9 = mDevice.findObject(By.descContains("Нецензурная лексика"));
        assertNotNull(text9);
    }

        //Чаты
    static void testCategoryChats( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Нецензурная лексика", false);
        BrowsersUtils5.setCategoryInCloudCheker("Чаты", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://chat.ru", true);
        Thread.sleep(2000);
        UiObject2 text10 = mDevice.findObject(By.descContains("Чаты"));
        assertNotNull(text10);
    }

        //Терроризм
    static void testCategoryTerrorism( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Чаты", false);
        BrowsersUtils5.setCategoryInCloudCheker("Терроризм", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://www.deadhouse.ru/gallery/terrorism/", true);
        Thread.sleep(2000);
        UiObject2 text11 = mDevice.findObject(By.descContains("Терроризм"));
        assertNotNull(text11);
    }

        //Электронная почта
    static void testCategoryEmail( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Терроризм", false);
        BrowsersUtils5.setCategoryInCloudCheker("Электронная почта", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://e-mail.ru", true);
        Thread.sleep(2000);
        UiObject2 text12 = mDevice.findObject(By.descContains("Электронная почта"));
        assertNotNull(text12);
    }

        //Социальные сети
    static void testCategorySocialNetworks( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Электронная почта", false);
        BrowsersUtils5.setCategoryInCloudCheker("Социальные сети", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://vk.com", true);
        Thread.sleep(2000);
        UiObject2 text13 = mDevice.findObject(By.descContains("Социальные сети"));
        assertNotNull(text13);
    }

        //URL, добавленные по обращению правообладателя
    static void testCategoryPiracy( String browserPKG) throws InterruptedException {
        Utils.startMainActivityFromHomeScreen(drWebPkg);
        mDevice.findObject(By.text("URL-фильтр")).click();
        mDevice.waitForWindowUpdate(drWebPkg, 1000);
        BrowsersUtils5.setCategoryInCloudCheker("Социальные сети", false);
        BrowsersUtils5.setCategoryInCloudCheker("URL, добавленные по обращению правообладателя", true);

        Utils.startMainActivityFromHomeScreen(browserPKG);
        BrowsersUtils5.openURL(browserPKG, "http://drweb-ru.com", true);
        Thread.sleep(2000);
        UiObject2 text14 = mDevice.findObject(By.descContains("правообладателя"));
        assertNotNull(text14);




    }


}
