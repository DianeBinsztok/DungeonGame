public class Board {
    // board est un tableau d'instances de Cell = instancier Cell 64 fois
    private Cell[] board = new Cell[64];

    /**
     * Generate the board
     * generate array of objects Cell;
     */
    public void setBoard(){
        for(int i=0; i<64;i++){
            Cell room = new Cell();
            board[i] = room;
            String event = room.cellEvent;
            System.out.println("room event : " + event);
        }
    }
}
