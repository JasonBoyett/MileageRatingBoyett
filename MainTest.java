/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest extends Main {

    @Test
    public void testMain(){
        assertEquals(RATING.Excellent, Main.getRATING(45));
        assertEquals(RATING.Fair, Main.getRATING(22));
        assertEquals(RATING.Good, Main.getRATING(35));
        assertEquals(RATING.Poor, Main.getRATING(5));
    }
}
