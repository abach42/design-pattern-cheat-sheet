package com.abach42.designpatterns.unit.structural.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.abach42.designpatterns.structural.proxy.Proxy;
import com.abach42.designpatterns.structural.proxy.RealSubject;
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
