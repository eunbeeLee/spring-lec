package com.practice.spring.batchprocessing;

import javax.batch.api.chunk.ItemProcessor;


public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Object processItem(Object o) throws Exception {
        return null;
    }
}
