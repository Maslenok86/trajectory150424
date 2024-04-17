package Model;

import Model.TrajectoryPoint;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Trajectory {
    private List<TrajectoryPoint> trajectoryPoints;
    private File file;

    /**
     * @param file Файл, откуда будут считаны данные по траектории
     */
    public Trajectory(File file) {
        this.file = file;
        this.trajectoryPoints = new ArrayList<TrajectoryPoint>();
    }

    public void setTrajectoryPoints(List<TrajectoryPoint> trajectoryPoints) {
        this.trajectoryPoints.addAll(trajectoryPoints);
    }

    public List<TrajectoryPoint> getTrajectoryPoints() {
        return trajectoryPoints;
    }
}
