package notion.api.v1.model.blocks

import com.google.gson.annotations.SerializedName
import java.util.*
import notion.api.v1.model.common.ObjectType
import notion.api.v1.model.common.WithObjectType
import notion.api.v1.model.pages.PageProperty

interface Block : WithObjectType {
  val type: BlockType
  var id: String?
  var createdTime: String?
  var lastEditedTime: String?
  var hasChildren: Boolean?

  fun asParagraph(): ParagraphBlock =
      if (type == BlockType.Paragraph) this as ParagraphBlock
      else throw IllegalStateException("Failed to cast $type block to ParagraphBlock")

  fun asHeadingOne(): HeadingOneBlock =
      if (type == BlockType.HeadingOne) this as HeadingOneBlock
      else throw IllegalStateException("Failed to cast $type block to HeadingOneBlock")

  fun asHeadingTwo(): HeadingTwoBlock =
      if (type == BlockType.HeadingTwo) this as HeadingTwoBlock
      else throw IllegalStateException("Failed to cast $type block to HeadingTwoBlock")

  fun asHeadingThree(): HeadingThreeBlock =
      if (type == BlockType.HeadingThree) this as HeadingThreeBlock
      else throw IllegalStateException("Failed to cast $type block to HeadingThreeBlock")

  fun asBulletedListItem(): BulletedListItemBlock =
      if (type == BlockType.BulletedListItem) this as BulletedListItemBlock
      else throw IllegalStateException("Failed to cast $type block to BulletedListItemBlock")

  fun asNumberedListItem(): NumberedListItemBlock =
      if (type == BlockType.NumberedListItem) this as NumberedListItemBlock
      else throw IllegalStateException("Failed to cast $type block to NumberedListItemBlock")

  fun asToDo(): ToDoBlock =
      if (type == BlockType.ToDo) this as ToDoBlock
      else throw IllegalStateException("Failed to cast $type block to ToDoBlock")

  fun asToggle(): ToggleBlock =
      if (type == BlockType.Toggle) this as ToggleBlock
      else throw IllegalStateException("Failed to cast $type block to ToggleBlock")

  fun asChildPage(): ChildPageBlock =
      if (type == BlockType.ChildPage) this as ChildPageBlock
      else throw IllegalStateException("Failed to cast $type block to ChildPageBlock")

  fun asUnsupported(): UnsupportedBlock =
      if (type == BlockType.Unsupported) this as UnsupportedBlock
      else throw IllegalStateException("Failed to cast $type block to UnsupportedBlock")
}

open class ParagraphBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override var type: BlockType = BlockType.Paragraph,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    val paragraph: Element,
) : Block {

  // for other JVM languages
  constructor(
      paragraph: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.Paragraph,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      paragraph)

  open class Element
  @JvmOverloads
  constructor(var text: List<PageProperty.RichText>, var children: List<Block>? = null)
}

open class HeadingOneBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.HeadingOne,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    @SerializedName("heading_1") val heading1: Element,
) : Block {

  // for other JVM languages
  constructor(
      heading1: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.HeadingOne,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      heading1)

  open class Element
  @JvmOverloads
  constructor(
      var text: List<PageProperty.RichText>,
  )
}

open class HeadingTwoBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.HeadingTwo,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    @SerializedName("heading_2") val heading2: Element,
) : Block {

  // for other JVM languages
  constructor(
      heading2: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.HeadingTwo,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      heading2)

  open class Element(
      var text: List<PageProperty.RichText>,
  )
}

open class HeadingThreeBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.HeadingThree,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    @SerializedName("heading_3") val heading3: Element,
) : Block {

  // for other JVM languages
  constructor(
      heading3: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.HeadingThree,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      heading3)

  open class Element
  @JvmOverloads
  constructor(
      var text: List<PageProperty.RichText>,
  )
}

open class BulletedListItemBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.BulletedListItem,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    val bulletedListItem: Element,
) : Block {

  // for other JVM languages
  constructor(
      bulletedListItem: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.BulletedListItem,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      bulletedListItem)

  open class Element
  @JvmOverloads
  constructor(var text: List<PageProperty.RichText>, var children: List<Block>? = null)
}

open class NumberedListItemBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.NumberedListItem,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    val numberedListItem: Element,
) : Block {

  // for other JVM languages
  constructor(
      numberedListItem: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.NumberedListItem,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      numberedListItem)

  open class Element
  @JvmOverloads
  constructor(var text: List<PageProperty.RichText>, var children: List<Block>? = null)
}

open class ToDoBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.ToDo,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    val toDo: Element,
) : Block {

  // for other JVM languages
  constructor(
      toDo: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(ObjectType.Block, BlockType.ToDo, id, createdTime, lastEditedTime, hasChildren, toDo)

  open class Element
  @JvmOverloads
  constructor(
      var checked: Boolean = false,
      var text: List<PageProperty.RichText>? = null,
      var children: List<Block>? = null
  )
}

open class ToggleBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.Toggle,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    val toggle: Element,
) : Block {

  // for other JVM languages
  constructor(
      toggle: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(ObjectType.Block, BlockType.Toggle, id, createdTime, lastEditedTime, hasChildren, toggle)

  open class Element
  @JvmOverloads
  constructor(var text: List<PageProperty.RichText>, var children: List<Block>? = null)
}

open class ChildPageBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.ChildPage,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
    val childPage: Element,
) : Block {

  // for other JVM languages
  constructor(
      childPage: Element,
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(
      ObjectType.Block,
      BlockType.ChildPage,
      id,
      createdTime,
      lastEditedTime,
      hasChildren,
      childPage)

  open class Element @JvmOverloads constructor(var title: String)
}

open class UnsupportedBlock
@JvmOverloads
constructor(
    @SerializedName("object") override val objectType: ObjectType = ObjectType.Block,
    override val type: BlockType = BlockType.Unsupported,
    override var id: String? = UUID.randomUUID().toString(),
    override var createdTime: String? = null,
    override var lastEditedTime: String? = null,
    override var hasChildren: Boolean? = null,
) : Block {

  // for other JVM languages
  constructor(
      id: String? = UUID.randomUUID().toString(),
      hasChildren: Boolean? = null,
      createdTime: String? = null,
      lastEditedTime: String? = null,
  ) : this(ObjectType.Block, BlockType.Unsupported, id, createdTime, lastEditedTime, hasChildren)
}
