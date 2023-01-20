package com.apio.tfi.processor.config

import com.typesafe.config.Config

/**
 * This case class holds the configuration for the ControllersSVUpdates.
 */
case class DataProcessorConfig(typeSafeConfig: Config) {
  /**
   * Execution Mode
   */
  private val executionModeKey = "processor.execution.mode"
  val executionMode = typeSafeConfig.getString(executionModeKey)
  /**
   * Debug Mode
   */
  private val debugModeKey = "processor.debug.mode"
  val debugMode = typeSafeConfig.getBoolean(debugModeKey)
  /**
   * Master Data Path
   */
  private val masterDataInputPathKey = "processor.master.data.path"
  val masterDataInputPath = typeSafeConfig.getString(masterDataInputPathKey)
  /**
   * Master Data Filter Expression
   */
  private val masterDataFilterExpressionKey = "processor.master.data.filterexpression"
  val masterDataFilterExpression = typeSafeConfig.getString(masterDataFilterExpressionKey)
  /**
   * Analytics Rule1 ColName
   */
  private val rule1ColNameKey = "processor.analytics.rule1.colname"
  val rule1ColName = typeSafeConfig.getString(rule1ColNameKey)
  /**
   * Analytics Rule1 DaysColName
   */
  private val rule1DaysColNameKey = "processor.analytics.rule1.dayscolname"
  val rule1DaysColName = typeSafeConfig.getString(rule1DaysColNameKey)
  /**
   * Analytics Rule1 Threshold
   */
  private val rule1ThresholdKey = "processor.analytics.rule1.threshold"
  val rule1Threshold = typeSafeConfig.getInt(rule1ThresholdKey)
  /**
   * Analytics Rule2 ColName
   */
  private val rule2ColNameKey = "processor.analytics.rule2.colname"
  val rule2ColName = typeSafeConfig.getString(rule2ColNameKey)
  /**
   * Analytics Rule2 DaysOldColName
   */
  private val rule2DaysOldColNameKey = "processor.analytics.rule2.daysoldcolname"
  val rule2DaysOldColName = typeSafeConfig.getString(rule2DaysOldColNameKey)
  /**
   * Analytics Rule2 DaysOld Threshold
   */
  private val rule2DaysOldThresholdKey = "processor.analytics.rule2.daysoldthreshold"
  val rule2DaysOldThreshold = typeSafeConfig.getInt(rule2DaysOldThresholdKey)
  /**
   * Analytics Rule2 DaysReg ColName
   */
  private val rule2DaysRegColNameKey = "processor.analytics.rule2.daysregcolname"
  val rule2DaysRegColName = typeSafeConfig.getString(rule2DaysRegColNameKey)
  /**
   * Analytics Rule2 DaysReg Threshold
   */
  private val rule2DaysRegThresholdKey = "processor.analytics.rule2.daysregthreshold"
  val rule2DaysRegThreshold = typeSafeConfig.getInt(rule2DaysRegThresholdKey)
  /**
   * Analytics Rule3 ColName
   */
  private val rule3ColNameKey = "processor.analytics.rule3.colname"
  val rule3ColName = typeSafeConfig.getString(rule3ColNameKey)
  /**
   * Analytics Rule3 Alerts ColName
   */
  private val rule3AlertsColnameKey = "processor.analytics.rule3.alertscolname"
  val rule3AlertsColname = typeSafeConfig.getString(rule3AlertsColnameKey)
  /**
   * Analytics Rule3 Alerts Threshold
   */
  private val rule3AlertsThresholdKey = "processor.analytics.rule3.alertsthreshold"
  val rule3AlertsThreshold = typeSafeConfig.getInt(rule3AlertsThresholdKey)
  /**
   * Analytics Rule4 ColName
   */
  private val rule4ColNameKey = "processor.analytics.rule4.colname"
  val rule4ColName = typeSafeConfig.getString(rule4ColNameKey)
  /**
   * Analytics Rule4 City ColName
   */
  private val rule4CityColNameKey = "processor.analytics.rule4.citycolname"
  val rule4CityColName = typeSafeConfig.getString(rule4CityColNameKey)
  /**
   * Analytics Rule4 City Value
   */
  private val rule4CityValueKey = "processor.analytics.rule4.cityvalue"
  val rule4CityValue = typeSafeConfig.getString(rule4CityValueKey)
  /**
   * Analytics Rule4 City Default Evaluation Value
   */
  private val rule4CityDefaultEvalKey = "processor.analytics.rule4.citydefaulteval"
  val rule4CityDefaultEval = typeSafeConfig.getBoolean(rule4CityDefaultEvalKey)
  /**
   * Analytics Rule4 DaysOldColName
   */
  private val rule4DaysOldColNameKey = "processor.analytics.rule4.daysoldcolname"
  val rule4DaysOldColName = typeSafeConfig.getString(rule4DaysOldColNameKey)
  /**
   * Analytics Rule4 DaysOld Threshold
   */
  private val rule4DaysOldThresholdKey = "processor.analytics.rule4.daysoldthreshold"
  val rule4DaysOldThreshold = typeSafeConfig.getInt(rule4DaysOldThresholdKey)
  /**
   * Analytics Rule5 ColName
   */
  private val rule5ColNameKey = "processor.analytics.rule5.colname"
  val rule5ColName = typeSafeConfig.getString(rule5ColNameKey)
  /**
   * Analytics Rule5 Manufacturer ColName
   */
  private val rule5ManufacturerColNameKey = "processor.analytics.rule5.manufacturercolname"
  val rule5ManufacturerColName = typeSafeConfig.getString(rule5ManufacturerColNameKey)
  /**
   * Analytics Rule5 Manufacturer Value
   */
  private val rule5ManufacturerValueKey = "processor.analytics.rule5.manufacturervalue"
  val rule5ManufacturerValue = typeSafeConfig.getString(rule5ManufacturerValueKey)
  /**
   * Analytics Rule5 Manufacturer Default Evaluation Value
   */
  private val rule5ManufacturerDefaultEvalKey = "processor.analytics.rule5.manufacturerdefaulteval"
  val rule5ManufacturerDefaultEval = typeSafeConfig.getBoolean(rule5ManufacturerDefaultEvalKey)
  /**
   * Analytics Rule5 FuelType ColName
   */
  private val rule5FuelTypeColNameKey = "processor.analytics.rule5.fueltypecolname"
  val rule5FuelTypeColName = typeSafeConfig.getString(rule5FuelTypeColNameKey)
  /**
   * Analytics Rule5 FuelType Value
   */
  private val rule5FuelTypeValueKey = "processor.analytics.rule5.fueltypevalue"
  val rule5FuelTypeValue = typeSafeConfig.getString(rule5FuelTypeValueKey)
  /**
   * Analytics Rule5 FuelType Default Evaluation Value
   */
  private val rule5FuelTypeDefaultEvalKey = "processor.analytics.rule5.fueltypedefaulteval"
  val rule5FuelTypeDefaultEval = typeSafeConfig.getBoolean(rule5FuelTypeDefaultEvalKey)
  /**
   * Analytics Rule5 DaysOldColName
   */
  private val rule5DaysOldColNameKey = "processor.analytics.rule5.daysoldcolname"
  val rule5DaysOldColName = typeSafeConfig.getString(rule5DaysOldColNameKey)
  /**
   * Analytics Rule5 DaysOld Threshold
   */
  private val rule5DaysOldThresholdKey = "processor.analytics.rule5.daysoldthreshold"
  val rule5DaysOldThreshold = typeSafeConfig.getInt(rule5DaysOldThresholdKey)
  /**
   * Analytics RiskCategory ColName
   */
  private val riskCategoryColNameKey = "processor.analytics.riskcategory.colname"
  val riskCategoryColName = typeSafeConfig.getString(riskCategoryColNameKey)
  /**
   * Analytics RiskCategory LowValue
   */
  private val riskCategoryLowValueKey = "processor.analytics.riskcategory.lowvalue"
  val riskCategoryLowValue = typeSafeConfig.getString(riskCategoryLowValueKey)
  /**
   * Analytics RiskCategory MediumValue
   */
  private val riskCategoryMediumValueKey = "processor.analytics.riskcategory.mediumvalue"
  val riskCategoryMediumValue = typeSafeConfig.getString(riskCategoryMediumValueKey)
  /**
   * Analytics RiskCategory HighValue
   */
  private val riskCategoryHighValueKey = "processor.analytics.riskcategory.highvalue"
  val riskCategoryHighValue = typeSafeConfig.getString(riskCategoryHighValueKey)
  /**
   * Analytics RiskCategory HighThreshold
   */
  private val riskCategoryHighThresholdKey = "processor.analytics.riskcategory.highthreshold"
  val riskCategoryHighThreshold = typeSafeConfig.getInt(riskCategoryHighThresholdKey)
  /**
   * Analytics RiskCategory MediumThreshold
   */
  private val riskCategoryMediumThresholdKey = "processor.analytics.riskcategory.mediumthreshold"
  val riskCategoryMediumThreshold = typeSafeConfig.getInt(riskCategoryMediumThresholdKey)
  /**
   * Analytics RiskAction ColName
   */
  private val riskActionColNameKey = "processor.analytics.riskaction.colname"
  val riskActionColName = typeSafeConfig.getString(riskActionColNameKey)
  /**
   * Analytics RiskAction LowValue
   */
  private val riskActionLowValueKey = "processor.analytics.riskaction.lowvalue"
  val riskActionLowValue = typeSafeConfig.getString(riskActionLowValueKey)
  /**
   * Analytics RiskAction MediumValue
   */
  private val riskActionMediumValueKey = "processor.analytics.riskaction.mediumvalue"
  val riskActionMediumValue = typeSafeConfig.getString(riskActionMediumValueKey)
  /**
   * Analytics RiskAction HighValue
   */
  private val riskActionHighValueKey = "processor.analytics.riskaction.highvalue"
  val riskActionHighValue = typeSafeConfig.getString(riskActionHighValueKey)
  /**
   * Analytics Data Output Path
   */
  private val analyticsDataOutputPathKey = "processor.analytics.data.path"
  val analyticsDataOutputPath = typeSafeConfig.getString(analyticsDataOutputPathKey)
  /**
   * Analytics Data Partition Cols
   */
  private val analyticsDataPartitionColsKey = "processor.analytics.data.partition"
  val analyticsDataPartitionCols = typeSafeConfig.getStringList(analyticsDataPartitionColsKey)
  /**
   * Analytics Data Output Mode
   */
  private val analyticsDataOutputModeKey = "processor.analytics.data.output.mode"
  val analyticsDataOutputMode = typeSafeConfig.getString(analyticsDataOutputModeKey)
}

