package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

	int form_write(Board board);

	ArrayList<Board> select();

	int read(int boardnum);


}
