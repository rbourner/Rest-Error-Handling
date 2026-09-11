package com.acme;

/**
 * This class model a business entity used in the process instances.
 * 
 */
public class User {

    private String key;
    private String name;

    public String getKey() {
        return this.key;
    }

    public void setKey(String k) {
        this.key = k;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return "User{" +
                "key=" + this.key +
                ", name='" + this.name +
                '}';
    }
}
