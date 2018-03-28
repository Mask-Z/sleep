/**
 * @author 周云龙
 * @date 2018/3/28 16:19
 */
public class SleepOne {
    private String message;

    public SleepOne(String message) {
        this.message = message;
    }

    public SleepOne() {
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMesage(){
        System.out.println("Di..."+this.message);
    }
}
