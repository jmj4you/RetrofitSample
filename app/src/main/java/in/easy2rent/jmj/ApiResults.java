package in.easy2rent.jmj;

import java.util.List;

/**
 * Created by joseph on 24/2/16.
 */
public class ApiResults {
    public int status;
    public List message;
    public List error;
    public List<Agent> data;
    public String next_url;

    public int getStatus() {
//        return (this.status == 1) ? true : false;
        return this.status;
    }


    public List<Agent> getData() {

    return this.data;
    }
}
