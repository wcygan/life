package io.wcygan.lifecycle;

import io.wcygan.application.Constants;
import io.wcygan.board.Tile;

import java.util.concurrent.atomic.AtomicBoolean;

public class PhaseController extends Thread {

    public final Tile[][] board;
    AtomicBoolean paused;

    public PhaseController(final Tile[][] board, AtomicBoolean paused) {
        this.paused = paused;
        this.board = board;
    }

    @Override
    public void run() {
        while (true) {
            pauseIfNecessary();
            iterate();
        }
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

    private void pauseIfNecessary() {
        if (paused.get()) {
            while (paused.get()) {
                try {
                    sleep(Constants.MILLISECONDS_TO_SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
