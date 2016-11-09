package com.somniatores.lesson6.view.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by locisvv on 08.11.2016.
 */

public class TestStorage {
    public static List<Test> TEST_LIST = Arrays.asList(
        new Test("школа",  "iskola", Arrays.asList("egyetemi", "óvoda", "ház")),
        new Test("шарф",   "sál", Arrays.asList("kesztyű", "kalap", "szemüveg")),
        new Test("собака", "kutya", Arrays.asList("macska", "kismadár", "róka")),
        new Test("машина", "autó", Arrays.asList("kerékpár", "sík", "motorkerékpár")),
        new Test("сестра", "lánytestvér", Arrays.asList("testvér", "unokatestvér", "barátnő"))
    );
}
