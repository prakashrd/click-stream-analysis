package com.jai.analytics

/**
  * Created by Jai Prakash
  */

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object SparkClient {

  def main(args:Array[String]): Unit = {
    val builder = SparkSession.builder().master("local[*]")
    val spark:SparkSession = SparkSession.
      builder().
      master("local[*]").
      appName("ClickStream").
      getOrCreate()
  }
}
