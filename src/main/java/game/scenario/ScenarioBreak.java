package game.scenario;

import game.Point;

public class ScenarioBreak extends Scenario {
	private final int startX;
	private final int endY;
	private final boolean isLeft;

	/**
	 * 단순히 위에서 아래로 내려와서 endY에서 직각으로 꺽어 화면 밖으로 나가는 시나리오
	 * @param delay
	 * @param startX
	 * @param endY
	 * @param isLeft
	 */
	public ScenarioBreak(long delay, int startX, int endY, boolean isLeft) {
		super(delay);
		this.startX = startX;
		this.endY = endY;
		this.isLeft = isLeft;
	}

	@Override
	protected Point[] getPoses() {
		return new Point[]{
				new Point(startX, -100),
				new Point(startX, endY),
				new Point(isLeft ? -100 : 1100, endY),
		};
	}

}
