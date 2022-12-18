package com.group6.customer_ordering.enums;

public enum Gender {

        M("M"),
        F("F");

        private String code;
        Gender(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code = code;
        }

}
