package com.example.seekhoassignment.data.model.anime_detail_response

import com.google.gson.annotations.SerializedName


data class AnimeDetailResponseDTO(

    @SerializedName("data") var data: Data? = Data()

)


data class Jpg(

    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("small_image_url") var smallImageUrl: String? = null,
    @SerializedName("large_image_url") var largeImageUrl: String? = null

)


data class Webp(

    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("small_image_url") var smallImageUrl: String? = null,
    @SerializedName("large_image_url") var largeImageUrl: String? = null

)


data class Images(

    @SerializedName("jpg") var jpg: Jpg? = Jpg(),
    @SerializedName("webp") var webp: Webp? = Webp()

)


data class ImagesTrailer(

    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("small_image_url") var smallImageUrl: String? = null,
    @SerializedName("medium_image_url") var mediumImageUrl: String? = null,
    @SerializedName("large_image_url") var largeImageUrl: String? = null,
    @SerializedName("maximum_image_url") var maximumImageUrl: String? = null

)


data class Trailer(

    @SerializedName("youtube_id") var youtubeId: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("embed_url") var embedUrl: String? = null,
    @SerializedName("images") var images: ImagesTrailer? = ImagesTrailer()

)


data class Titles(

    @SerializedName("type") var type: String? = null,
    @SerializedName("title") var title: String? = null

)


data class From(

    @SerializedName("day") var day: Int? = null,
    @SerializedName("month") var month: Int? = null,
    @SerializedName("year") var year: Int? = null

)


data class To(

    @SerializedName("day") var day: Int? = null,
    @SerializedName("month") var month: Int? = null,
    @SerializedName("year") var year: Int? = null

)


data class Prop(

    @SerializedName("from") var from: From? = From(),
    @SerializedName("to") var to: To? = To()

)


data class Aired(

    @SerializedName("from") var from: String? = null,
    @SerializedName("to") var to: String? = null,
    @SerializedName("prop") var prop: Prop? = Prop(),
    @SerializedName("string") var string: String? = null

)


data class Broadcast(

    @SerializedName("day") var day: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("timezone") var timezone: String? = null,
    @SerializedName("string") var string: String? = null

)


data class Producers(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Licensors(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Studios(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Genres(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Themes(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Demographics(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Data(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("images") var images: Images? = Images(),
    @SerializedName("trailer") var trailer: Trailer? = Trailer(),
    @SerializedName("approved") var approved: Boolean? = null,
    @SerializedName("titles") var titles: ArrayList<Titles> = arrayListOf(),
    @SerializedName("title") var title: String? = null,
    @SerializedName("title_english") var titleEnglish: String? = null,
    @SerializedName("title_japanese") var titleJapanese: String? = null,
    @SerializedName("title_synonyms") var titleSynonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("type") var type: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("episodes") var episodes: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("airing") var airing: Boolean? = null,
    @SerializedName("aired") var aired: Aired? = Aired(),
    @SerializedName("duration") var duration: String? = null,
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("score") var score: Double? = null,
    @SerializedName("scored_by") var scoredBy: Int? = null,
    @SerializedName("rank") var rank: Int? = null,
    @SerializedName("popularity") var popularity: Int? = null,
    @SerializedName("members") var members: Int? = null,
    @SerializedName("favorites") var favorites: Int? = null,
    @SerializedName("synopsis") var synopsis: String? = null,
    @SerializedName("background") var background: String? = null,
    @SerializedName("season") var season: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("broadcast") var broadcast: Broadcast? = Broadcast(),
    @SerializedName("producers") var producers: ArrayList<Producers> = arrayListOf(),
    @SerializedName("licensors") var licensors: ArrayList<Licensors> = arrayListOf(),
    @SerializedName("studios") var studios: ArrayList<Studios> = arrayListOf(),
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("themes") var themes: ArrayList<Themes> = arrayListOf(),
    @SerializedName("demographics") var demographics: ArrayList<Demographics> = arrayListOf()

)