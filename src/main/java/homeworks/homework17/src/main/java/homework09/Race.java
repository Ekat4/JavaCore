package homework09;



import java.util.ArrayList;
import java.util.List;

public class Race {
    private String name; // Название гонки
    private List<Car> participants; // Участники гонки

    public Race(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Car car) {
        participants.add(car);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Race: " + name + "\nParticipants:\n");
        for (Car car : participants) {
            result.append(car.toString()).append("\n");
        }
        return result.toString();
    }
}
