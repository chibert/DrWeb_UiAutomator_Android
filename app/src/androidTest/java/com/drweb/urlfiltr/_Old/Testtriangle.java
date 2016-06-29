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

package com.drweb.urlfiltr._Old;
import org.junit.Before;
import org.junit.Test;

public class Testtriangle {

    @Before
    public void setUp() {
        Rtriangle triangle = RtriangleProvider.getRtriangle();
    }

    @Test
    public void test() {

        /*int

            x1 = triangle.getApexX1(),
            x2 = triangle.getApexX2(),
            x3 = triangle.getApexX3(),

            y1 = triangle.getApexY1(),
            y2 = triangle.getApexY2(),
            y3 = triangle.getApexY3();

        int
            sqside1 = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),
            sqside2 = (x3-x2)*(x3-x2)+(y3-y2)*(y3-y2),
            sqside3 = (x3-x1)*(x3-x1)+(y3-y1)*(y3-y1);

        if ( (x1-x3)*(y2-y3) == (x2-x3)*(y1-y3) )
            assertTrue(false); //Это не треугольник, все вершины лежат на одной прямой.

        else if ( (x1==x2 && y1==y2) || (x2==x3 && y2==y3) || (x1==x3 && y1==y3) )
            assertTrue(false); //Это не треугольник, какие-то две вершины лежат в одной точке.

        else if ((sqside1 != sqside2 + sqside3) && (sqside2 != sqside1 + sqside3) && (sqside3 != sqside1 + sqside2))
            assertTrue(false); //По теореме Пифагора треугольник не является прямоугольным.

        else
            assertTrue(true);*/

    }
}