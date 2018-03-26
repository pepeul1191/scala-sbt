package Models
import slick.driver.SQLiteDriver.api._

class TipoEstacion(tag: Tag) extends Table[(Int, String)](tag, "tipo_estaciones") {
  def id = column[Int]("id", O.PrimaryKey) // This is the primary key column
  def nombre = column[String]("nombre")
  def * = (id, nombre)
}