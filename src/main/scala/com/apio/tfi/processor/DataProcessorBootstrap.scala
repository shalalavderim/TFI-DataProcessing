package com.apio.tfi.processor

import com.apio.tfi.infrastructure.DatabricksApp
import com.apio.tfi.processor.config.{DataProcessorConfig, DataProcessorConfigUtils}
import com.apio.tfi.processor.job.DataProcessor

/**
 * This is the main class of the executable jar.
 * It orchestrates calling of other components of the job.
 */
object DataProcessorBootstrap extends DatabricksApp {
  println("Reading Configuration ...")
  val tsConfig = DataProcessorConfigUtils.readConfigFromDBFS(args(0))
  val vConfig = DataProcessorConfig(tsConfig)

  println(s"Processing Master Data ...")
  val dataProcessor = new DataProcessor(vConfig, spark)
  dataProcessor.writeData(dataProcessor.processData(dataProcessor.readData()))

}