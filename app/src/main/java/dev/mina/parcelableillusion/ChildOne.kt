package dev.mina.parcelableillusion

import android.os.Parcel
import android.os.Parcelable

class ChildOne() : ParentClass(), Parcelable {

    var childString = ""
    var childEnum = SecondEnum.CHILD_ITEM_ONE

    constructor(parcel: Parcel) : this() {
        super.loadParcel(parcel)
        childString = parcel.readString()!!
        childEnum = SecondEnum.valueOf(parcel.readString()!!)

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        parcel.writeString(childString)
        parcel.writeString(childEnum.name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChildOne> {
        override fun createFromParcel(parcel: Parcel): ChildOne {
            return ChildOne(parcel)
        }

        override fun newArray(size: Int): Array<ChildOne?> {
            return arrayOfNulls(size)
        }
    }


}