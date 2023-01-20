package com.apio.tfi.processor.transform

import com.apio.tfi.processor.config.DataProcessorConfig
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

/**
 * Applies the first rule as defined by analytics:
 * R1: Check if the Truck was more than 10 years old when registered for company.
 */
case class ApplyRule1(vConfig: DataProcessorConfig) {
  def apply(inputTable: DataFrame): DataFrame = {
    val applyRule1UDF = udf(applyRule1)
    inputTable.withColumn(vConfig.rule1ColName, applyRule1UDF(col(vConfig.rule1DaysColName)))
  }

  def applyRule1 = (daysBetweenFirstRegAndReg: Int) => {
    daysBetweenFirstRegAndReg >= vConfig.rule1Threshold
  }
}
