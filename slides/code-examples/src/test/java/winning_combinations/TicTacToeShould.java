package winning_combinations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeShould {
    @Test
    public void noWinnerToBeginWith() throws Exception {
        String game =
                "---" +
                "---" +
                "---";

        char player = 'x';
        boolean hasAWinner = ticTacToe.playerWon(game, player);
        assertThat(hasAWinner).isFalse();
    }

    @Test
    public void draw() throws Exception {
        String game =
                "xox" +
                "oox" +
                "xxo";

        char player = 'x';
        boolean hasAWinner = ticTacToe.playerWon(game, player);
        assertThat(hasAWinner).isFalse();
    }

    @Test
    public void winOnFirstRowXXX() throws Exception {
        //given
        String game =
                "xxx" +
                "o-o" +
                "-o-";

        char player = 'x';
        boolean hasWinner = ticTacToe.playerWon(game, player);
        assertThat(hasWinner).isTrue();
    }


    @Test
    public void winOnAnyRow() throws Exception {
        //given
        List<String> gamesWinningOnRow = Arrays.asList(
                "ooo" +
                "x-x" +
                "-x-",

                "x-x" +
                "ooo" +
                "-x-",

                "x-x" +
                "-x-" +
                "ooo"
        );

        char player = 'o';
        assertAllGamesHaveWinner(gamesWinningOnRow, player);

    }

    @Test
    public void winOnAnyColumn() throws Exception {
        //given
        List<String> gamesWinningOnColumn = Arrays.asList(
                "xoo" +
                "x-o" +
                "xo-",

                "oxo" +
                "-x-" +
                "-xo",

                "x-x" +
                "-ox" +
                "oox"
        );

        char player = 'x';
        assertAllGamesHaveWinner(gamesWinningOnColumn, player);

    }

    @Test
    public void winOnAnyDiagonal() throws Exception {
        //given
        List<String> gamesWinningOnDiagonal = Arrays.asList(
                "xoo" +
                "oxo" +
                "xox",

                "x-x" +
                "-xo" +
                "xoo"
        );

        char player = 'x';
        assertAllGamesHaveWinner(gamesWinningOnDiagonal, player);

    }


    private void assertAllGamesHaveWinner(List<String> gamesWinningOnRow, char player) {
        gamesWinningOnRow.forEach(
                game -> assertThat(ticTacToe.playerWon(game, player)).isTrue()
        );
    }

    private TicTacToe ticTacToe = new TicTacToe();


}
