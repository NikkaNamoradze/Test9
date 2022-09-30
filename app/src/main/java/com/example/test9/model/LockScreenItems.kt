package com.example.test9.model

data class LockScreenItems(
    val number: Int?,
    val isDeleteButton: Boolean,
    val isFingerprint: Boolean
)


var listOfItems =
    listOf(
        LockScreenItems(number = 1, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 2, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 3, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 4, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 5, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 6, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 7, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 8, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(number = 9, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(isFingerprint = true, number = null, isDeleteButton = false),
        LockScreenItems(number = 0, isDeleteButton = false, isFingerprint = false),
        LockScreenItems(isDeleteButton = true, number = null, isFingerprint = false)
    )
