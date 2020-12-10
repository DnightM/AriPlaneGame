package game.unit.plane.friendly.satellite;

import game.Point;
import game.unit.plane.friendly.Friendly;

public class SatelliteRight extends Satellite {
    public SatelliteRight(Friendly friendly) {
        super(friendly);
    }

    @Override
    protected int satellitePosition() {
        return 30;
    }
}
