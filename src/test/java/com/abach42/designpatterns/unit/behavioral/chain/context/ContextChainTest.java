package com.abach42.designpatterns.unit.behavioral.chain.context;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.chain.context.AbstractHandler;
import com.abach42.designpatterns.behavioral.chain.context.FilterHandler;
import com.abach42.designpatterns.behavioral.chain.context.SortByAgeHandler;

public class ContextChainTest {
    @Test
    @DisplayName("chain not handles if emtpy")
    public void testChainNotHandlesIfEmpty() {
        AbstractHandler.MemberList list = new AbstractHandler.MemberList();
        AbstractHandler handlerMock = mock(AbstractHandler.class);
        verify(handlerMock, times(0)).handle();
        
        AbstractHandler subject = AbstractHandler.initializeChain(handlerMock);
            
        subject.handle();
        assertTrue(list.isEmpty());
    }
    
    @Test
    @DisplayName("chain sorts data")
    public void testChainSortsData() {
        AbstractHandler.MemberList list = new AbstractHandler.MemberList();
        list.add(new AbstractHandler.Member("Doe", 62));
        list.add(new AbstractHandler.Member("Marilyn", 32));
        list.add(new AbstractHandler.Member("John", 50));
    
        AbstractHandler subject = AbstractHandler.initializeChain(
            new SortByAgeHandler(list)
        );
    
        subject.handle();
        assertEquals(new AbstractHandler.Member("Marilyn", 32), list.getFirst());
    }
    
    @Test
    @DisplayName("chain filtere data")
    public void testChainFiltersData() {
        AbstractHandler.MemberList list = new AbstractHandler.MemberList();
        list.add(new AbstractHandler.Member("Doe", 62));
        list.add(new AbstractHandler.Member("John", 50));
        list.add(new AbstractHandler.Member("Marilyn", 32));
    
        AbstractHandler subject = AbstractHandler.initializeChain(
            new FilterHandler(list, 40)
        );
    
        subject.handle();
    
        assertFalse(list.contains(new AbstractHandler.Member("Marilyn", 32)));
    }
}