public class TextQuestion extends Question{
  private String question;
  private String answer;
  private int weight;
 
  public TextQuestion(String question, String answer, int weight) {
    this.question = question;
    this.answer = answer;
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
}