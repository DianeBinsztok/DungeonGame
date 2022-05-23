package exceptions;

import game.Board;
import game.Cell;

public class PlayerOutOfBoardException extends Exception{
    public PlayerOutOfBoardException(Cell currentCell, Board board){
        System.out.println(" -----  You arrived in the last chamber  -----");
        currentCell = board.getCell(board.getBoardLength()-1);
    }
}
