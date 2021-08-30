import javax.persistence.*

@Entity
@Table(name = "clients", schema = "orders", catalog = "")
open class ClientsEntity {
    @get:Id
    @get:Column(name = "cl_id", nullable = false, insertable = false, updatable = false)
    var clId: Int? = null

    @get:Basic
    @get:Column(name = "cl_name", nullable = false)
    var clName: String? = null

    @get:Basic
    @get:Column(name = "contacts", nullable = false)
    var contacts: String? = null

    @get:Basic
    @get:Column(name = "email", nullable = true)
    var email: String? = null

    @get:Basic
    @get:Column(name = "note", nullable = true)
    var note: String? = null

    @get:OneToMany(mappedBy = "refClientsEntity")
    var refZakazEntities: List<ZakazEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "clId = $clId " +
                    "clName = $clName " +
                    "contacts = $contacts " +
                    "email = $email " +
                    "note = $note " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ClientsEntity

        if (clId != other.clId) return false
        if (clName != other.clName) return false
        if (contacts != other.contacts) return false
        if (email != other.email) return false
        if (note != other.note) return false

        return true
    }

}

