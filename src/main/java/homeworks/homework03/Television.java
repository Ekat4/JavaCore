package homeworks.homework03;

public class Television {
        public static void main(String[] args) {
        }

        private Integer volt; // Напряжение
        private String color; // Цвет
        private String mark;  // Марка

        // Конструктор по умолчанию
        public Television () {
            this.color = "Black";
            this.mark = "LG";
            this.volt = 240;
        }

        // Конструктор с параметрами
        public Television(String color, String mark, Integer volt ) {
            this.color = color;
            this.mark = mark;
            this.volt = volt;

        }

        // Методы-сеттеры
        public void setColor(String color) {
            this.color = color;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public void setVolt(Integer volt) {
            this.volt = volt;
        }

        @Override
        public String toString() {
            return "Television{" +
                    "volt=" + volt +
                    ", color='" + color + '\'' +
                    ", mark='" + mark + '\'' +
                    '}';
        }
    }