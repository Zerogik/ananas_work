import javax.persistence.*

@Entity
@Table(name = "cost", schema = "orders", catalog = "")
open class CostEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "name_price", nullable = true, insertable = false, updatable = false)
    var namePrice: Int? = null

    @get:Basic
    @get:Column(name = "hours", nullable = true)
    var hours: Int? = null

    @get:OneToMany(mappedBy = "refCostEntity")
    var refZakazEntities: List<ZakazEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "namePrice = $namePrice " +
                    "hours = $hours " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CostEntity

        if (id != other.id) return false
        if (namePrice != other.namePrice) return false
        if (hours != other.hours) return false

        return true
    }

}

