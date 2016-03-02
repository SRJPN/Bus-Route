import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WeightTest {

    @Test
    public void testIsHeavierThan_returns_true_if_weight_is_heavier() throws Exception {
        Weight lighter = new Weight(5);
        Weight heavier = new Weight(7);
        assertTrue(heavier.isHeavierThan(lighter));
    }

    @Test
    public void testIsHeavierThan_returns_false_if_weight_is_lighter() throws Exception {
        Weight lighter = new Weight(5);
        Weight heavier = new Weight(7);
        assertFalse(lighter.isHeavierThan(heavier));
    }

    @Test
    public void testhashCode_returns_the_value_of_weight() throws Exception {
        Weight weight = new Weight(5);
        assertEquals(5,weight.hashCode());
    }
}