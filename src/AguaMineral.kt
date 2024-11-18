class AguaMineral(
    id: Int,
    litros: Double,
    precio: Double,
    marca: String,
    val origen: String
) : Bebidas(id, litros, precio, marca) {
    override fun mostrarInformacion() {
        super.mostrarInformacion()
        println("Origen: $origen")
    }
}