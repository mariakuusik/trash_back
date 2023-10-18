package com.cats.greatCats.validation;

import lombok.Getter;

@Getter
public enum Error {

    UPC_UNAVAILABLE("Product with this UPC code already exists", 111);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
