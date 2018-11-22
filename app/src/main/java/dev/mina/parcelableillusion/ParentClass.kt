package dev.mina.parcelableillusion

import android.os.Parcel
import android.os.Parcelable

open class ParentClass() : Parcelable {

    var firstNo: Int = 0
    var secondNo: Int = 0

    var firstText: String = ""

    var enumItem = FirstEnum.ITEM_ONE

    constructor(parcel: Parcel) : this() {
        loadParcel(parcel)
    }

    fun loadParcel(parcel: Parcel) {
        firstNo = parcel.readInt()
        secondNo = parcel.readInt()
        firstText = parcel.readString()!!
        enumItem = FirstEnum.valueOf(parcel.readString()!!)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(firstNo)
        parcel.writeInt(secondNo)
        parcel.writeString(firstText)
        parcel.writeString(enumItem.name)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ParentClass> {
        override fun createFromParcel(parcel: Parcel): ParentClass {
            return ParentClass(parcel)
        }

        override fun newArray(size: Int): Array<ParentClass?> {
            return arrayOfNulls(size)
        }
    }


}