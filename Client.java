import java.time.LocalDateTime;

public class Client extends User {

    private Job job;

// clientID is passed to the parent class(user) as the ID
    public Client(String clientID, String jobID, int jobDurationMinutes, LocalDateTime jobDeadline) {
        super(clientID);
        this.job = new Job(jobID, clientID, jobDurationMinutes, jobDeadline);
    }

    public Job getJob() {
        return job;
    }

    @Override
    public String fileText() {
        return "Client ID: " + ID
                + " | Timestamp: " + time
                + " | Job ID: " + job.getJobID()
                + " | Approx job duration: " + job.getDuration() + " min"
                + " | Job deadline: " + job.getDeadline()
                + " | Status: " + job.getStatus();
    }
} // MEHMET SOYDAN DATA STORAGE WORK