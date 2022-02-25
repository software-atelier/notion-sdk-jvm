package notion.api.v1.model.databases

import com.google.gson.annotations.SerializedName
import notion.api.v1.model.common.*
import notion.api.v1.model.users.User

// This data class does not have setters as developers never manually modify this
data class Database
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Database,
    val id: String,
    val icon: Icon,
    val cover: Cover,
    val url: String,
    val createdTime: String,
    val createdBy: User,
    val lastEditedTime: String,
    val lastEditedBy: User,
    val parent: DatabaseParent? = null,
    val title: List<DatabaseProperty.RichText>,
    val properties: Map<String, DatabaseProperty>,
    val archived: Boolean,
) : WithObjectType
