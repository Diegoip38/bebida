open class Bebidas (
    val id: Int,
    val litros: Double,
    var precio: Double,
    val marca: String
) {
    open fun mostrarInformacion() {
        println("ID: $id, Litros: $litros, Precio: $precio, Marca: $marca")
    }
}