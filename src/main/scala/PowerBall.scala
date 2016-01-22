package main.scala
//import scala.io._//import org.apache.spark.SparkContext._
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

import org.apache.spark.SparkConf

object PowerBall {
  def main(args: Array[String]): Unit = {
    case class PB(dt: String, b1: String, b2: String, b3: String, b4: String, b5: String, pb: String, pp: String)
    case class PB1(key:String, value:String)

    //val conf = new SparkConf().setAppName("Powerball").setMaster("local[*]").set("spark.executor.memory", "1g").set("spark.eventLog.enabled", "false")
    //val urlString: String ="http://www.powerball.com/powerball/winnums-text.txt"
    val conf = new SparkConf().setAppName("Powerball").setMaster("spark://192.168.1.39:7077")
      //.set("spark.executor.memory", "1g").set("spark.eventLog.enabled", "false")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    //val data = Source.fromURL(urlString).getLines() //val dataRDD = sc.parallelize(data.mkString,4) //dataRDD.foreach(println) // dataRDD.saveAsTextFile("/Users/shyam/tmp/data")
   val filePath = "/Users/shyam/Downloads/powerball.txt"
   val dataRDD = sc.textFile(filePath)
   // val data2015RDD = dataRDD.filter(a => a.contains("2015"))
    //val data2014RDD = dataRDD.filter(a => a.contains("2014"))
    val data2016RDD = dataRDD.filter(a => a.contains("2016"))
    //val data2015_2016RDD = data2015RDD.union(data2016RDD)
    //data2015_2016RDD.take(1000).foreach(println)
    //data2015_2016RDD.foreach(println) //data2015_2016RDD.foreach(a => a.split(" ").map(println) )
    //val powerball1 = sc.textFile(filePath).map(_.split(" ")).map(p => PB(p(0), p(1), p(2), p(3), p(4), p(5), p(6), p(7)))
    //val powerballdata = data2016RDD.map(a => a.split(" ")).map(p => PB(p(0), p(2), p(4), p(6), p(8), p(10), p(12), p(14)))
    //val powerballdata1 = data2016RDD.map(a => a.split(" ")).map(p => List(p(2), p(4), p(6), p(8), p(10), p(12), p(14)))
    val powerballdt1 = data2016RDD.flatMap(a => a.split(" "))
    //powerballdata1.take(10).foreach(println)
    powerballdt1.take(100).foreach(println)
  }
}
