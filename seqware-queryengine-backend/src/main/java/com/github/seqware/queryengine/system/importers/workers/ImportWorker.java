/**
 *
 */
package com.github.seqware.queryengine.system.importers.workers;

import com.github.seqware.queryengine.system.importers.Importer;
import com.github.seqware.queryengine.system.importers.SOFeatureImporter;
import com.github.seqware.queryengine.util.SGID;
import java.util.List;

/**
 * Base Worker class, looks like a Bean for storing settings about the file to
 * be converted.
 *
 * @author dyuen
 * @author boconnor
 * @version $Id: $Id
 */
public class ImportWorker implements Runnable {

    protected String workerName = null;
    protected Importer pmi = null;
    // Actually, on second thought. I think a shared CreateUpdateManager would be a bad idea. 
    // We don't really want all threads to freeze
    //    CreateUpdateManager mManager = null;
    //Store store = null;
    protected String input = null;
    protected boolean compressed = false;
    protected int minCoverage;
    protected int maxCoverage;
    protected float minSnpQuality;
    protected boolean includeSNV;
    protected int fastqConvNum;
    protected boolean includeIndels;
    protected boolean includeCoverage = false;
    protected int binSize = 0;
    protected SGID featureSetID = null;
    protected List<SGID> tagSetIDs = null;
    protected SGID adhoctagset = null;
    protected int batch_size = SOFeatureImporter.BATCH_SIZE;
    protected String keyIndex = null;

    /**
     * <p>Constructor for ImportWorker.</p>
     */
    public ImportWorker() {
    }

    /**
     * <p>Constructor for ImportWorker.</p>
     *
     * @param workerName a {@link java.lang.String} object.
     * @param pmi a {@link com.github.seqware.queryengine.system.importers.Importer} object.
     * @param input a {@link java.lang.String} object.
     * @param compressed a boolean.
     * @param minCoverage a int.
     * @param maxCoverage a int.
     * @param minSnpQuality a float.
     * @param includeSNV a boolean.
     * @param fastqConvNum a int.
     * @param includeIndels a boolean.
     * @param includeCoverage a boolean.
     * @param binSize a int.
     */
    public ImportWorker(String workerName, Importer pmi, // CreateUpdateManager store,
             String input, boolean compressed, int minCoverage, int maxCoverage, 
             float minSnpQuality, boolean includeSNV, int fastqConvNum, 
             boolean includeIndels, boolean includeCoverage, int binSize) {
        this.workerName = workerName;
        this.pmi = pmi;
//        this.mManager = store;
        this.input = input;
        this.compressed = compressed;
        this.minCoverage = minCoverage;
        this.maxCoverage = maxCoverage;
        this.minSnpQuality = minSnpQuality;
        this.includeSNV = includeSNV;
        this.fastqConvNum = fastqConvNum;
        this.includeIndels = includeIndels;
        this.includeCoverage = includeCoverage;
        this.binSize = binSize;
    }

    /** {@inheritDoc} */
    @Override
    public void run() {
    }

    // autogenerated
    /**
     * <p>Getter for the field <code>workerName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getWorkerName() {
        return workerName;
    }

    /**
     * <p>Setter for the field <code>workerName</code>.</p>
     *
     * @param workerName a {@link java.lang.String} object.
     */
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    /**
     * <p>Getter for the field <code>pmi</code>.</p>
     *
     * @return a {@link com.github.seqware.queryengine.system.importers.Importer} object.
     */
    public Importer getPmi() {
        return pmi;
    }

    /**
     * <p>Setter for the field <code>pmi</code>.</p>
     *
     * @param pmi a {@link com.github.seqware.queryengine.system.importers.Importer} object.
     */
    public void setPmi(Importer pmi) {
        this.pmi = pmi;
    }

//    public CreateUpdateManager getStore() {
//        return mManager;
//        // return this.store
//    }
//
//    public void setStore(CreateUpdateManager mManager) {
//        //this.store = store
//        this.mManager = mManager;
//    }

    /**
     * <p>Getter for the field <code>input</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getInput() {
        return input;
    }

    /**
     * <p>Setter for the field <code>input</code>.</p>
     *
     * @param input a {@link java.lang.String} object.
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * <p>isCompressed.</p>
     *
     * @return a boolean.
     */
    public boolean isCompressed() {
        return compressed;
    }

    /**
     * <p>Setter for the field <code>compressed</code>.</p>
     *
     * @param compressed a boolean.
     */
    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

    /**
     * <p>Getter for the field <code>minCoverage</code>.</p>
     *
     * @return a int.
     */
    public int getMinCoverage() {
        return minCoverage;
    }

    /**
     * <p>Setter for the field <code>minCoverage</code>.</p>
     *
     * @param minCoverage a int.
     */
    public void setMinCoverage(int minCoverage) {
        this.minCoverage = minCoverage;
    }

    /**
     * <p>Getter for the field <code>maxCoverage</code>.</p>
     *
     * @return a int.
     */
    public int getMaxCoverage() {
        return maxCoverage;
    }

