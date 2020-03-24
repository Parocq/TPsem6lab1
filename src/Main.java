
import java.util.Scanner;

public class Main {

    static final int NUM = 1000000000;

    public static void main(String[] args) throws InterruptedException {

        Extra extra = new Extra();

        int min, max , size;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Размер массива:");
        size = scanner.nextInt();
        System.out.println("Минимальный элемент:");
        min = scanner.nextInt();
        System.out.println("Максилмаьный элемент:");
        max = scanner.nextInt();


        if (min > max || min <= -NUM || min >= NUM || max >= NUM
                || size > NUM ) {
            System.out.println("Неверные входные значения");
        } else {
            //Заполнение массива
            int[] array = new int[size];
            for (int i = 0;i<size;i++){
                max = max-min;
                array[i] = (int)(Math.random()* ++(max)+min);
            }

            Answers a1 = new Answers();
            Answers a2 = new Answers();
            Answers a3 = new Answers();


            long startTime = System.nanoTime();

//            Runnable r1 = ()->{
                //Первый алгоритм (пузырек) Подсчет времени
                int[] array1 = new int[array.length];
                copyArray(array, array1);
                a1.setBubbleTime(extra.bubbleSortForTime(array1));

                //Подсчет операций
                int[] array2 = new int[array.length];
                copyArray(array, array2);
                long[] bubbleResults = extra.bubbleSortForCount(array2);

                 a1.setCountCompressions(bubbleResults[0]);
                 a1.setCountCalls(bubbleResults[1]);
                 a1.setCountOverwrites(bubbleResults[2]);
                 a1.setBubbleTimeExtra(bubbleResults[3]);
//            };
//            r1.run();


//            Runnable r2 = () -> {
                //Вторая сортировка (выбором) Подсчет времени
                int[] array3 = new int[array.length];
                copyArray(array, array3);
                a2.setBubbleTime(extra.bubbleSortForTime(array3));

                //Подсчет операций
                int[] array4 = new int[array.length];
                copyArray(array, array4);
                long[] chooseResults = extra.chooseSortForCount(array4);

                a2.setCountCompressions(chooseResults[0]);
                a2.setCountCalls(chooseResults[1]);
                a2.setCountOverwrites(chooseResults[2]);
                a2.setBubbleTimeExtra(chooseResults[3]);
//            };
//            r2.run();

//            Runnable r3 = ()-> {
                // Третья сортировка (шатл сорт)
                int[] array5 = new int[array.length];
                copyArray(array, array5);
                a3.setBubbleTime(extra.bubbleSortForTime(array5));
                //Подсчет
                int[] array6 = new int[array.length];
                copyArray(array, array6);
                long[] shuttleResults = extra.shuttleSortForCount(array6);

                a3.setCountCompressions(shuttleResults[0]);
                a3.setCountCalls(shuttleResults[1]);
                a3.setCountOverwrites(shuttleResults[2]);
                a3.setBubbleTimeExtra(shuttleResults[3]);
//            };
//            r3.run();

            long summaryTime = System.nanoTime() - startTime;


            System.out.println("пузырек:");
            showStats(a1.getCountCompressions(),a1.getCountCalls(),
                    a1.getCountOverwrites(), a1.getBubbleTime(),
                    a1.getBubbleTimeExtra());

            System.out.println("выбором:");
            showStats(a2.getCountCompressions(),a2.getCountCalls(),
                    a2.getCountOverwrites(), a2.getBubbleTime(),
                    a2.getBubbleTimeExtra());

            System.out.println("шатл:");
            showStats(a3.getCountCompressions(),a3.getCountCalls(),
                    a3.getCountOverwrites(), a3.getBubbleTime(),
                    a3.getBubbleTimeExtra());

            System.out.println("\nСуммарное время выполнения(/10^6): " + summaryTime/1000000);


            System.out.println("Визуализация...");
            int visualizeWitch;
            visualizeWitch = scanner.nextInt();
            while (visualizeWitch!=0){
                chooseVis(array);
                visualizeWitch = scanner.nextInt();
            }

        }
    }


    public static void chooseVis (int[] array) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Bubble       2.Choose sort      3.Shuttle");
        int iq = scanner.nextInt();
        int[] hundred1;
        int[] hundred2;
        int[] hundred3;


        if (array.length<100){
            hundred1 = new int[array.length];
            hundred2 = new int[array.length];
            hundred3 = new int[array.length];
            hundred1 = copyHundred(array, hundred1, array.length);
            hundred2 = copyHundred(array, hundred2, array.length);
            hundred3 = copyHundred(array, hundred3, array.length);
        } else {
            hundred1 = new int[100];
            hundred2 = new int[100];
            hundred3 = new int[100];
            hundred1 = copyHundred(array, hundred1, 100);
            hundred2 = copyHundred(array, hundred2, 100);
            hundred3 = copyHundred(array, hundred3, 100);
        }

        switch (iq){
            case 1:

                int temp;

                boolean sorted = false;
                while (!sorted) {
                    sorted = true;
                    for (int i = 0; i <  hundred1.length-1; i++) {

                        if (hundred1[i] > hundred1[i + 1]) {
                            temp = hundred1[i];
                            hundred1[i] = hundred1[i + 1];
                            hundred1[i + 1] = temp;

                            sorted = false;
                        }

                    }
                    printArray(hundred1);
                    Thread.sleep(10);
                }
                break;
            case 2:

                for (int left = 0; left < hundred2.length - 1; left++) {
                    int least = left;
                    for (int j = left + 1; j < hundred2.length; j++) {
                        if (hundred2[j] < hundred2[least]) {
                            least = j;
                        }
                    }
                    int tmp = hundred2[left];
                    hundred2[left] = hundred2[least];
                    hundred2[least] = tmp;

                    printArray(hundred2);
                    Thread.sleep(500);
                }
                break;
            case 3:
                for (int i = 1; i < hundred3.length; i++) {
                    if (hundred3[i] < hundred3[i - 1]) {

                        int tmp = hundred3[i];
                        hundred3[i] = hundred3[i-1];
                        hundred3[i-1] = tmp;

                        for (int z = i - 1; (z - 1) >= 0; z--) {
                            if (hundred3[z] < hundred3[z - 1]) {

                                tmp = hundred3[z];
                                hundred3[z] = hundred3[z-1];
                                hundred3[z-1] = tmp;

                            } else {
                                break;
                            }
                        }
                    }
                    printArray(hundred3);
                    Thread.sleep(500);
                }
                break;
        }
    }


    public static void printArray (int[] array) throws InterruptedException {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public  static  int[] copyArray(int[] array, int[] newArray){
        for (int i = 0; i<array.length;i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static void showStats (long comp,long call,long write,long time , long timeExtra){
        System.out.println("Число сравнений элементов: "+comp);
        System.out.println("Число обращений к элементам: "+call);
        System.out.println("Число (пере)записи элементов: "+write);
        System.out.println("Время выполнения программы в наносекундах: "+time);
        System.out.println("Время выполнения программы в наносекундах(читывая подсчет): "+ timeExtra);
        System.out.println();
    }


    public static int[] copyHundred (int[] arrayFull, int[] arrayHun, int qq){
        for (int i = 0; i<qq;i++){
            arrayHun[i] = arrayFull[i];
        }
        return  arrayHun;
    }
}
