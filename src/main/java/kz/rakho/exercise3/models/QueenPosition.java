package kz.rakho.exercise3.models;

public class QueenPosition {
    private int row;
    private int col;

    public QueenPosition() {
    }

    public QueenPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}