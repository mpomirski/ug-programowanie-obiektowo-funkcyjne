import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GradeList {
    private final ArrayList<Float> grades;
    public GradeList() {
        this.grades = new ArrayList<>();
    }
    public void addGrade(float grade) throws IllegalArgumentException{
        float minGrade = 2.0f;
        float maxGrade = 5.0f;
        if (grade >= minGrade && grade <= maxGrade) {
            this.grades.add(grade);
        } else {
            throw new IllegalArgumentException("Ocena musi być z zakresu " + minGrade + " - " + maxGrade);
        }
    }
    public float getAvg() throws NoSuchElementException{
        if (this.grades.isEmpty()){
            throw new NoSuchElementException("Nie ma żadnych elementów.");
        }
        return this.grades.stream().reduce(0f, Float::sum) / this.grades.size();
    }
    public float getMax() throws NoSuchElementException {
        Optional<Float> maxValue = this.grades.stream().max(Float::compareTo);
        if (maxValue.isPresent()) {
            return maxValue.get();
        }
        throw new NoSuchElementException("Nie znaleziono maksymalnej wartości.");
    }
    public float getMin() throws NoSuchElementException {
        Optional<Float> minValue = this.grades.stream().min(Float::compareTo);
        if (minValue.isPresent()){
            return minValue.get();
        }
        throw new NoSuchElementException("Nie znaleziono minimalnej wartości.");
    }
}
