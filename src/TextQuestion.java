public class TextQuestion extends Question{
  private String question;
  private String answer;
  private int weight;
 
  public TextQuestion(String question, String answer, int weight) {
    this.question = question.replaceAll("\t", "  ");
    this.answer = answer.replaceAll("\t", "  ");
    this.weight = weight;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public int getWeight() {
    return weight;
  }

  public String[] getChoices() {
    return null;
  }

  public String toString() {
    return String.format("1\t%d\t%s\t%s\t", weight, question, answer);
  }
}