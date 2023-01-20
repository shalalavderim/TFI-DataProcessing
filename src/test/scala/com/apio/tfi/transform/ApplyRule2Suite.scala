package com.apio.tfi.transform

import java.io.File

import com.apio.tfi.processor.config.DataProcessorConfig
import com.apio.tfi.processor.transform.ApplyRule2
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSuite, Matchers}

/**
 * Unit test for ApplyRule2 transformer
 */
class ApplyRule2Suite extends FunSuite with Matchers {

  val configPath = getClass.getResource("/TFI-DataProcessor.conf").getPath
  val configFile = new File(configPath)
  val tsConfig = ConfigFactory.parseFile(configFile)
  val vConfig = DataProcessorConfig(tsConfig)

  val tc11 = -1
  val tc12 = -1
  val tc21 = 0
  val tc22 = 2000
  val tc31 = 5
  val tc32 = 1500
  val tc41 = 3000
  val tc42 = 1900
  val tc51 = 4000
  val tc52 = 1400
  val tc61 = 5000
  val tc62 = 0

  val expectedTc1 = false
  val expectedTc2 = false
  val expectedTc3 = false
  val expectedTc4 = false
  val expectedTc5 = true
  val expectedTc6 = true

  test("ApplyRule2 Unit Test") {
    val res1 = ApplyRule2(vConfig).applyRule2(tc11, tc12)
    val res2 = ApplyRule2(vConfig).applyRule2(tc21, tc22)
    val res3 = ApplyRule2(vConfig).applyRule2(tc31, tc32)
    val res4 = ApplyRule2(vConfig).applyRule2(tc41, tc42)
    val res5 = ApplyRule2(vConfig).applyRule2(tc51, tc52)
    val res6 = ApplyRule2(vConfig).applyRule2(tc61, tc62)

    assertResult(expectedTc1)(res1)
    assertResult(expectedTc2)(res2)
    assertResult(expectedTc3)(res3)
    assertResult(expectedTc4)(res4)
    assertResult(expectedTc5)(res5)
    assertResult(expectedTc6)(res6)
  }
}