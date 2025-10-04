package com.abach42.designpatterns.structural.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProxyTest {

    @Test
    void testProxyDelegatesToRealSubject() {
        RealSubject real = new RealSubject();
        Proxy proxy = new Proxy(real);

        String result = proxy.getData();

        assertEquals("real Values", result);
        assertTrue(proxy.wasAccessed());
    }
}
