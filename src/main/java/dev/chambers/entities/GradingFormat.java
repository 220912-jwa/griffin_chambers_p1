package dev.chambers.entities;

public enum GradingFormat {LETTER_GRADE(1),NUMBER_GRADE(2),PASS_FAIL(3),PERFORMANCE_RATING(4);
    private int gradingFormat;
    private GradingFormat(int gradingFormat){this.gradingFormat=gradingFormat;}

    public int getGradingFormat(){
        return gradingFormat;
    }
}
