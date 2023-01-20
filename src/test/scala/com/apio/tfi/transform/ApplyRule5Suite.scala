package com.apio.tfi.transform

import java.io.File

import com.apio.tfi.processor.config.DataProcessorConfig
import com.apio.tfi.processor.transform.ApplyRule5
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSuite, Matchers}

/**
 * Unit test for ApplyRule5 transformer
 */
class ApplyRule5Suite extends FunSuite with Matchers {

  val configPath = getClass.getResource("/TFI-DataProcessor.conf").getPath
  val configFile = new File(configPath)
  val tsConfig = ConfigFactory.parseFile(configFile)
  val vConfig = DataProcessorConfig(tsConfig)

  val tc11 = null
  val tc12 = null
  val tc13 = -1
  val tc21 = null
  val tc22 = "DIESEL"
  val tc23 = 500
  val tc31 = "VOLVO"
  val tc32 = "BENZIN"
  val tc33 = 1000
  val tc41 = "MERCEDES"
  val tc42 = "DIESEL"
  val tc43 = 1200
  val tc51 = "MERCEDES"
  val tc52 = "ELECTRIC"
  val tc53 = 3000
  val tc61 = "VOLVO"
  val tc62 = "ELECTRIC"
  val tc63 = 3200
  val tc71 = "MERCEDES"
  val tc72 = "DIESEL"
  val tc73 = 3400
  val tc81 = " volvo"
  val tc82 = "DiEsEL"
  val tc83 = 3600
  
  
  val expectedTc1 = false
  val expectedTc2 = false
  val expectedTc3 = false
  val expectedTc4 = false
  val expectedTc5 = false
  val expectedTc6 = false
  val expectedTc7 = false
  val expectedTc8 = true

  test("ApplyRule5 Unit Test") {
    val res1 = ApplyRule5(vConfig).applyRule5(tc11, tc12, tc13)
    val res2 = ApplyRule5(vConfig).applyRule5(tc21, tc22, tc23)
    val res3 = ApplyRule5(vConfig).applyRule5(tc31, tc32, tc33)
    val res4 = ApplyRule5(vConfig).applyRule5(tc41, tc42, tc43)
    val res5 = ApplyRule5(vConfig).applyRule5(tc51, tc52, tc53)
    val res6 = ApplyRule5(vConfig).applyRule5(tc61, tc62, tc63)
    val res7 = ApplyRule5(vConfig).applyRule5(tc71, tc72, tc73)
    val res8 = ApplyRule5(vConfig).applyRule5(tc81, tc82, tc83)

    assertResult(expectedTc1)(res1)
    assertResult(expectedTc2)(res2)
    assertResult(expectedTc3)(res3)
    assertResult(expectedTc4)(res4)
    assertResult(expectedTc5)(res5)
    assertResult(expectedTc6)(res6)
    assertResult(expectedTc7)(res7)
    assertResult(expectedTc8)(res8)
  }
}