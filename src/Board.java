public class Board {
    // board est un tableau d'instances de Cell = instancier Cell 64 fois
    private Cell[] board = new Cell[64];


    /**
     * Board constructor : Generates the board
     * generates an array of objects Cell;
     */
    public Board(){
        System.out.println("Initialisation de la board");
        for(int i=0; i<this.getBoardLength();i++){
            Cell cell = new Cell();
            board[i] = cell;
            cell.setCellEvent();
            //System.out.println("Cell's event : " + cell.getCellEvent());
        }
        Cell lastCell = new Cell();
        board[this.getBoardLength()-1]= lastCell;
        lastCell.setBossEvent();
        //System.out.println("Cell's event : " + lastCell.getCellEvent());
    }

    /**
     * getBoardLength()
     * @return board.length : board's number of cells
     */
    public int getBoardLength(){
        return board.length;
    }

    public Cell getCell(int position){
        return board[position];
    }
}
