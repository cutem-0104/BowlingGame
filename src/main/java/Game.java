// Game.java------------------------

public class Game {

  public int score() {
    return scoreForFrame(getCurrentFrame() - 1);
  }

  public int getCurrentFrame() {
    return itsCurrentFrame;
  }

  public void add(int pins) {
    itsThrows[itsCurrentThrow++] = pins;
    itsScore += pins;
    adjustCurrentFrame(pins);
  }

  private void adjustCurrentFrame(int pins) {
    if (firstThrowInFrame) {
      if (pins == 10) { // ストライク
        itsCurrentFrame++;
      } else {
        firstThrowInFrame = false;
      }
    } else {
      firstThrowInFrame = true;
      itsCurrentFrame++;
    }
    itsCurrentFrame = Math.min(11, itsCurrentFrame);
  }

  public int scoreForFrame(int theFrame) {
    ball = 0;
    int score = 0;

    for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
      firstThrow = itsThrows[ball];
      if (firstThrow == 10) {
        ball++;
        score += 10 + itsThrows[ball] + itsThrows[ball + 1];
      } else {
        score += handleSecondThrow();
      }
    }
    return score;
  }

  private int handleSecondThrow() {
    int score = 0;
    secondThrow = itsThrows[ball + 1];

    int frameScore = firstThrow + secondThrow;
    // スペアの得点計算には次のフレームの第１投が必要
    if (frameScore == 10) {
      ball += 2;
      score += frameScore + itsThrows[ball];
    } else {
      ball += 2;
      score += frameScore;
    }
    return score;
  }

  private int ball;
  private int firstThrow;
  private int secondThrow;

  private int itsScore = 0;
  private int[] itsThrows = new int[21];
  private int itsCurrentThrow = 0;
  private int itsCurrentFrame = 1;
  private boolean firstThrowInFrame = true;

}
