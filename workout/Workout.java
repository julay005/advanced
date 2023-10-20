package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int ExerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int ExerciseCount) {
        this.type = type;
        this.ExerciseCount = ExerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {

        if (this.exercises.size() < this.ExerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(exercise -> exercise.getName().equals(name) &&
                exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {

        return this.exercises.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle)).findFirst().orElse(null);

    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        int calories = 0;

        if (!this.exercises.isEmpty()) {
            for (Exercise ex : exercises) {
                if (ex.getBurnedCalories() > calories) {
                    calories = ex.getBurnedCalories();
                }
            }
            for (Exercise ex : exercises) {
                if (ex.getBurnedCalories() == calories) {
                    exercise = ex;
                    break;
                }
            }

        }
        return exercise;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }
    public String getStatistics (){
        StringBuilder sbd = new StringBuilder();

        sbd.append(String.format("Workout type: %s",this.type));

        this.exercises.forEach(exercise -> sbd.append(System.lineSeparator()).append(exercise));



        return sbd.toString();

    }

}

