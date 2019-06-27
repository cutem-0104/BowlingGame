// TestGame.java----------------------------

import junit.framework.*;

public class TestGame extends TestCase {

  private Game g;

  public TestGame(String name) {
    super(name);
  }

  public void setUp() {
    g = new Game();
  }

  public void testOneThrow() {
    g.add(5);
    assertEquals(5, g.score());
  }

  public void testTwoThrowsNoMark() {
    g.add(5);
    g.add(4);
    assertEquals(9, g.score());
  }

  public void testFourThrowsNoMark() {
    g.add(5);
    g.add(4);
    g.add(7);
    g.add(2);
    assertEquals(18, g.score());
    assertEquals(9, g.scoreForFrame(1));
    assertEquals(18, g.scoreForFrame(2));
  }

  public void testSimpleSpare() {
    g.add(3);
    g.add(7);
    g.add(3);
    assertEquals(13, g.scoreForFrame(1));
  }
}
