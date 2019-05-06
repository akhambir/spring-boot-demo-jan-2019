package com.akhambir.controllers;

import java.net.URI;

public final class ControllersUtil {

    private ControllersUtil() {}

    static URI getUri(String uri, Long id) {
        return URI.create(String.format("/%s/%s", uri, id));
    }
}
