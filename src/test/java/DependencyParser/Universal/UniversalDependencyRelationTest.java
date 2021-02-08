package DependencyParser.Universal;

import org.junit.Assert;
import org.junit.Test;

public class UniversalDependencyRelationTest {

    @Test
    public void testDependencyPosType() {
        Assert.assertTrue(UniversalDependencyRelation.getDependencyPosType("adj").equals(UniversalDependencyPosType.ADJ));
        Assert.assertTrue(UniversalDependencyRelation.getDependencyPosType("intj").equals(UniversalDependencyPosType.INTJ));
        Assert.assertTrue(UniversalDependencyRelation.getDependencyPosType("Det").equals(UniversalDependencyPosType.DET));
    }

    @Test
    public void testDependencyType() {
        Assert.assertTrue(UniversalDependencyRelation.getDependencyTag("acl").equals(UniversalDependencyType.ACL));
        Assert.assertTrue(UniversalDependencyRelation.getDependencyTag("iobj").equals(UniversalDependencyType.IOBJ));
        Assert.assertTrue(UniversalDependencyRelation.getDependencyTag("Iobj").equals(UniversalDependencyType.IOBJ));
        Assert.assertTrue(UniversalDependencyRelation.getDependencyTag("fixed").equals(UniversalDependencyType.FIXED));
    }

}
