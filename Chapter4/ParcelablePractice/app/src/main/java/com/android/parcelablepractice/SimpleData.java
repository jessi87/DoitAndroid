package com.android.parcelablepractice;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable { // 인텐트로 객체를 전달하기 위한 클래스, 객체를 직접 번들에 추가하여 데이터 전송

    int number;
    String message;

    public SimpleData(int number, String message) { //생성자
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel src) { //생성자 / Parcel 객체의 데이터를 읽어들임
        number = src.readInt();
        message = src.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { //객체가 가지고 있는 데이터를 Parcel 객체로 만듬
        dest.writeInt(number);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Parcel 객체로부터 데이터를 읽어 들여 객체를 생성
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { //CREATOR 상수 정의
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in); //SimpleData 생성자를 호출해 Parcel 객체에서 읽기
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };
}
