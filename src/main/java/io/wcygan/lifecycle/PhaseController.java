package io.wcygan.lifecycle;

import io.wcygan.board.Constants;
import io.wcygan.board.Tile;

public class PhaseController extends Thread {

    public final Tile[][] board;

    public PhaseController(final Tile[][] board) {
        this.board = board;

    }

    @Override
    public void run() {
        for (int iter = 0; iter < Constants.MAXIMUM_ITERATIONS; iter++) {
            try {
                iterate();
                sleep(Constants.MILLISECONDS_TO_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);
    }

    private void iterate() {
        for (Tile[] row : board) {
            for (Tile t : row) {
                t.checkNeighbors(board);
            }
        }

        for (Tile[] row : board) {
            for (Tile t : row) {
                t.tryToRevive();
            }
        }
    }
}
