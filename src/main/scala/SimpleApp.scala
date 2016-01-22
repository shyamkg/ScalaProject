/**
 * Created by shyam on 10/30/15.
 */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    //val logFile = "/Users/shyam/BD/spark150/README.md" // Should be some file on your system
    val logFile1 = args(0)
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]").set("spark.executor.memory","1g").set("spark.eventLog.enabled","false")
    //val conf = new SparkConf().setAppName("Simple Application").setMaster("spark://node1:7077").set("spark.executor.memory","1g");
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile1, 2)
    //val logData = sc.textFile(logFile1,4)
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
