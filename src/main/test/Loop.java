import org.junit.Test;

/**
 * @author 周云龙
 * @date 2018/3/30 9:52
 */
public class Loop {

    /**
     * 求解：一筐鸡蛋：
     * 1个1个拿，正好拿完
     * 2个2个拿，还剩1个
     * 3个3个拿，正好拿完
     * 4个4个拿，还剩1个
     * 5个5个拿，还差1个
     * 6个6个拿，还剩3个
     * 7个7个拿，正好拿完
     * 8个8个拿，还剩1个
     * 9个9个拿，正好拿完
     * 问筐里最少有多少鸡蛋
     */
    @Test
    public void loop() {
        int i = 1;
        while (true) {
            if (i % 2 == 1 && i % 3 == 0 && i % 4 == 1 && (i + 1) % 5 == 0 && i % 6 == 3 && i % 7 == 0
                    && i % 8 == 1 && i % 9 == 0) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
