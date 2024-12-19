// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json       = Json { allowStructuredMapKeys = true }
// val sampleData = json.parse(SampleData.serializer(), jsonString)

package quicktype
import kotlinx.serialization.*

@Serializable
data class SampleDatum (
    val id: String,
    val name: String,
    val data: Data? = null
)

@Serializable
data class Data (
    @SerialName("color")
    val dataColor: String? = null,

    @SerialName("capacity")
    val dataCapacity: String? = null,

    @SerialName("capacity GB")
    val capacityGB: Long? = null,

    @SerialName("price")
    val dataPrice: Double? = null,

    @SerialName("generation")
    val dataGeneration: String? = null,

    val year: Long? = null,

    @SerialName("CPU model")
    val cpuModel: String? = null,

    @SerialName("Hard disk size")
    val hardDiskSize: String? = null,

    @SerialName("Strap Colour")
    val strapColour: String? = null,

    @SerialName("Case Size")
    val caseSize: String? = null,

    @SerialName("Color")
    val color: String? = null,

    @SerialName("Description")
    val description: String? = null,

    @SerialName("Capacity")
    val capacity: String? = null,

    @SerialName("Screen size")
    val screenSize: Double? = null,

    @SerialName("Generation")
    val generation: String? = null,

    @SerialName("Price")
    val price: String? = null
)
