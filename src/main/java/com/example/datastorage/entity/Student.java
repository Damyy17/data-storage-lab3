package com.example.datastorage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private static final AtomicLong count = new AtomicLong(0);
    private long id = count.incrementAndGet();
    private String name;
    private String surname;
    private int age;




}
