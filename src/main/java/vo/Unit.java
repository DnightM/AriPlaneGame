package vo;

abstract class Unit {
    double x;
    double y;
    int width;
    int height;
    double speed; // 0:정지, 음수 가능
    int direction; // 1:동, 2:서, 4:남, 8:북, 북동:9, 북서:10, 남동:5, 남서:6

    public void move() {
        for (int i = 0; i < 4; i++) {
            if ((direction & (1 << i)) > 0) {

            }
        }
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }
}
