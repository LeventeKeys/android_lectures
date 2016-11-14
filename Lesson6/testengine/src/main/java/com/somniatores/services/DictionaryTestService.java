package com.somniatores.services;

import com.somniatores.models.DictionaryTest;

/**
 * Created by locisvv on 14.11.2016.
 */

public class DictionaryTestService implements TestService<DictionaryTest, String>{

    @Override
    public boolean checkAnswer(DictionaryTest test, String expectedAnswer) {
        return test.getAnswer().equals(expectedAnswer);
    }

}
