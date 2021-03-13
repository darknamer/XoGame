package com.darknamer.xo_game;

public class XoGame {
    private String[][] _table;
    private String _turnOfPlayer = "X";
    private final String _xPlayer = "X";
    private final String _yPlayer = "Y";
    private boolean _hasWinner = false;
    private String _nameOfWinner = "-";
    private int _count = 0;

    public XoGame() {
        reset();
    }

    /**
     * -- Solution in winner --
     * Solution in Cross
     * [0,0], [1,1], [2,2]
     * [2,2], [1,1], [0,0]
     * Solution in X
     * [0,0], [1,0], [2,0]
     * [0,1], [1,1], [2,1]
     * [0,2], [1,2], [2,2]
     * Solution in Y
     * [0,0], [0,1], [0,2]
     * [1,0], [1,1], [1,2]
     * [2,0], [2,1], [2,2]
     */
    private void checkHasWinner() {
        int[][] solutions = new int[][]{
                {0, 0, 1, 1, 2, 2},
                {2, 2, 1, 1, 0, 2},
                {0, 0, 1, 0, 2, 0},
                {0, 1, 1, 1, 2, 1},
                {0, 2, 1, 2, 2, 2},
                {0, 0, 0, 1, 0, 2},
                {1, 0, 1, 1, 1, 2},
                {2, 0, 2, 1, 2, 2}
        };
        for (int[] solution : solutions) {
            String nameX = _table[solution[0]][solution[1]];
            String nameY = _table[solution[2]][solution[3]];
            String nameZ = _table[solution[4]][solution[5]];
            if (nameX.equals(nameY) && nameY.equals(nameZ) && (nameX.equals(_xPlayer) || nameX.equals(_yPlayer))) {
                _hasWinner = true;
                _nameOfWinner = nameX;
                _turnOfPlayer = "-";
            }
        }
    }

    public void setPosition(int x, int y) {
        if (_hasWinner) {
            return;
        }
        if (x > 2 || y > 2 || _count > 9)
            return;
        if (_turnOfPlayer.equals(this._xPlayer)) {
            setXPosition(x, y);
            _count++;
            _turnOfPlayer = _yPlayer;
        } else if (_turnOfPlayer.equals(_yPlayer)) {
            setYPosition(x, y);
            _count++;
            _turnOfPlayer = _xPlayer;
        }
        checkHasWinner();
    }

    private void setYPosition(int x, int y) {
        this._table[x][y] = _yPlayer;
    }

    private void setXPosition(int x, int y) {
        this._table[x][y] = _xPlayer;
    }

    public String[][] getTable() {
        return _table;
    }

    public String getTurnOfPlayer() {
        return _turnOfPlayer;
    }

    public boolean isGameOver() {
        return _hasWinner;
    }

    public String getWinner() {
        if (isXWinner()) {
            return _xPlayer;
        } else if (isYWinner()) {
            return _yPlayer;
        } else {
            return "-";
        }
    }

    private boolean isXWinner() {
        return _nameOfWinner.equals(_xPlayer);
    }

    private boolean isYWinner() {
        return _nameOfWinner.equals(_yPlayer);
    }

    public void reset() {
        _table = new String[][]{
                {"-", "-", "-"},
                {"-", "-", "-"},
                {"-", "-", "-"}
        };
        _turnOfPlayer = _xPlayer;
        _hasWinner = false;
        _nameOfWinner = "-";
        _count = 0;
    }
}
