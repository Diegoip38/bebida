class BebidaAzucarada(
    id: Int,
    litros: Double,
    precio: Double,
    marca: String,
    val porcentajeAzucar: Double,
    val tienePromocion: Boolean
) : Bebidas(id, litros, precio, marca) {
    init {
        if (tienePromocion) {
         precio * 0.9
        }
    }

    override fun mostrarInformacion() {
        super.mostrarInformacion()
        println("Porcentaje Azúcar: $porcentajeAzucar, Promoción: $tienePromocion")
    }
}