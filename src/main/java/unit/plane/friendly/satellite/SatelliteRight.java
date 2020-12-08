package unit.plane.friendly.satellite;

import unit.plane.friendly.Friendly;

public class SatelliteRight extends Satellite {
    public SatelliteRight(int x, int y, Friendly friendly) {
        super(x, y, friendly);
    }

    @Override
    protected int satellitePosition() {
        return 30;
    }
}
