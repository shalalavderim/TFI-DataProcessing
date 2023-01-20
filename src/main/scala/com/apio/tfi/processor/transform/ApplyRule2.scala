package com.apio.tfi.processor.transform

import com.apio.tfi.processor.config.DataProcessorConfig
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

/**
 * Applies the second rule as defined by analytics:
 * R2: Check if the Truck was more than 7 years old when registered for company less than 5 years ago.
 */
case class ApplyRule2(vConfig: DataProcessorConfig) {
  def apply(inputTable: DataFrame): DataFrame = {
    val applyRule2UDF = udf(applyRule2)
    inputTable.withColumn(vConfig.rule2ColName,
      applyRule2UDF(col(vConfig.rule2DaysOldColName), col(vConfig.rule2DaysRegColName)))
  }

  def applyRule2 = (daysBetweenFirstRegAndReg: Int, daysFromReg: Int) => {
    daysBetweenFirstRegAndReg >= vConfig.rule2DaysOldThreshold && daysFromReg <= vConfig.rule2DaysRegThreshold
  }
}
