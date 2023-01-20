package com.apio.tfi.processor.transform

import com.apio.tfi.processor.config.DataProcessorConfig
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

import scala.util.Try

/**
 * Applies the fourth rule as defined by analytics:
 * R4: Check if the Truck is in Berlin and more than 8 years old.
 */
case class ApplyRule4(vConfig: DataProcessorConfig) {
  def apply(inputTable: DataFrame): DataFrame = {
    val applyRule4UDF = udf(applyRule4)
    inputTable.withColumn(vConfig.rule4ColName,
      applyRule4UDF(col(vConfig.rule4CityColName), col(vConfig.rule4DaysOldColName)))
  }

  def applyRule4 = (city: String, daysFromFirstReg: Int) => {
    Try(city.toUpperCase().trim.equals(vConfig.rule4CityValue)).getOrElse(vConfig.rule4CityDefaultEval) &&
      daysFromFirstReg >= vConfig.rule4DaysOldThreshold
  }
}
