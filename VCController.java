import java.util.*;

public class VCController extends User {
	private Queue<Job> jobs = new LinkedList<>();
	
	public void assignJob(Job job) {
		jobs.add(job);
	}
	public VCController(String VCID) {
		super(VCID);
	}
	
	public String completion() {
		int time = 0;
		StringBuilder x = new StringBuilder();
		
		for(Job job : jobs) {
			time+= job.getDurationMinutes();
			
			x.append("Job ID: " + job.getJobID() + " | Duration: " + job.getDurationMinutes() +
	                  " | Completion Time: " + time + "\n");
	  
		}
		return x.toString();
	}

	@Override
	public String fileText() {
		return "VCController" + ID;
	}
	
}
