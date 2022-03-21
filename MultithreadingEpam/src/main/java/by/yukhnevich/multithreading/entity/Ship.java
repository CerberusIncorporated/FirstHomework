package by.yukhnevich.multithreading.entity;

import by.yukhnevich.multithreading.util.ShipIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ship implements Runnable {
    private static final Logger logger = LogManager.getLogger();
    private final int shipId;
    private final TaskType taskType;
    private TaskState taskState;

    public Ship(TaskType taskType) {
        this.shipId = ShipIdGenerator.generateId();
        this.taskType = taskType;
        this.taskState = TaskState.BEFORE_START;
    }

    @Override
    public void run() {
        this.taskState = TaskState.IN_PROGRESS;
        logger.info("Ship {} runs", shipId);
        SeaPort seaPort = SeaPort.getInstance();
        Pier pier = seaPort.obtainPier();
        pier.processShip(this);
        seaPort.releasePier(pier);
        this.taskState = TaskState.COMPLETE;
        logger.info("Ship {} processing is completed", shipId);
    }

    public int getShipId() {
        return shipId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (shipId != ship.shipId) return false;
        if (taskType != ship.taskType) return false;
        return taskState == ship.taskState;
    }

    @Override
    public int hashCode() {
        int result = shipId;
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        result = 31 * result + (taskState != null ? taskState.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ship{");
        sb.append("shipId=").append(shipId);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskState=").append(taskState);
        sb.append('}');
        return sb.toString();
    }

    public enum TaskType {
        LOAD, UNLOAD
    }

    public enum TaskState {
        BEFORE_START, IN_PROGRESS, COMPLETE
    }
}
