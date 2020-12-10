package game.unit.plane.friendly.satellite;

import game.unit.plane.friendly.Friendly;

public class SatelliteLeft extends Satellite {
    public SatelliteLeft(Friendly friendly) {
        super(friendly);
    }

    @Override
    protected int satellitePosition() {
        return -30;
    }
}
