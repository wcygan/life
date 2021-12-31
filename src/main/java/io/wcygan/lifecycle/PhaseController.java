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
            iterate();
        }
        System.exit(0);
    }

    /**
     * Run one simulation of Life
     */
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

        try {
            sleep(Constants.MILLISECONDS_TO_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
