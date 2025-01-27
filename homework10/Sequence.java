package homeworks.homework10;

import java.util.ArrayList;

    public class Sequence {
        public static int[] filter(int[] array, ByCondition condition) {
            ArrayList<Integer> resultList = new ArrayList<>();

            for (int number : array) {
                if (condition.isOk(number)) {
                    resultList.add(number);
                }
            }

            // Преобразуем ArrayList в массив int[]
            return resultList.stream().mapToInt(i -> i).toArray();
        }
    }


