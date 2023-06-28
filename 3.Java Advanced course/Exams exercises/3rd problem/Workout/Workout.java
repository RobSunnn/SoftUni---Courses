package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public int getExerciseCount() {
        return getExercises().size();
    }

    public String getType() {
        return type;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() + 1 <= this.exerciseCount) {
            boolean isNotInList = true;
            for (Exercise exercise1 : this.exercises) {
                if (exercise1.getName().equals(exercise.getName())) {
                    isNotInList = false;
                    break;
                }
            }
            if (isNotInList) {
                this.exercises.add(exercise);
            }
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        int burnedCalories = -1;
        if (this.exercises.isEmpty()) {
            return null;
        } else {
            for (Exercise exercise1 : this.exercises) {
                if (exercise1.getBurnedCalories() > burnedCalories) {
                    burnedCalories = exercise1.getBurnedCalories();
                    exercise = exercise1;

                }
            }
        }

        return exercise;
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(getType()).append(System.lineSeparator());
        for (Exercise exercise : this.exercises) {
            sb.append("Exercise: ").append(exercise.getName()).append(", ")
                    .append(exercise.getMuscle()).append(", ").append(exercise.getBurnedCalories()).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
