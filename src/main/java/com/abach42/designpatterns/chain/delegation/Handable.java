package com.abach42.designpatterns.chain.delegation;

public interface Handable {
    public Chain.MemberList handle(Chain.MemberList memberList);
}
