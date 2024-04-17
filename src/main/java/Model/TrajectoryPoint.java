package Model;

public class TrajectoryPoint {
    private double time;
    private double coordX;
    private double coordY;
    private double coordZ;
    private double speedVx;
    private double speedVy;
    private double speedVz;

    /**
     * @param time    Момент времени t, c
     * @param coordX  Координата x, м
     * @param coordY  Координата y, м
     * @param coordZ  Координата z, м
     * @param speedVx Проекция скорости vx, м/с
     * @param speedVy Проекция скорости vy, м/с
     * @param speedVz Проекция скорости vz, м/с
     */
    public TrajectoryPoint(double time, double coordX, double coordY, double coordZ, double speedVx, double speedVy, double speedVz) {
        this.time = time;
        this.coordX = coordX;
        this.coordY = coordY;
        this.coordZ = coordZ;
        this.speedVx = speedVx;
        this.speedVy = speedVy;
        this.speedVz = speedVz;
    }

    public double getTime() {
        return this.time;
    }

    public double getCoordX() {
        return this.coordX;
    }

    public double getCoordY() {
        return this.coordY;
    }

    public double getCoordZ() {
        return this.coordZ;
    }

    public double getSpeedVx() {
        return this.speedVx;
    }

    public double getSpeedVy() {
        return this.speedVy;
    }

    public double getSpeedVz() {
        return this.speedVz;
    }
}