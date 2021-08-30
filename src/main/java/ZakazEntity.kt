import javax.persistence.*

@Entity
@Table(name = "zakaz", schema = "orders", catalog = "")
open class ZakazEntity {
    @get:Id
    @get:Column(name = "or_id", nullable = false, insertable = false, updatable = false)
    var orId: Int? = null

    @get:Basic
    @get:Column(name = "name_price", nullable = true, insertable = false, updatable = false)
    var namePrice: Int? = null

    @get:Basic
    @get:Column(name = "client_id", nullable = false, insertable = false, updatable = false)
    var clientId: Int? = null

    @get:Basic
    @get:Column(name = "pr_name", nullable = true)
    var prName: String? = null

    @get:Basic
    @get:Column(name = "note", nullable = true)
    var note: String? = null

    @get:Basic
    @get:Column(name = "staff_id", nullable = true, insertable = false, updatable = false)
    var staffId: Int? = null

    @get:Basic
    @get:Column(name = "completed", nullable = true)
    var completed: Byte? = null

    @get:Basic
    @get:Column(name = "paid", nullable = true)
    var paid: Byte? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "name_price", referencedColumnName = "name_price")
    var refCostEntity: CostEntity? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "client_id", referencedColumnName = "cl_id")
    var refClientsEntity: ClientsEntity? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "staff_id", referencedColumnName = "id")
    var refStaffEntity: StaffEntity? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "name_price", referencedColumnName = "id")
    var refPriceEntity: PriceEntity? = null

    @get:OneToMany(mappedBy = "refZakazEntity")
    var refSessionsEntities: List<SessionsEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "orId = $orId " +
                    "namePrice = $namePrice " +
                    "clientId = $clientId " +
                    "prName = $prName " +
                    "note = $note " +
                    "staffId = $staffId " +
                    "completed = $completed " +
                    "paid = $paid " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ZakazEntity

        if (orId != other.orId) return false
        if (namePrice != other.namePrice) return false
        if (clientId != other.clientId) return false
        if (prName != other.prName) return false
        if (note != other.note) return false
        if (staffId != other.staffId) return false
        if (completed != other.completed) return false
        if (paid != other.paid) return false

        return true
    }

}

