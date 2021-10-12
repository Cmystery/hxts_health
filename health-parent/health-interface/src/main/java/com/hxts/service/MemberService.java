package com.hxts.service;

import com.hxts.pojo.Member;

public interface MemberService {
    Member findByTelephone(String telephone);

    void add(Member member);
}
