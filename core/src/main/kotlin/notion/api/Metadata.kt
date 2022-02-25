package notion.api

object Metadata {
  const val VERSION: String = "0.4.3"

  fun isLibraryMaintainerMode(): Boolean {
    val value = System.getenv("NOTION_SDK_JVM_LIBRARY_MAINTAINER_MODE")
    return value != null && ((value == "1") or (value == "true"))
  }
}
