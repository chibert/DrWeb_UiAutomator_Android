/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drweb.urlfiltr.BoatMiniBrowsersTests;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class BrowserTest_03_Adult {
  private static final String BROWSER_PKG = Browser.browser;


    @Before
    public void install() throws Exception {
        //разблокируем экран
        //Utils.unlockpatternlock();
        //Utils.installByGooglePlay(BROWSER_PKG);

    }

    @Test
    public void runTest() throws Exception {
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.testCaseSupportBrowser(BROWSER_PKG);
        com.drweb.urlfiltr.BrowsersUtilsPackage.BrowsersUtils5.testCategoryAdult(BROWSER_PKG);


    }


}
