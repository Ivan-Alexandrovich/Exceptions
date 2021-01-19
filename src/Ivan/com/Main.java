package Ivan.com;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {
        /* 3 В методе main() вызвать полученный метод, обработать возможные исключения
        MySizeArrayException и MyArrayDataException, и вывести результат расчета.*/

        String[][] array = {{"1", "2", "3", "4"}, {"3", "4", "5", "4"}, {"5", "6", "7", "8"}, {"9", "5 ", "10", "11"}};
        try {
            try {
            firstTask(array); //пробуй выполнить метод firstTask, если он выбросит MyArraySizeException
                              //то иди в блок  catch (MyArraySizeException e), где е - просто название переменной класса
                              //MyArraySizeException, и внутри этого блока выводи сообщение о ошибке размера
            int result = secondTask(array); //пробуй присвоить в целую переменную значение метода secondTask
                //если же он выбросит ошибку MyArrayDataException то иди в блок (MyArrayDataException e) и поскольку
                //е - объект класса MyArrayDataException с двумя полями i и j то выведи их на экран (доступ к ним есть
                //т.к. они protected значит можно получить к ним доступ из того же пакета Ivan.com
            System.out.println("Sum of array: " + result); //если ошибка выбросилась в secondTask(array) то компилятор
                //даже не перейдет на эту строку, если же ошибки нет то выводит сумму элементов массива
        } catch (MyArraySizeException e) {
            System.out.println("Your array is not 4*4"); //отлавливает ошибку MyArraySizeException
        }
        } catch (MyArrayDataException e) { //отлавливает ошибку MyArrayDataException и т.к. е-объект класса то мы обращаемся
            System.out.println("Not number in element: " + e.i + "x" + e.j); // к полям е и выводим в каком элементе
            //двумерного массива не число
        }
    }
    public static void firstTask(String[][] array) throws MyArraySizeException {
        /* 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером
        4х4, при подаче массива другого размера необходимо бросить исключение*/
        if (array.length != 4) {
            throw new MyArraySizeException("Array size error"); //если выбросится ошибка то компилятор даже дальше не
            //пойдет по строкам
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Array size error");
            }
            break; //это нужно чтобы если компилятор в какой-то строке уже нашел не 4 столбца то он дальше не шел бы по
            //строкам и не выбрасывал исключение несколько раз
        }
    }

    public static int secondTask(String[][] array) throws MyArrayDataException {
        /*2 Далее метод должен пройтись по всем элементам массива, преобразовать в int, и
        просуммировать. Если в каком-то элементе массива преобразование не удалось
        (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
        исключение MyArrayDataException, с детализацией в какой именно ячейке лежат
        неверные данные.*/
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]); //пробуй прибавить в сум элемент массива преобразованный в
                    //целое число из строки, если там окажутся буквы или другие символы (не числа)
                    } catch (NumberFormatException e) { //то лови NumberFormatException - стандартное исключение
                    //из класса Exception, которое получается в результате парсинга не числа
                    throw new MyArrayDataException(i, j); //в случае отлова NumberFormatException выброси исключение
                    //MyArrayDataException - при чем, это же класс значит в этой строчке мы конструктору на вход в
                    //параметры подаем индексы где произошел сбой парсинга
                }
            }
        }
        return sum; //возвращаем сумму в итоге, если нигде не словили исключений
    }
}




