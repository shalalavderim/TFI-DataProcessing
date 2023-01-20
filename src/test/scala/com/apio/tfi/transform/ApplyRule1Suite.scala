package com.apio.tfi.transform

import java.io.File

import com.apio.tfi.processor.config.DataProcessorConfig
import com.apio.tfi.processor.transform.ApplyRule1
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSuite, Matchers}

/**
 * Unit test for ApplyRule1 transformer
 */
class ApplyRule1Suite extends FunSuite with Matchers {

  val configPath = getClass.getResource("/TFI-DataProcessor.conf").getPath
  val configFile = new File(configPath)
  val tsConfig = ConfigFactory.parseFile(configFile)
  val vConfig = DataProcessorConfig(tsConfig)

  val tc1 = -999
  val tc2 = -1
  val tc3 = 500
  val tc4 = 5000
  val tc5 = 0
  val tc6 = 3650

  val expectedTc1 = false
  val expectedTc2 = false
  val expectedTc3 = false
  val expectedTc4 = true
  val expectedTc5 = false
  val expectedTc6 = true

  test("ApplyRule1 Unit Test") {
    val res1 = ApplyRule1(vConfig).applyRule1(tc1)
    val res2 = ApplyRule1(vConfig).applyRule1(tc2)
    val res3 = ApplyRule1(vConfig).applyRule1(tc3)
    val res4 = ApplyRule1(vConfig).applyRule1(tc4)
    val res5 = ApplyRule1(vConfig).applyRule1(tc5)
    val res6 = ApplyRule1(vConfig).applyRule1(tc6)

    assertResult(expectedTc1)(res1)
    assertResult(expectedTc2)(res2)
    assertResult(expectedTc3)(res3)
    assertResult(expectedTc4)(res4)
    assertResult(expectedTc5)(res5)
    assertResult(expectedTc6)(res6)
  }
}