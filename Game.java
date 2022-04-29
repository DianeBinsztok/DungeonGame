public class Game {

    private Cell[] board = new Cell[64];

    public void setLootAndMonsters(){
        double lootIndex = ((Math.random()*(64-1))+1);
        double monsterIndex = ((Math.random()*(64-1))+1);
    }

    /**
     * Generate the board
     * generate array of objects Cell;
     */
    public void setBoard(){

        for(int i=0; i<64;i++){
             Cell x = new Cell();
             board[i] = x;
        }
    }
    /**
     * Throw dice
     * @return random int between 1 & 6
     */
    public int diceRoll(){
       return (int) ((Math.random()*(6-1))+1);
    }




}

