package notion.api.v1.request.blocks

import notion.api.v1.request.common.Pagination

// var is intentional here (for the easiness in other JVM languages)
data class RetrieveBlockChildrenRequest(
    val blockId: String,
    override var startCursor: String? = null,
    override var pageSize: Int? = null,
) : Pagination {

    // For other JVM languages
    constructor(blockId: String) : this(blockId, null, null)

    fun toQuery(): Map<String, String> {
        val body = mutableMapOf<String, String>()
        if (startCursor != null) {
            body["start_cursor"] = startCursor!!
        }
        if (pageSize != null) {
            body["page_size"] = pageSize.toString()
        }
        return body
    }
}
