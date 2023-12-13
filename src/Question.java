/**
 * Abstract class represents an individual question with the teacher submitted answer, question, and weight
 */
public abstract class Question {
  abstract public String getQuestion();
  abstract public String getAnswer();
  abstract public int getWeight();
  abstract public String[] getChoices();
  abstract public String toString();
}