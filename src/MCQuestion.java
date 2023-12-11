public class MCQuestion extends Question {
  private String question;
  private String[] answers;
  private int ans_choice;
  private int weight;
  
  public MCQuestion(String question, String[] answers, int ans_choice, int weight) {
    this.question = question.replaceAll("\t", "  ");
    this.answers = answers;
    this.ans_choice = ans_choice;
    this.weight = weight;
  }

  public String getQuestion() {
    return question;
  }

  public String[] getChoices() {
    return answers;
  }

  public String getAnswer() {
    return answers[ans_choice];
  }

  public int getWeight() {
    return weight;
  }

  public String toString() {
    String choices = String.join("\t", answers);
    return String.format("0\t%d\t%s\t%d\t%s\t%d\t", weight, question, answers.length, choices, ans_choice);
  }


}