package example
import com.typesafe.config.ConfigFactory

object Hello extends Greeting with App {
  val config = ConfigFactory.load()
  val answer = config.getString("simple-app.answer") 
  println(greeting)
  println(answer)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
