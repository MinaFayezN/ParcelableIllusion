package dev.mina.parcelableillusion;

import android.os.Parcel;
import android.os.Parcelable;

class ChildOne extends ParentClass  implements Parcelable{

    String childString = "";
    SecondEnum childEnum = SecondEnum.CHILD_ITEM_ONE;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.childString);
        dest.writeInt(this.childEnum == null ? -1 : this.childEnum.ordinal());
    }

    public ChildOne() {
    }

    protected ChildOne(Parcel in) {
        super(in);
        this.childString = in.readString();
        int tmpChildEnum = in.readInt();
        this.childEnum = tmpChildEnum == -1 ? null : SecondEnum.values()[tmpChildEnum];
    }

    public static final Creator<ChildOne> CREATOR = new Creator<ChildOne>() {
        @Override
        public ChildOne createFromParcel(Parcel source) {
            return new ChildOne(source);
        }

        @Override
        public ChildOne[] newArray(int size) {
            return new ChildOne[size];
        }
    };
}