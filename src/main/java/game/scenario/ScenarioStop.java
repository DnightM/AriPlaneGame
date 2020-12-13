package game.scenario;

import game.Point;

public class ScenarioStop extends Scenario {
    private final int startX;
    private final int endY;

    /**
     * 단순히 위에서 아래로 내려와서 endY에서 멈추는 시나리오
     * @param delay 딜레이
     * @param startX 시작 x좌표
     * @param endY 멈출 y좌표
     */
    public ScenarioStop(long delay, int startX, int endY) {
        super(delay, true);
        this.startX = startX;
        this.endY = endY;
    }

    @Override
    protected Point[] getPs() {
        return new Point[]{
                new Point(startX, -100),
                new Point(startX, endY),
        };
    }

}
