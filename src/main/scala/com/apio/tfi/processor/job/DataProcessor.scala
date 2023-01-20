package com.apio.tfi.processor.job

import com.apio.tfi.processor.config.{DataProcessorConfig, DataProcessorConfigUtils}
import com.apio.tfi.processor.transform._
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * ETL Job which reads the master data of Trucks, combines, transforms them, and writes to analytics data.
 */
class DataProcessor(vConfig: DataProcessorConfig, spark: SparkSession) extends Serializable {

  def readData(): DataFrame = {
    println("Read Master Data ...")
    val masterDataDf = spark.read.parquet(vConfig.masterDataInputPath)

    println("Read Master Data Success.")
    masterDataDf
  }

  def processData(inputData: DataFrame): DataFrame = {
    println("Analyze Trucks Master Data ...")
    val filteredData = inputData.filter(vConfig.masterDataFilterExpression)
    val stage1Data = ApplyRule1(vConfig).apply(filteredData)
    val stage2Data = ApplyRule2(vConfig).apply(stage1Data)
    val stage3Data = ApplyRule3(vConfig).apply(stage2Data)
    val stage4Data = ApplyRule4(vConfig).apply(stage3Data)
    val stage5Data = ApplyRule5(vConfig).apply(stage4Data)
    val analyticsData = AssignRisk(vConfig).apply(stage5Data)

    println("Analyze Trucks Master Data Success.")
    analyticsData
  }

  def writeData(processedData: DataFrame): Unit = {
    println("Writing Analytics Trucks Data ...")
    if (vConfig.debugMode) {
      println("Partition Cols: ${vConfig.analyticsDataPartitionCols}")
      println("Output Path: ${vConfig.analyticsDataOutputPath}")
    }

    processedData
      .repartition(DataProcessorConfigUtils.toScalaList(vConfig.analyticsDataPartitionCols).map(c => col(c)): _*)
      .write.mode(vConfig.analyticsDataOutputMode).partitionBy(DataProcessorConfigUtils.toScalaList(vConfig.analyticsDataPartitionCols): _*)
      .parquet(vConfig.analyticsDataOutputPath)

    import com.databricks.dbutils_v1.DBUtilsHolder.dbutils
    dbutils.fs.rm(s"${vConfig.analyticsDataOutputPath}/_SUCCESS")
    println("Write Analytics Trucks Data Success.")
  }
}
