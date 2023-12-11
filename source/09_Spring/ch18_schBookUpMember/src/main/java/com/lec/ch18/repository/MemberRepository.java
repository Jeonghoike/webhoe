package com.lec.ch18.repository;
import org.apache.ibatis.annotations.Mapper;

import com.lec.ch18.vo.Member;
@Mapper
public interface MemberRepository {
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);
}
