package cheapDrugs.DTO.requests.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDTO {
    public String jobTitle;
    private String jobDescription;
    private String message;
    private String salary;
}
