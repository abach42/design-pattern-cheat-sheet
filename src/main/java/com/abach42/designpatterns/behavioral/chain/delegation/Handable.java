package com.abach42.designpatterns.behavioral.chain.delegation;

public interface Handable {

    Chain.MemberList handle(Chain.MemberList memberList);
}
