package com.somniatores.lesson6.services;

import com.somniatores.models.DictionaryTest;
import com.somniatores.services.TestRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by locisvv on 08.11.2016.
 */

public class DictionaryTestStorage implements TestRepository {
    public static List<DictionaryTest> TEST_LIST = Arrays.asList(
        new DictionaryTest("школа",  "iskola", Arrays.asList("egyetemi", "óvoda", "ház")),
        new DictionaryTest("шарф",   "sál", Arrays.asList("kesztyű", "kalap", "szemüveg")),
        new DictionaryTest("собака", "kutya", Arrays.asList("macska", "kismadár", "róka")),
        new DictionaryTest("машина", "autó", Arrays.asList("kerékpár", "sík", "motorkerékpár")),
        new DictionaryTest("сестра", "lánytestvér", Arrays.asList("testvér", "unokatestvér", "barátnő"))
    );

    @Override
    public List<DictionaryTest> getAll() {
        List<DictionaryTest> result = new ArrayList<>();
        for (DictionaryTest test : TEST_LIST) {
            List<String> answers = new ArrayList<>(test.getPossibleAnswers());
            answers.add(test.getAnswer());
            result.add(new DictionaryTest(test.getTranslationWord(), test.getAnswer(), answers));
        }
        return result;
    }
}
