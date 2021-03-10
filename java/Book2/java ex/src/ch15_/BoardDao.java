package ch15_;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    List<Board> getBoardList(){
        List<Board> pList = new ArrayList<Board>();
        pList.add(new Board("제목1","내용1"));
        pList.add(new Board("제목2","내용2"));
        pList.add(new Board("제목3","내용3"));

        return pList;
    }
}
