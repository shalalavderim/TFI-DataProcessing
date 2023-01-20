package com.apio.tfi.processor.transform

import com.apio.tfi.processor.config.DataProcessorConfig
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

/**
 * Applies the third rule as defined by analytics:
 * R3: More than 1 temperature alert in the last year.
 */
case class ApplyRule3(vConfig: DataProcessorConfig) {
  def apply(inputTable: DataFrame): DataFrame = {
    val applyRule3UDF = udf(applyRule3)
    inputTable.withColumn(vConfig.rule3ColName, applyRule3UDF(col(vConfig.rule3AlertsColname)))
  }

  def applyRule3 = (alertsCnt: Int) => {
    alertsCnt >= vConfig.rule3AlertsThreshold
  }
}
