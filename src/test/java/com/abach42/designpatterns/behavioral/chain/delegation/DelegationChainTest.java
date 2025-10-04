package com.abach42.designpatterns.behavioral.chain.delegation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelegationChainTest {

    @Test
    @DisplayName("chain not handles if emtpy")
    public void testChainNotHandlesIfEmpty() {
        Chain.MemberList list = new Chain.MemberList();
        Handable handlerMock = mock(Handable.class);
        verify(handlerMock, times(0)).handle(list);

        new Chain()
                .add(new SortByAgeHandler())
                .process(list);

        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("chain sorts data")
    public void testChainSortsData() {
        Chain.MemberList list = new Chain.MemberList();
        list.add(new Chain.Member("John", 50));
        list.add(new Chain.Member("Doe", 62));
        list.add(new Chain.Member("Marilyn", 32));

        new Chain()
                .add(new SortByAgeHandler())
                .process(list);

        assertEquals(new Chain.Member("Marilyn", 32), list.getFirst());
    }

    @Test
    @DisplayName("chain filtere data")
    public void testChainFiltersData() {
        Chain.MemberList list = new Chain.MemberList();
        list.add(new Chain.Member("John", 50));
        list.add(new Chain.Member("Doe", 62));
        list.add(new Chain.Member("Marilyn", 32));

        new Chain()
                .add(new FilterHandler(40))
                .process(list);

        assertFalse(list.contains(new Chain.Member("Marilyn", 32)));
    }
}