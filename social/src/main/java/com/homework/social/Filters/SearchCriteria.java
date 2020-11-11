package com.homework.social.Filters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private boolean orPredicate;

    public SearchCriteria(String key, String operation, Object value){
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.orPredicate = false;
    }
}
