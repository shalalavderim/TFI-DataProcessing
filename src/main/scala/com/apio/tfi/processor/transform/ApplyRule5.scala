package com.apio.tfi.processor.transform

import com.apio.tfi.processor.config.DataProcessorConfig
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

import scala.util.Try

/**
 * Applies the fifth rule as defined by analytics:
 * R5: Diesel cars of volvo older than 8 years.
 */
case class ApplyRule5(vConfig: DataProcessorConfig) {
  def apply(inputTable: DataFrame): DataFrame = {
    val applyRule5UDF = udf(applyRule5)
    inputTable.withColumn(vConfig.rule5ColName,
      applyRule5UDF(col(vConfig.rule5ManufacturerColName), col(vConfig.rule5FuelTypeColName), col(vConfig.rule5DaysOldColName)))
  }

  def applyRule5 = (manufacturer: String, fuelType: String, daysFromFirstReg: Int) => {
    Try(manufacturer.toUpperCase().trim.equals(vConfig.rule5ManufacturerValue)).getOrElse(vConfig.rule5ManufacturerDefaultEval) &&
      Try(fuelType.toUpperCase().trim.equals(vConfig.rule5FuelTypeValue)).getOrElse(vConfig.rule5FuelTypeDefaultEval) &&
      daysFromFirstReg >= vConfig.rule5DaysOldThreshold
  }
}
