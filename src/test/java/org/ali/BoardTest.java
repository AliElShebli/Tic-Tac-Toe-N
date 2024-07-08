package org.ali;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPlayerMakesValidMove() {
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlayerMakesInvalidMove() {
        board.clear();
        board.place(0, 0, 'X');
        // Attempt to place 'O' in the same spot, which should not change the marker
        board.place(0, 0, 'O');
        // The cell should still be occupied by 'X', hence not empty
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testBoardIsFull() {
        board.clear();
        // Fill the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }
}

