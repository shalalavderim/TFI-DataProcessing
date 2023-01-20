package com.apio.tfi.job

import java.io.File

import com.apio.tfi.processor.config.DataProcessorConfig
import com.apio.tfi.processor.job.DataProcessor
import com.holdenkarau.spark.testing.DataFrameSuiteBase
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSuite, Matchers}

/**
 * TFI-DataProcessor Integration Test
 */
class DataProcessorSuite extends FunSuite with Matchers with DataFrameSuiteBase {

  val configPath = getClass.getResource("/TFI-DataProcessor.conf").getPath
  val configFile = new File(configPath)
  val tsConfig = ConfigFactory.parseFile(configFile)
  val vConfig = DataProcessorConfig(tsConfig)
  val inputDataPath= "src/test/resources/ProcessorSuiteData/Input.parquet"
  val expectedDataPath = "src/test/resources/ProcessorSuiteData/Output.parquet"

 test("DataProcessor Integration Test") {
  sc.setLogLevel("ERROR")
   val spark = sqlContext.sparkSession
   val processorJob = new DataProcessor(vConfig, spark)

   val masterData = spark.read.parquet(inputDataPath)
   if (vConfig.debugMode) {
     println("Integration Test Input Master Data")
     masterData.show()
   }

   val processedData = processorJob.processData(masterData)
   if (vConfig.debugMode) {
     println("Integration Test Output Analytics Data")
     processedData.show()
   }

   val expectedData = spark.read.parquet(expectedDataPath)
   assertDataFrameEquals(processedData, expectedData)
  }
}