package org.example;

public class LongestProject {
    private int projectId;
    private int monthCount;

    public LongestProject() {}

    public LongestProject(int projectId, int monthCount) {
        this.projectId = projectId;
        this.monthCount = monthCount;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "projectId=" + projectId +
                ", monthCount=" + monthCount +
                '}';
    }
}