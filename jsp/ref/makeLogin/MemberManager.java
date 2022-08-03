package org.login.data;

import java.util.Vector;

import javax.servlet.ServletContext;

import org.login.bean.Member;

public class MemberManager {
	public static Vector<Member> getMemberList(ServletContext application){
		Vector<Member> memberList =
				(Vector<Member>)application.getAttribute("memberList");
		
		if(memberList == null){
			memberList = new Vector<Member>();
			application.setAttribute("memberList", memberList);
		}
		return memberList;
	}
	public static boolean addMember(ServletContext application, Member member){
		Vector<Member> memberList = getMemberList(application);
		boolean flag = false;
		if(findMember(application, member.getU_id())==null){
			memberList.add(member);
			flag = true;
		}
		return flag;
	}
	public static Member findMember(ServletContext application, String memberId){
		Vector<Member> memberList = getMemberList(application);
		int idx = memberList.indexOf(new Member(memberId));
		Member member = null;
		if(idx != -1){
			member = memberList.get(idx);
		}
		return member;
	}
	public static boolean deleteMember(ServletContext application, String memberId){
		Vector<Member> memberList = getMemberList(application);
		return memberList.remove(new Member(memberId));
	}
	public static boolean updateMember(ServletContext application, Member member){
		Vector<Member> memberList = getMemberList(application);
		int idx = memberList.indexOf(member);
		boolean flag = true;
		if(idx != -1){
			memberList.set(idx, member);
		}else{
			flag = false;
		}
		return flag;
	}
}
