package Main
import com.typesafe.config.ConfigFactory
import slick.driver.SQLiteDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import Models.TipoEstacion

object Hello extends Greeting with App {
  val config = ConfigFactory.load()
  val answer = config.getString("simple-app.answer") 
  println(greeting)
  println(answer)
  val db = Database.forConfig("db")
  try {
    val tipoEstaciones = TableQuery[TipoEstacion]
    println("1 +++++++++++++++++++")
    db.run(tipoEstaciones.result).map(_.foreach {
      case (id, nombre) =>
        println("  " + id + "\t" + nombre)
    })
    println("2 +++++++++++++++++++")
  } catch {
    case e: Exception => println("ERROR")
    case _: Throwable => println("ERROR FATAL")
  }finally {
    db.close
  }
  println("XD")

}

trait Greeting {
  lazy val greeting: String = "hello"
}
