public class Extra {

    public long bubbleSortForTime(int[] array) {

        boolean sorted = false;
        long time = System.nanoTime();

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    sorted = false;
                }
            }
        }
        long timeRun = System.nanoTime() - time;

        return timeRun;
    }

    public long[] bubbleSortForCount(int[] array) {

        boolean sorted = false;
        long countCompressions = 0, countCalls = 0, countOverwrites = 0;
        long time = System.nanoTime();

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                countCompressions++;
                countCalls += 2;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    countCalls += 2;
                    countOverwrites += 2;

                    sorted = false;
                }
            }
        }
        long timeRun = System.nanoTime() - time;

        long[] results = new long[4];
        results[0] = countCompressions;
        results[1] = countCalls;
        results[2] = countOverwrites;
        results[3] = timeRun;

        return results;
    }


    public long chooseSortForTime(int[] array) {

        long time = System.nanoTime();

        for (int left = 0; left < array.length - 1; left++) {
            int least = left;
            for (int j = left + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            int tmp = array[left];
            array[left] = array[least];
            array[least] = tmp;
        }
        long timeRun = System.nanoTime() - time;
        return timeRun;
    }

    public long[] chooseSortForCount(int[] array) {

        long countCompressions = 0, countCalls = 0, countOverwrites = 0;
        long time = System.nanoTime();

        for (int left = 0; left < array.length - 1; left++) {
            int least = left;
            for (int j = left + 1; j < array.length; j++) {
                countCompressions++;
                countCalls += 2;
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            int tmp = array[left];
            array[left] = array[least];
            array[least] = tmp;
            countCalls += 2;
            countOverwrites += 2;
        }

        long timeRun = System.nanoTime() - time;

        long[] results = new long[4];
        results[0] = countCompressions;
        results[1] = countCalls;
        results[2] = countOverwrites;
        results[3] = timeRun;

        return results;
    }

    public long shuttleSortForTime(int[] array) {

        long time = System.nanoTime();

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {

                int tmp = array[i];
                array[i] = array[i-1];
                array[i-1] = tmp;

                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {

                        tmp = array[z];
                        array[z] = array[z-1];
                        array[z-1] = tmp;

                    } else {
                        break;
                    }
                }
            }
        }


        long timeRun = System.nanoTime() - time;
        return timeRun;
    }


    public long[] shuttleSortForCount(int[] array) {

        long countCompressions = 0, countCalls = 0, countOverwrites = 0;
        long time = System.nanoTime();

        for (int i = 1; i < array.length; i++) {
            countCompressions++;
            countCalls+=2;
            if (array[i] < array[i - 1]) {
                int tmp = array[i];
                array[i] = array[i-1];
                array[i-1] = tmp;

                countCalls +=2;
                countOverwrites += 2;

                for (int z = i - 1; (z - 1) >= 0; z--) {
                    countCompressions++;
                    countCalls+=2;
                    if (array[z] < array[z - 1]) {
                        tmp = array[z];
                        array[z] = array[z-1];
                        array[z-1] = tmp;

                        countCalls +=2;
                        countOverwrites += 2;
                    } else {
                        break;
                    }
                }
            }
        }

        long timeRun = System.nanoTime() - time;

        long[] results = new long[4];
        results[0] = countCompressions;
        results[1] = countCalls;
        results[2] = countOverwrites;
        results[3] = timeRun;

        return results;
    }
}