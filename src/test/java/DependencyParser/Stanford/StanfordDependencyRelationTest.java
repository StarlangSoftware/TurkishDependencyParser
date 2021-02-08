package DependencyParser.Stanford;

import org.junit.Assert;
import org.junit.Test;

public class StanfordDependencyRelationTest {

    @Test
    public void testDependencyType() {
        Assert.assertTrue(StanfordDependencyRelation.getDependencyTag("acomp").equals(StanfordDependencyType.ACOMP));
        Assert.assertTrue(StanfordDependencyRelation.getDependencyTag("discourse").equals(StanfordDependencyType.DISCOURSE));
        Assert.assertTrue(StanfordDependencyRelation.getDependencyTag("Iobj").equals(StanfordDependencyType.IOBJ));
        Assert.assertTrue(StanfordDependencyRelation.getDependencyTag("iobj").equals(StanfordDependencyType.IOBJ));
    }

}
