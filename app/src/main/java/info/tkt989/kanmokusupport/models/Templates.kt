package info.tkt989.kanmokusupport.models

data class Situation(val title: String, val templates: List<Template>) {

}

data class Template(val content: String) {

}