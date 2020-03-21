package com.example.dynamicform.data
import com.google.gson.annotations.SerializedName

data class FormPage(
    val pageNo: Int,
    val pagelabel: String,
    val widgetData: List<WidgetData>
)

data class WidgetData(
    val answer: String,
    @SerializedName("display_type")
    val displayType: String,
    val dropDownList: List<String>,
    val id: Int,
    @SerializedName("is_required")
    val isRequired: Boolean,
    val key: String,
    val label: String,
    val options: List<Option>,
    val order: Int,
    val properties: Properties,
    @SerializedName("show_question")
    val showQuestion: Boolean
)

data class Option(
    @SerializedName("display_name")
    val displayName: String,
    val id: Int,
    val isSelected: Boolean,
    val order: Int,
    val value: String
)

data class Properties(
    val inputType: String
)