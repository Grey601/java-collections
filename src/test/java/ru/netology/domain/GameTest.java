package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void firstPlayerHasMoreStrength() {
        Game game = new Game();

        Player player1 = new Player(1, "Григорий", 70);
        Player player2 = new Player(2, "Елисей", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Григорий", "Елисей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerHasMoreStrength() {
        Game game = new Game();

        Player player1 = new Player(1, "Григорий", 70);
        Player player2 = new Player(2, "Елисей", 80);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Григорий", "Елисей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bothPlayersHaveTheSameStrength() {
        Game game = new Game();

        Player player1 = new Player(1, "Григорий", 70);
        Player player2 = new Player(2, "Елисей", 70);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Григорий", "Елисей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void wrongFirstPlayerName() {
        Game game = new Game();

        Player player1 = new Player(1, "Михаил", 70);
        Player player2 = new Player(2, "Елисей", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Григорий", "Елисей"));
    }

    @Test
    public void wrongSecondPlayerName() {
        Game game = new Game();

        Player player1 = new Player(1, "Григорий", 70);
        Player player2 = new Player(2, "Василий", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Григорий", "Елисей"));
    }

    @Test
    public void wrongBothPlayerNames() {
        Game game = new Game();

        Player player1 = new Player(1, "Пётр", 70);
        Player player2 = new Player(2, "Василий", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Григорий", "Елисей"));
    }

//    @Test
//    public void firstPlayerHasNoName() {
//        Game game = new Game();
//
//        Player player1 = new Player(1, null, 70);
//        Player player2 = new Player(2, "Василий", 50);
//
//        game.register(player1);
//        game.register(player2);
//
//        Assertions.assertThrows(NullPointerException.class, () -> game.round(null, "Василий"));
//    }
}
