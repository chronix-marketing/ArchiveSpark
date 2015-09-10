package de.l3s.archivespark

/**
 * Created by holzmann on 07.08.2015.
 */
class ResolvedCdxRecord(original: CdxRecord, locationPath: String, val parentRecord: CdxRecord) {
  def surtUrl = original.surtUrl
  def timestamp = original.timestamp
  def originalUrl = original.originalUrl
  def mime = original.mime
  def status = original.status
  def digest = original.digest
  def redirectUrl = original.redirectUrl
  def meta = original.meta
  val location = new LocationInfo(original.location.compressedSize, original.location.offset, original.location.filename, locationPath)

  def toJson: Map[String, Any] = {
    if (parentRecord != null) {
      parentRecord.toJson ++ Map[String, Any](
        "original" -> original.toJson
      )
    } else {
      original.toJson
    }
  }
}
