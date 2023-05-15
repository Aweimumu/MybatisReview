package org.example.dao;

import junit.framework.TestCase;
import org.example.domain.Member;
import org.example.domain.MemberSearchCondition;
import org.example.utils.MybatisUtil;

import java.util.List;

public class MemberDAOTest extends TestCase {

    public void testSearchMember() {
        MemberSearchCondition memberSearchCondition = new MemberSearchCondition();
//        memberSearchCondition.setCity("cx");
        memberSearchCondition.setMinAge(18);
        MemberDAO mapper = MybatisUtil.getMapper(MemberDAO.class);
        List<Member> members = mapper.searchMember(memberSearchCondition);
        System.out.println(members);
    }

    public void testInsertMember() {
        Member member = new Member(4, "awei23", "F", 13, "sh");
        MemberDAO mapper = MybatisUtil.getMapper(MemberDAO.class);
        int i = mapper.insertMember(member);
        System.out.println(i);
    }

    public void testUpdateMember() {
        Member member = new Member(4, "awei33", "M", 115, "bj");
        MemberDAO mapper = MybatisUtil.getMapper(MemberDAO.class);
        int i = mapper.updateMember(member);
        System.out.println(i);

    }

    public void testSearchMemberByNick() {
        MemberDAO mapper = MybatisUtil.getMapper(MemberDAO.class);
        List<Member> w = mapper.searchMemberByNick("w");
        System.out.println(w);
    }
}