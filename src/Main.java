import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //с помощью битовых операций
    public static int bit(int a, int b) {
        int result = 0;
        //пока b больше 0
        while (b > 0) {
            // если b нечетное(последний бит b равен 1), добавляем a к результату
            if ((b & 1) == 1)  result += a;
            //умножаем a на 2 (сдвигаем влево)
            a <<= 1; //сдвиг a влево на 1 бит
            //делим b на 2 (сдвигаем вправо)
            b >>= 1; //сдвиг b вправо на 1 бит
        }
        return result;
    }

    //с помощью массива
    public static int array(int a, int b) {
        int result = 0; //инициализация переменной для хранения результата
        //массив для значений
        int[] mass = new int[b]; //создаем массив размером b
        //заполняем значением a массив
        Arrays.fill(mass, a);
        for (int i = 0; i < b; i++) { // проход по массиву
            result += mass[i]; //складываем значения
        }
        return result;
    }

    //с помощью рекурсии
    public static int recursion(int a, int b) {
        // базовый случай
        if (b == 0) return 0; //если b равно 0

        if (b < 0) return recursion(a, -b); //если b отрицательное, то умножаем a на -b

        //рекурсивный случай
        return a + recursion(a, b - 1); //умножаем a на b, рекурсивно уменьшая b
    }

    //с помощью циклов
    public static int loop(int a, int b) {
        int result = 0; //инициализация переменной для хранения результата
        for (int i = 0; i < b; i++) { // цикл, который добавляет к 'a', 'b' единиц
            result += a; //добавляем a к результату
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число a: ");
        int a = in.nextInt();
        System.out.println("Введите число b: ");
        int b = in.nextInt();

        System.out.println("Выберите способ умножения:");

        System.out.println("Умножение с помощью битовых операций: 1");
        System.out.println("Умножение с помощью массива: 2");
        System.out.println("Рекурсивное умножение: 3");
        System.out.println("Умножение с использованием циклов: 4");

        int userSelect = in.nextInt();
        int result;
        switch (userSelect) {
            case 1:
                result = bit(a, b);
                break;
            case 2:
                result = array(a, b);
                break;
            case 3:
                result = recursion(a, b);
                break;
            case 4:
                result = loop(a, b);
                break;
            default:
                System.out.println("Некорректный ввод");
                return;
        }

        System.out.println("Результат: " + result);
    }
}