package Ivan.com;

public class MyArrayDataException extends Exception {
    protected int i;
    protected int j;

    MyArrayDataException(int i,int j) { //конструктор класса MyArrayDataException который на вход получает 2 индекса
        this.i = i; //того места где произошла ошибка преобразования строки в целое число 
        this.j = j;
    }
}
