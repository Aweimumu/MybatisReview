package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Member;
import org.example.domain.MemberSearchCondition;

import java.util.List;

public interface MemberDAO {
    public List<Member> searchMember(MemberSearchCondition memberSearchCondition);
    public int insertMember(Member member);
    public int updateMember(Member member);
    public List<Member> searchMemberByNick(@Param("keyWord") String keyWord);
    public Member  queryMemberById(int id);
}
