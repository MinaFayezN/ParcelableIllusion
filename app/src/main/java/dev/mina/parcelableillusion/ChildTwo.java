package dev.mina.parcelableillusion;

import android.os.Parcel;
import android.os.Parcelable;

class ChildTwo extends ParentClass implements Parcelable {

    int childNo = 0;
    String childText = "";


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.childNo);
        dest.writeString(this.childText);
    }

    public ChildTwo() {
    }

    protected ChildTwo(Parcel in) {
        super(in);
        this.childNo = in.readInt();
        this.childText = in.readString();
    }

    public static final Creator<ChildTwo> CREATOR = new Creator<ChildTwo>() {
        @Override
        public ChildTwo createFromParcel(Parcel source) {
            return new ChildTwo(source);
        }

        @Override
        public ChildTwo[] newArray(int size) {
            return new ChildTwo[size];
        }
    };
}