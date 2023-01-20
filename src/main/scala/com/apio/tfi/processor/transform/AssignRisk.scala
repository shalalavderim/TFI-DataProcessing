package com.apio.tfi.processor.transform

import com.apio.tfi.processor.config.DataProcessorConfig
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

import scala.util.Try

/**
 * Based on rule evaluation, assign the RiskCategory and RiskAction to each truck.
 */
case class AssignRisk(vConfig: DataProcessorConfig) {
  def apply(inputTable: DataFrame): DataFrame = {
    val assignRiskCategoryUDF = udf(assignRiskCategory)
    val assignRiskActionUDF = udf(assignRiskAction)
    inputTable
      .withColumn(vConfig.riskCategoryColName,
      assignRiskCategoryUDF(col(vConfig.rule1ColName), col(vConfig.rule2ColName), col(vConfig.rule3ColName),
        col(vConfig.rule4ColName), col(vConfig.rule5ColName)))
      .withColumn(vConfig.riskActionColName,
        assignRiskActionUDF(col(vConfig.rule1ColName), col(vConfig.rule2ColName), col(vConfig.rule3ColName),
          col(vConfig.rule4ColName), col(vConfig.rule5ColName)))
  }

  def assignRiskCategory = (r1: Boolean, r2: Boolean, r3: Boolean, r4: Boolean, r5: Boolean) => {
    val rulesEval = Seq(r1, r2, r3, r4, r5)
    val cntPositiveRules = rulesEval.filter(rule => rule.equals(true)).size

    if(cntPositiveRules >= vConfig.riskCategoryHighThreshold) vConfig.riskCategoryHighValue
    else if (cntPositiveRules >= vConfig.riskCategoryMediumThreshold) vConfig.riskCategoryMediumValue
    else vConfig.riskCategoryLowValue
  }
  def assignRiskAction = (r1: Boolean, r2: Boolean, r3: Boolean, r4: Boolean, r5: Boolean) => {
    val rulesEval = Seq(r1, r2, r3, r4, r5)
    val cntPositiveRules = rulesEval.filter(rule => rule.equals(true)).size

    if(cntPositiveRules >= vConfig.riskCategoryHighThreshold) vConfig.riskActionHighValue
    else if (cntPositiveRules >= vConfig.riskCategoryMediumThreshold) vConfig.riskActionMediumValue
    else vConfig.riskActionLowValue
  }
}
