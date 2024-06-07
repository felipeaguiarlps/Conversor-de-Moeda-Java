import com.google.gson.annotations.SerializedName;

public record JsonStructure(@SerializedName("base_code") String baseCode,
                            @SerializedName ("target_code") String targetCode,
                            @SerializedName ("conversion_result")double conversionResult) {
}
