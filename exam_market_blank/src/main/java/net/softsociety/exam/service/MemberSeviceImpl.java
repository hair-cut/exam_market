package net.softsociety.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

@Service
public class MemberSeviceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordencoder; 

	@Override
	public int MemberJoin(Member member) {
		
		String pw = passwordencoder.encode(member.getMemberpw());
		
		member.setMemberpw(pw);
		
		int i = dao.MemberJoin(member);
		
		return i;
	}

	@Override
	public int login(Member member) {
		
		String pw = passwordencoder.encode(member.getMemberpw());
		
		member.setMemberpw(pw);
		
		int i = dao.login(member);
		
		return i;
	}
}
