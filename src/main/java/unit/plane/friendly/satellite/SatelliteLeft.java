package unit.plane.friendly.satellite;

import unit.plane.friendly.Friendly;

public class SatelliteLeft extends Satellite {
    public SatelliteLeft(int x, int y, Friendly friendly) {
        super(x, y, friendly);
    }

    @Override
    protected int satellitePosition() {
        return -30;
    }
}
