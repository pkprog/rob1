package ru.pktest.rob1;

import org.junit.Test;
import ru.pk.rob1.logger.Logger;

public class Rob1Test {

    @Test
    public void testLogger() {
        Logger.log("1.1:{}, 2:{}, 3:{}", 11,22,33);
        Logger.log("2.1:{}, 2:{}, 3:{}", 11,22,33);
    }

}
