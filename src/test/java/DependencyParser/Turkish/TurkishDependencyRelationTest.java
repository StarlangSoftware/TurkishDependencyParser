package DependencyParser.Turkish;

import org.junit.Assert;
import org.junit.Test;

public class TurkishDependencyRelationTest {

    @Test
    public void testDependencyType() {
        Assert.assertTrue(TurkishDependencyRelation.getDependencyTag("subject").equals(TurkishDependencyType.SUBJECT));
        Assert.assertTrue(TurkishDependencyRelation.getDependencyTag("vocative").equals(TurkishDependencyType.VOCATIVE));
        Assert.assertTrue(TurkishDependencyRelation.getDependencyTag("Relativizer").equals(TurkishDependencyType.RELATIVIZER));
    }

}
