package com.Pattern;

public class SingletonLazy<x> {
            private static SingletonLazy singleton;
            Object x = new Object();
            private SingletonLazy() {}
            synchronized  public static SingletonLazy getInstance() {
                if (singleton == null) {
                    singleton = new SingletonLazy();
                }
                return singleton;
            }
        }