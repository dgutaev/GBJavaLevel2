package Lesson1;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
прыгать (методы просто выводят информацию о действии в консоль).

2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие
действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

4*. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
public class Main {
    public static void main(String[] args) {
        Participants[] sportThings = {
                new Human("Биба", 2, 2),
                new Human("Боба", 1, 3),
                new Cat("Компот", 4, 5),
                new Cat("Коржик", 2, 1),
                new Cat("Карамелька", 3, 14),
                new Robot("Федор", 1, 11),
                new Robot("Т800", 8, 13)
        };

        Events[] obstacles = {
                new Track(2),
                new Track(5),
                new Track(6),
                new Wall(2),
                new Wall(3)
        };

        for (Participants sportThing : sportThings) {
            System.out.println("К препятствию подходит " + sportThing);
            boolean win = true;
            for (Events obstacle : obstacles) {
                System.out.println(sportThing + " пытается преодолеть " + obstacle);
                if (obstacle.running(sportThing.getMaxLength()) || obstacle.jumping(sportThing.getMaxHeight())) {
                    System.out.println("Преодолевает");
                } else {
                    System.out.println("Не преодолевает");
                    win = false;
                    break;
                }
            }

            if (win) {
                System.out.println(sportThing + " пришел к финишу");
            } else {
                System.out.println(sportThing + " сошел с дистанции");
            }
            System.out.println();
        }
    }
}