    /**
     * <p>Setter for the field <code>maxCoverage</code>.</p>
     *
     * @param maxCoverage a int.
     */
    public void setMaxCoverage(int maxCoverage) {
        this.maxCoverage = maxCoverage;
    }

    /**
     * <p>Getter for the field <code>minSnpQuality</code>.</p>
     *
     * @return a float.
     */
    public float getMinSnpQuality() {
        return minSnpQuality;
    }

    /**
     * <p>Setter for the field <code>minSnpQuality</code>.</p>
     *
     * @param minSnpQuality a float.
     */
    public void setMinSnpQuality(float minSnpQuality) {
        this.minSnpQuality = minSnpQuality;
    }

    /**
     * <p>isIncludeSNV.</p>
     *
     * @return a boolean.
     */
    public boolean isIncludeSNV() {
        return includeSNV;
    }

    /**
     * <p>Setter for the field <code>includeSNV</code>.</p>
     *
     * @param includeSNV a boolean.
     */
    public void setIncludeSNV(boolean includeSNV) {
        this.includeSNV = includeSNV;
    }

    /**
     * <p>Getter for the field <code>fastqConvNum</code>.</p>
     *
     * @return a int.
     */
    public int getFastqConvNum() {
        return fastqConvNum;
    }

    /**
     * <p>Setter for the field <code>fastqConvNum</code>.</p>
     *
     * @param fastqConvNum a int.
     */
    public void setFastqConvNum(int fastqConvNum) {
        this.fastqConvNum = fastqConvNum;
    }

    /**
     * <p>isIncludeIndels.</p>
     *
     * @return a boolean.
     */
    public boolean isIncludeIndels() {
        return includeIndels;
    }

    /**
     * <p>Setter for the field <code>includeIndels</code>.</p>
     *
     * @param includeIndels a boolean.
     */
    public void setIncludeIndels(boolean includeIndels) {
        this.includeIndels = includeIndels;
    }

    /**
     * <p>isIncludeCoverage.</p>
     *
     * @return a boolean.
     */
    public boolean isIncludeCoverage() {
        return includeCoverage;
    }

    /**
     * <p>Setter for the field <code>includeCoverage</code>.</p>
     *
     * @param includeCoverage a boolean.
     */
    public void setIncludeCoverage(boolean includeCoverage) {
        this.includeCoverage = includeCoverage;
    }

    /**
     * <p>Getter for the field <code>binSize</code>.</p>
     *
     * @return a int.
     */
    public int getBinSize() {
        return binSize;
    }

    /**
     * <p>Setter for the field <code>binSize</code>.</p>
     *
     * @param binSize a int.
     */
    public void setBinSize(int binSize) {
        this.binSize = binSize;
    }

    /**
     * <p>Getter for the field <code>featureSetID</code>.</p>
     *
     * @return a {@link com.github.seqware.queryengine.util.SGID} object.
     */
    public SGID getFeatureSetID() {
        return featureSetID;
    }

    /**
     * <p>Setter for the field <code>featureSetID</code>.</p>
     *
     * @param featureSetID a {@link com.github.seqware.queryengine.util.SGID} object.
     */
    public void setFeatureSetID(SGID featureSetID) {
        this.featureSetID = featureSetID;
    }

    /**
     * <p>Getter for the field <code>adhoctagset</code>.</p>
     *
     * @return a {@link com.github.seqware.queryengine.util.SGID} object.
     */
    public SGID getAdhoctagset() {
        return adhoctagset;
    }

    /**
     * <p>Setter for the field <code>adhoctagset</code>.</p>
     *
     * @param adhoctagset a {@link com.github.seqware.queryengine.util.SGID} object.
     */
    public void setAdhoctagset(SGID adhoctagset) {
        this.adhoctagset = adhoctagset;
    }

    /**
     * <p>Getter for the field <code>tagSetIDs</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<SGID> getTagSetIDs() {
        return tagSetIDs;
    }

    /**
     * <p>Setter for the field <code>tagSetIDs</code>.</p>
     *
     * @param tagSetIDs a {@link java.util.List} object.
     */
    public void setTagSetIDs(List<SGID> tagSetIDs) {
        this.tagSetIDs = tagSetIDs;
    }

    /**
     * <p>Getter for the field <code>batch_size</code>.</p>
     *
     * @return a int.
     */
    public int getBatch_size() {
        return batch_size;
    }

    /**
     * <p>Setter for the field <code>batch_size</code>.</p>
     *
     * @param batch_size a int.
     */
    public void setBatch_size(int batch_size) {
        this.batch_size = batch_size;
    }

    /**
     * <p>Getter for the field <code>keyIndex</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getKeyIndex() {
        return keyIndex;
    }

    /**
     * <p>Setter for the field <code>keyIndex</code>.</p>
     *
     * @param keyIndex a {@link java.lang.String} object.
     */
    public void setKeyIndex(String keyIndex) {
        this.keyIndex = keyIndex;
    }

    
    
}
