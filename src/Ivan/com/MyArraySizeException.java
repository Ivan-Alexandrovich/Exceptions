package Ivan.com;

public class MyArraySizeException extends Exception{ //все классы исключений являются наследниками класса Exception
    public MyArraySizeException(String description) { //объявляем конструктор который на вход принимает строку, которая
        super(description);  //выбросится в случае исключения
    }
}
