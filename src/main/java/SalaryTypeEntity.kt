import javax.persistence.*

@Entity
@Table(name = "salary_type", schema = "orders", catalog = "")
open class SalaryTypeEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "sl_name", nullable = true)
    var slName: String? = null

    @get:OneToMany(mappedBy = "refSalaryTypeEntity")
    var refStaffEntities: List<StaffEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "slName = $slName " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as SalaryTypeEntity

        if (id != other.id) return false
        if (slName != other.slName) return false

        return true
    }

}

