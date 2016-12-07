package struct;

/**
 * Created by jakob on 23-11-16.
 */
public class Result implements Comparable<Result> {
    private int count;
    private String resultString;

    public Result(int count, String result) {
        this.count = count;
        this.resultString = result;
    }

    public int getCount() {
        return count;
    }

    public String getResultString() {
        return resultString;
    }

    @Override
    public int compareTo(Result o) {
        return o.getCount() - count;
    }
}
