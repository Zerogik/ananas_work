import javax.persistence.*

@Entity
@Table(name = "price", schema = "orders", catalog = "")
open class PriceEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null

    @get:Basic
    @get:Column(name = "cst", nullable = false)
    var cst: Int? = null

    @get:OneToMany(mappedBy = "refPriceEntity")
    var refZakazEntities: List<ZakazEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "cst = $cst " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as PriceEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (cst != other.cst) return false

        return true
    }

}

