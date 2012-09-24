package net.sourceforge.seqware.common.model;

//default package
//Generated 09.12.2011 15:01:20 by Hibernate Tools 3.2.4.GA

/**
 * ProcessingExperiments generated by hbm2java
 */
public class ProcessingExperiments implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private int processingExperimentsId;
  private Processing processing;
  private Experiment experiment;
  private String description;
  private String label;
  private String url;
  private Integer swAccession;

  public ProcessingExperiments() {
  }

  public ProcessingExperiments(int processingExperimentsId, Processing processing, Experiment experiment) {
    this.processingExperimentsId = processingExperimentsId;
    this.processing = processing;
    this.experiment = experiment;
  }

  public ProcessingExperiments(int processingExperimentsId, Processing processing, Experiment experiment,
      String description, String label, String url, Integer swAccession) {
    this.processingExperimentsId = processingExperimentsId;
    this.processing = processing;
    this.experiment = experiment;
    this.description = description;
    this.label = label;
    this.url = url;
    this.swAccession = swAccession;
  }

  public int getProcessingExperimentsId() {
    return this.processingExperimentsId;
  }

  public void setProcessingExperimentsId(int processingExperimentsId) {
    this.processingExperimentsId = processingExperimentsId;
  }

  public Processing getProcessing() {
    return this.processing;
  }

  public void setProcessing(Processing processing) {
    this.processing = processing;
  }

  public Experiment getExperiment() {
    return this.experiment;
  }

  public void setExperiment(Experiment experiment) {
    this.experiment = experiment;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLabel() {
    return this.label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getSwAccession() {
    return this.swAccession;
  }

  public void setSwAccession(Integer swAccession) {
    this.swAccession = swAccession;
  }

}