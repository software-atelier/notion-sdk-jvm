package notion.api.v1.model.databases.query.filter.condition

open class SelectFilter
@JvmOverloads
constructor(
    var equals: String? = null,
    var doesNotEqual: String? = null,
    var isEmpty: Boolean? = null,
    var isNotEmpty: Boolean? = null,
)
