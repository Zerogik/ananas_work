import javax.persistence.*

@Entity
@Table(name = "staff", schema = "orders", catalog = "")
open class StaffEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "st_name", nullable = false)
    var stName: String? = null

    @get:Basic
    @get:Column(name = "username", nullable = false)
    var username: String? = null

    @get:Basic
    @get:Column(name = "password", nullable = false)
    var password: String? = null

    @get:Basic
    @get:Column(name = "contact", nullable = false)
    var contact: String? = null

    @get:Basic
    @get:Column(name = "email", nullable = false)
    var email: String? = null

    @get:Basic
    @get:Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    var roleId: Int? = null

    @get:Basic
    @get:Column(name = "activity", nullable = true)
    var activity: Byte? = null

    @get:Basic
    @get:Column(name = "salary_id", nullable = false, insertable = false, updatable = false)
    var salaryId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "role_id", referencedColumnName = "id")
    var refRoleEntity: RoleEntity? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "salary_id", referencedColumnName = "id")
    var refSalaryTypeEntity: SalaryTypeEntity? = null

    @get:OneToMany(mappedBy = "refStaffEntity")
    var refZakazEntities: List<ZakazEntity>? = null

    @get:OneToMany(mappedBy = "refStaffEntity")
    var refSessionsEntities: List<SessionsEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "stName = $stName " +
                    "username = $username " +
                    "password = $password " +
                    "contact = $contact " +
                    "email = $email " +
                    "roleId = $roleId " +
                    "activity = $activity " +
                    "salaryId = $salaryId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as StaffEntity

        if (id != other.id) return false
        if (stName != other.stName) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (contact != other.contact) return false
        if (email != other.email) return false
        if (roleId != other.roleId) return false
        if (activity != other.activity) return false
        if (salaryId != other.salaryId) return false

        return true
    }

}

