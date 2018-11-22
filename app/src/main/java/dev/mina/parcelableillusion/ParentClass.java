package dev.mina.parcelableillusion;

import android.os.Parcel;
import android.os.Parcelable;

class ParentClass implements Parcelable {

    int firstNo = 0;
    int secondNo = 0;

    String firstText = "";

    FirstEnum enumItem = FirstEnum.ITEM_ONE;

//    constructor(parcel:Parcel) :this()
//
//    {
//        loadParcel(parcel)
//    }
//
//    fun loadParcel(parcel:Parcel) {
//        firstNo = parcel.readInt()
//        secondNo = parcel.readInt()
//        firstText = parcel.readString() !!
//                enumItem = FirstEnum.valueOf(parcel.readString() !!)
//    }
//
//    override fun
//
//    writeToParcel(parcel:Parcel, flags:Int) {
//        parcel.writeInt(firstNo)
//        parcel.writeInt(secondNo)
//        parcel.writeString(firstText)
//        parcel.writeString(enumItem.name)
//
//    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.firstNo);
        dest.writeInt(this.secondNo);
        dest.writeString(this.firstText);
        dest.writeString(this.enumItem.toString());
    }

    public ParentClass() {
    }

    protected ParentClass(Parcel in) {
        this.firstNo = in.readInt();
        this.secondNo = in.readInt();
        this.firstText = in.readString();
        this.enumItem = FirstEnum.valueOf(in.readString());
    }

}