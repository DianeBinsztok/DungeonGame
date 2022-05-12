public class Board {
    // board est un tableau d'instances de Cell = instancier Cell 64 fois
    private Cell[] board = new Cell[64];

    /**
     * getBoardLength()
     * @return board.length : board's number of cells
     */
    public int getBoardLength(){
        return board.length;
    }
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
            System.out.println("Cell's event : " + cell.getCellEvent());
        }
    }

    public Cell getCell(int position){
        return board[position];
    }
}
