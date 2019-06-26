// Game.java------------------------

public class Game {

  public int score() {
    return itsScore;
  }

  public void add(int pins) {
    itsScore += pins;
  }

  public int scoreForFrame(int frame) {
    return 0;
  }

  private int itsScore = 0;

}
