package com.trantordev.shopapp.network.model

data class Products (

	val id : Int,
	val discount_percentage : Int,
	val photos : List<Photos>,
	val title : String,
	val price : Int,
	val original_price : Int,
	val size : Int,
	val likes_count : Int,
	val maximum_installment : Int,
	val published_comments_count : Int,
	val content : String,
	val user : User
)