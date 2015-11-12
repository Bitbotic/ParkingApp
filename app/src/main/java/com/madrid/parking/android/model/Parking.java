package com.madrid.parking.android.model;

/**
 * Created by Marcin on 23/10/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class Parking implements KvmSerializable,Parcelable {

    public String address;
    public String administrativeArea;
    public String areaCode;
    public String category;
    public String categoryCode;
    public String country;
    public String email;
    public String family;
    public String familyName;
    public String fax;
    public String icon;
    public int id;
    public boolean idSpecified;
    public String latitude;
    public String longitude;
    public String name;
    public String state;
    public String telephone;
    public String town;
    public String type;
    public String typeCode;

    public Parking() {
    }

    public Parking(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("address")) {
            Object obj = soapObject.getProperty("address");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                address = j.toString();
            } else if (obj != null && obj instanceof String) {
                address = (String) obj;
            }
        }
        if (soapObject.hasProperty("administrativeArea")) {
            Object obj = soapObject.getProperty("administrativeArea");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                administrativeArea = j.toString();
            } else if (obj != null && obj instanceof String) {
                administrativeArea = (String) obj;
            }
        }
        if (soapObject.hasProperty("areaCode")) {
            Object obj = soapObject.getProperty("areaCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                areaCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                areaCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("category")) {
            Object obj = soapObject.getProperty("category");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                category = j.toString();
            } else if (obj != null && obj instanceof String) {
                category = (String) obj;
            }
        }
        if (soapObject.hasProperty("categoryCode")) {
            Object obj = soapObject.getProperty("categoryCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                categoryCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                categoryCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("country")) {
            Object obj = soapObject.getProperty("country");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                country = j.toString();
            } else if (obj != null && obj instanceof String) {
                country = (String) obj;
            }
        }
        if (soapObject.hasProperty("email")) {
            Object obj = soapObject.getProperty("email");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                email = j.toString();
            } else if (obj != null && obj instanceof String) {
                email = (String) obj;
            }
        }
        if (soapObject.hasProperty("family")) {
            Object obj = soapObject.getProperty("family");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                family = j.toString();
            } else if (obj != null && obj instanceof String) {
                family = (String) obj;
            }
        }
        if (soapObject.hasProperty("familyName")) {
            Object obj = soapObject.getProperty("familyName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                familyName = j.toString();
            } else if (obj != null && obj instanceof String) {
                familyName = (String) obj;
            }
        }
        if (soapObject.hasProperty("fax")) {
            Object obj = soapObject.getProperty("fax");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                fax = j.toString();
            } else if (obj != null && obj instanceof String) {
                fax = (String) obj;
            }
        }
        if (soapObject.hasProperty("icon")) {
            Object obj = soapObject.getProperty("icon");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                icon = j.toString();
            } else if (obj != null && obj instanceof String) {
                icon = (String) obj;
            }
        }
        if (soapObject.hasProperty("id")) {
            Object obj = soapObject.getProperty("id");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                id = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                id = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("idSpecified")) {
            Object obj = soapObject.getProperty("idSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idSpecified = Boolean.parseBoolean(j.toString());
            } else if (obj != null && obj instanceof Boolean) {
                idSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("latitude")) {
            Object obj = soapObject.getProperty("latitude");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                latitude = j.toString();
            } else if (obj != null && obj instanceof String) {
                latitude = (String) obj;
            }
        }
        if (soapObject.hasProperty("longitude")) {
            Object obj = soapObject.getProperty("longitude");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                longitude = j.toString();
            } else if (obj != null && obj instanceof String) {
                longitude = (String) obj;
            }
        }
        if (soapObject.hasProperty("name")) {
            Object obj = soapObject.getProperty("name");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                name = j.toString();
            } else if (obj != null && obj instanceof String) {
                name = (String) obj;
            }
        }
        if (soapObject.hasProperty("state")) {
            Object obj = soapObject.getProperty("state");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                state = j.toString();
            } else if (obj != null && obj instanceof String) {
                state = (String) obj;
            }
        }
        if (soapObject.hasProperty("telephone")) {
            Object obj = soapObject.getProperty("telephone");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                telephone = j.toString();
            } else if (obj != null && obj instanceof String) {
                telephone = (String) obj;
            }
        }
        if (soapObject.hasProperty("town")) {
            Object obj = soapObject.getProperty("town");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                town = j.toString();
            } else if (obj != null && obj instanceof String) {
                town = (String) obj;
            }
        }
        if (soapObject.hasProperty("type")) {
            Object obj = soapObject.getProperty("type");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                type = j.toString();
            } else if (obj != null && obj instanceof String) {
                type = (String) obj;
            }
        }
        if (soapObject.hasProperty("typeCode")) {
            Object obj = soapObject.getProperty("typeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                typeCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                typeCode = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return address;
            case 1:
                return administrativeArea;
            case 2:
                return areaCode;
            case 3:
                return category;
            case 4:
                return categoryCode;
            case 5:
                return country;
            case 6:
                return email;
            case 7:
                return family;
            case 8:
                return familyName;
            case 9:
                return fax;
            case 10:
                return icon;
            case 11:
                return id;
            case 12:
                return idSpecified;
            case 13:
                return latitude;
            case 14:
                return longitude;
            case 15:
                return name;
            case 16:
                return state;
            case 17:
                return telephone;
            case 18:
                return town;
            case 19:
                return type;
            case 20:
                return typeCode;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 21;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "address";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "administrativeArea";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "areaCode";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "category";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "categoryCode";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "country";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "email";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "family";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "familyName";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "fax";
                break;
            case 10:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "icon";
                break;
            case 11:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 12:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 13:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "latitude";
                break;
            case 14:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "longitude";
                break;
            case 15:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 16:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "state";
                break;
            case 17:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "telephone";
                break;
            case 18:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "town";
                break;
            case 19:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "type";
                break;
            case 20:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "typeCode";
                break;
        }
    }


    public String getInnerText() {
        return null;
    }


    public void setInnerText(String s) {
    }


    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.address);
        dest.writeString(this.administrativeArea);
        dest.writeString(this.areaCode);
        dest.writeString(this.category);
        dest.writeString(this.categoryCode);
        dest.writeString(this.country);
        dest.writeString(this.email);
        dest.writeString(this.family);
        dest.writeString(this.familyName);
        dest.writeString(this.icon);
        dest.writeInt(this.id);
        dest.writeByte((byte) (idSpecified ? 1 : 0));
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeString(this.name);
        dest.writeString(this.state);
        dest.writeString(this.telephone);
        dest.writeString(this.town);
        dest.writeString(this.type);
        dest.writeString(this.typeCode);

    }

    public static final Parcelable.Creator<Parking> CREATOR = new Parcelable.Creator<Parking>() {
        public Parking createFromParcel(Parcel source) {
            return new Parking(source);
        }

        public Parking[] newArray(int size) {
            return new Parking[size];
        }
    };

    private Parking(Parcel in) {
        this.address = in.readString();
        this.administrativeArea = in.readString();
        this.areaCode = in.readString();
        this.category = in.readString();
        this.categoryCode = in.readString();
        this.country = in.readString();
        this.email = in.readString();
        this.family = in.readString();
        this.familyName = in.readString();
        this.icon = in.readString();
        this.id = in.readInt();
        this.idSpecified = in.readByte() != 0;
        this.latitude = in.readString();
        this.longitude = in.readString();
        this.name = in.readString();
        this.state = in.readString();
        this.telephone = in.readString();
        this.town = in.readString();
        this.type = in.readString();
        this.typeCode = in.readString();
    }
}
