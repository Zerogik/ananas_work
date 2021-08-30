import javax.persistence.*

@Entity
@Table(name = "role", schema = "orders", catalog = "")
open class RoleEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "rl_name", nullable = true)
    var rlName: String? = null

    @get:OneToMany(mappedBy = "refRoleEntity")
    var refStaffEntities: List<StaffEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "rlName = $rlName " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RoleEntity

        if (id != other.id) return false
        if (rlName != other.rlName) return false

        return true
    }

}

