import java.io.File;

public class Main {
    public static void main(String[] args) {
    /*
    Home1
    1. Начать новую игру
    2. Продолжить игру
    Игра уагадай число от 1 до 100.
    Комп подсказывает больше или меньше.
    У юзера есть 10 попыток.
    Юзер или отгадывает или выходит из игры.
    После каждой попытке:
    1.Попробовать ещё раз
    2.Выйти из игры?

    **Реализовать сохранение в одной из прошлых игр(например BlackJack)
    (Сериализация в помощь)
    */
        File dir = new File("./src/streams/saved_game");
        dir.mkdir();

        Game game = new Game();
        game.go();
    }
}
