package com.somniatores.lesson6;

import com.somniatores.lesson6.services.DictionaryTestStorage;
import com.somniatores.services.DictionaryTestService;
import com.somniatores.services.TestRepository;

/**
 * Created by locisvv on 15.11.2016.
 */

public class Application {
    public static TestRepository dictionaryTestStorage = new DictionaryTestStorage();

    public static DictionaryTestService testService = new DictionaryTestService();
}
