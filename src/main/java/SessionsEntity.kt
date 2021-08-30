import javax.persistence.*

@Entity
@Table(name = "sessions", schema = "orders", catalog = "")
open class SessionsEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "staff_id", nullable = false, insertable = false, updatable = false)
    var staffId: Int? = null

    @get:Basic
    @get:Column(name = "zakaz_id", nullable = false, insertable = false, updatable = false)
    var zakazId: Int? = null

    @get:Basic
    @get:Column(name = "start_time", nullable = false)
    var startTime: java.sql.Timestamp? = null

    @get:Basic
    @get:Column(name = "hours", nullable = false)
    var hours: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "staff_id", referencedColumnName = "id")
    var refStaffEntity: StaffEntity? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "zakaz_id", referencedColumnName = "or_id")
    var refZakazEntity: ZakazEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "staffId = $staffId " +
                    "zakazId = $zakazId " +
                    "startTime = $startTime " +
                    "hours = $hours " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as SessionsEntity

        if (id != other.id) return false
        if (staffId != other.staffId) return false
        if (zakazId != other.zakazId) return false
        if (startTime != other.startTime) return false
        if (hours != other.hours) return false

        return true
    }

}

