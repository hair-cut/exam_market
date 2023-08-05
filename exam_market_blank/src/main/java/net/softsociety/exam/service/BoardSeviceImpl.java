package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;


@Transactional
@Service
public class BoardSeviceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public int form_write(Board board) {
		
		int i = dao.form_write(board);
		
		return i;
	}

	@Override
	public ArrayList<Board> select() {
		
		ArrayList<Board> select = dao.select();
		
		return select;
	}

	@Override
	public int read(int boardnum) {
		
		int i = dao.read(boardnum);
		
		return i;
	}


}
