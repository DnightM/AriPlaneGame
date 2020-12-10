package game.scenario;

import game.Point;

public class ScenarioStraight extends Scenario {
	private final int startX;

	public ScenarioStraight(long delay, int startX) {
		super(delay);
		this.startX = startX;
	}

	@Override
	protected Point[] getPoses() {
		return new Point[]{
				new Point(startX, -100),
				new Point(startX, 1100),
		};
	}

}
