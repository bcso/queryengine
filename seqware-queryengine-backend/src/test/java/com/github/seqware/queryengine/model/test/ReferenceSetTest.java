package com.github.seqware.queryengine.model.test;

import com.github.seqware.queryengine.Constants;
import com.github.seqware.queryengine.factory.CreateUpdateManager;
import com.github.seqware.queryengine.factory.SWQEFactory;
import com.github.seqware.queryengine.model.Reference;
import com.github.seqware.queryengine.model.ReferenceSet;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests of {@link com.github.seqware.queryengine.model.ReferenceSet}.
 *
 * @author jbaran
 * @version $Id: $Id
 * @since 0.13.3
 */
public class ReferenceSetTest {

    /**
     * <p>testConsistentStorageSingleFeatures.</p>
     */
    @Test
    public void testConsistentStorageSingleFeatures() {
        CreateUpdateManager mManager = SWQEFactory.getModelManager();
        ReferenceSet aSet = mManager.buildReferenceSet().setName("Human").setOrganism("Homo Sapiens").build();
        Set<Reference> testReferences = new HashSet<Reference>();
        testReferences.add(mManager.buildReference().setName("Dummy_reference1").build());
        testReferences.add(mManager.buildReference().setName("Dummy_reference2").build());
        testReferences.add(mManager.buildReference().setName("Dummy_reference3").build());

        for (Reference testReference : testReferences) {
            aSet.add(testReference);
        }

        // NOTE Misses test case where all added features are being dropped and nothing is stored.
        for (Reference resultReference : aSet) {
            Assert.assertTrue("Seeing a reference that is either not in the original test set, or is being returned more than once.", testReferences.contains(resultReference));

            testReferences.remove(resultReference);
        }

        Assert.assertTrue("Reference set did not return all of the references that had been stored previously.", testReferences.isEmpty());
    }

    /**
     * <p>testVersioningAndFeatureSets.</p>
     */
    @Test
    public void testVersioningAndFeatureSets() {
        if (!Constants.TRACK_VERSIONING){
            return;
        }
        CreateUpdateManager mManager = SWQEFactory.getModelManager();
        ReferenceSet aSet = mManager.buildReferenceSet().setName("Human").setOrganism("Homo Sapiens").build();
        Assert.assertTrue("versions should start with version 1", aSet.getVersion() == 1);
        mManager.flush(); // this should persist a version with no features
        Assert.assertTrue("versions should remain at 1 after the first store", aSet.getVersion() == 1);
        ReferenceSet testSet = (ReferenceSet) SWQEFactory.getQueryInterface().getAtomBySGID(ReferenceSet.class, aSet.getSGID());
        Assert.assertTrue("versions should start at 1 after the first store", testSet.getVersion() == 1);
        aSet.add(mManager.buildReference().setName("t1").build());
        mManager.flush(); // this should persist a version with 1 references
        Assert.assertTrue("versions should increment to version 2", aSet.getVersion() == 2);
        testSet = (ReferenceSet) SWQEFactory.getQueryInterface().getAtomBySGID(ReferenceSet.class, aSet.getSGID());
        Assert.assertTrue("versions should increment to version 2", testSet.getVersion() == 2);
        aSet.add(mManager.buildReference().setName("t2").build());
        mManager.flush(); // this should persist a version with 2 references
        Assert.assertTrue("versions should increment to version 3", aSet.getVersion() == 3);
        testSet = (ReferenceSet) SWQEFactory.getQueryInterface().getAtomBySGID(ReferenceSet.class, aSet.getSGID());
        Assert.assertTrue("referenceSet version wrong, expected 3 and found " + testSet.getVersion(), testSet.getVersion() == 3);
        Assert.assertTrue("old referenceSet version wrong", testSet.getPrecedingVersion().getVersion() == 2);
        Assert.assertTrue("very old referenceSet version wrong", testSet.getPrecedingVersion().getPrecedingVersion().getVersion() == 1);
        Assert.assertTrue("referenceSet size wrong", testSet.getCount() == 2);
        Assert.assertTrue("old referenceSet size wrong", testSet.getPrecedingVersion().getCount() == 1);
        Assert.assertTrue("very old referenceSet size wrong", testSet.getPrecedingVersion().getPrecedingVersion().getCount() == 0);
        // assert the same properties with the one in memory already
        Assert.assertTrue("referenceSet version wrong", aSet.getVersion() == 3);
        Assert.assertTrue("old referenceSet version wrong", aSet.getPrecedingVersion().getVersion() == 2);
        Assert.assertTrue("very old referenceSet version wrong", aSet.getPrecedingVersion().getPrecedingVersion().getVersion() == 1);
        Assert.assertTrue("referenceSet size wrong", aSet.getCount() == 2);
        Assert.assertTrue("old referenceSet size wrong", aSet.getPrecedingVersion().getCount() == 1);
        Assert.assertTrue("very old referenceSet size wrong", aSet.getPrecedingVersion().getPrecedingVersion().getCount() == 0);
    }
}
